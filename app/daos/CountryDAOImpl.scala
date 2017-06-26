package daos
import javax.inject.Inject

import models.Country

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import kantan.csv._
import kantan.csv.ops._
import kantan.csv.generic._

class CountryDAOImpl @Inject() extends CountryDAO {
  val countries = getClass.getResource("/resources/countries.csv").asCsvReader[Country](rfc.withHeader)
    .toList.map(_.get)
  override def findByName(name: String): Future[Option[Country]] = Future {
    countries.find(_.name.toUpperCase == name.toUpperCase)
  }

  override def findByCode(code: String): Future[Option[Country]] = Future {
    countries.find(_.code.toUpperCase == code.toUpperCase)
  }
}
