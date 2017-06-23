package modules

import com.google.inject.AbstractModule
import daos._
import net.codingwell.scalaguice.ScalaModule


class BaseModule extends AbstractModule with ScalaModule {

  def configure(): Unit = {
    bind[AirportDAO].to[AirportDAOImpl]
    bind[CountryDAO].to[CountryDAOImpl]
    bind[RunwayDAO].to[RunwayDAOImpl]
  }
}
