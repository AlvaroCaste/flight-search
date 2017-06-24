package controllers

import javax.inject.Inject

import daos.{AirportDAO, CountryDAO, RunwayDAO}
import play.api.mvc.{Action, Controller}
import play.api.libs.concurrent.Execution.Implicits.defaultContext

import scala.concurrent.Future

class AirportController @Inject() (airportDAO: AirportDAO, countryDAO: CountryDAO, runwayDAO: RunwayDAO)
  extends Controller {

  def get(country: String) = Action.async {
    for {
      countryO <- countryDAO.findByName(country)
      country = countryO.get
      airports <- airportDAO.findAirportsByISOCountry(country.code)
      runways <- traverseToMap(airports)(airport => runwayDAO.findRunwaysByAirportId(airport.id))
    } yield {
      Ok(views.html.airports(country, runways))
    }
  }

  private def traverseToMap[A,B](keys: List[A])(f: A => Future[B]): Future[Map[A,B]] = Future.traverse(keys){
    key => f(key).map(value => key -> value)
  }.map(_.toMap)
}
