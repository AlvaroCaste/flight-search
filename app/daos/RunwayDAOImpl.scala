package daos
import models.Runway

import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

import kantan.csv._
import kantan.csv.ops._
import kantan.csv.generic._

class RunwayDAOImpl extends RunwayDAO {
  override def findRunwaysByAirportId(airportId: String): Future[List[Runway]] = Future {
    val runways = getClass.getResource("/resources/runways.csv").asCsvReader[Runway](rfc.withHeader).
      toList.map(_.get)
    runways.filter(_.airportRef == airportId)
  }
}
