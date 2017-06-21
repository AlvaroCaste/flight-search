package daos
import models.Country

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

import kantan.csv._
import kantan.csv.ops._
import kantan.csv.generic._

class CountryDAOImpl extends CountryDAO {
  override def findByName(name: String): Future[Option[Country]] = Future {
    val countries = getClass.getResource("/resources/countries.csv").asCsvReader[Country](rfc.withHeader)
      .toList.map(_.get)
    countries.find(_.name.toUpperCase == name.toUpperCase)
  }
}
