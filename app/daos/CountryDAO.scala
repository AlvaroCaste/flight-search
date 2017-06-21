package daos

import models.Country

import scala.concurrent.Future

trait CountryDAO {
  def findByName(name: String): Future[Option[Country]]
}
