package daos

import models.Runway

import scala.concurrent.Future

trait RunwayDAO {
  def findRunwaysByAirportId(airportId: String): Future[List[Runway]]
}
