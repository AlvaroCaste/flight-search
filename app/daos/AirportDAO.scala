package daos

import models.Airport

import scala.concurrent.Future

trait AirportDAO {
  def findAirportsByISOCountry(isoCountry: String): Future[List[Airport]]
  def findHighestNumberAirportsPerCountry(n: Int): Future[List[(String, List[Airport])]]
}
