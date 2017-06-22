package daos
import models.Airport

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

import kantan.csv._
import kantan.csv.ops._
import kantan.csv.generic._

class AirportDAOImpl extends AirportDAO {
  override def findAirportsByISOCountry(isoCountry: String): Future[List[Airport]] = Future {
    val airports = getClass.getResource("/resources/airports.csv").asCsvReader[Airport](rfc.withHeader).
      toList.map(_.get)
    airports.filter(_.isoCountry.toUpperCase == isoCountry.toUpperCase)
  }
}
