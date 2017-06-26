package daos
import javax.inject.Inject

import models.Airport

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import kantan.csv._
import kantan.csv.ops._
import kantan.csv.generic._

class AirportDAOImpl @Inject() extends AirportDAO {
  val airports = getClass.getResource("/resources/airports.csv").asCsvReader[Airport](rfc.withHeader).
    toList.map(_.get)
  override def findAirportsByISOCountry(isoCountry: String): Future[List[Airport]] = Future {
    airports.filter(_.isoCountry.toUpperCase == isoCountry.toUpperCase)
  }

  override def findHighestNumberAirportsPerCountry(n: Int): Future[List[(String, List[Airport])]] = Future {
    airports.groupBy(_.isoCountry).toList.sortWith(_._2.length > _._2.length).take(n)
  }
}
