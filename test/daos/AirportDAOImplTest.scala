package daos

import org.scalatest.{AsyncFlatSpec, Matchers}

class AirportDAOImplTest extends AsyncFlatSpec with Matchers {

  behavior of "AirportDAOImpl"

  private val airportDAOImpl = new AirportDAOImpl

  it should "find airports from ISO country" in {
    val isoCountry = "AG" // Antigua and Barbuda
    val airportsFound = List("V.C. Bird International Airport",
      "Codrington Airport",
      "Coco Point Lodge Airstrip")
    airportDAOImpl.findAirportsByISOCountry(isoCountry)
      .map(_.map(_.name) should contain theSameElementsAs airportsFound)
  }

  it should "not find an airport" in {
    val nonIsoCountry = "XX"
    airportDAOImpl.findAirportsByISOCountry(nonIsoCountry)
      .map(_ shouldBe empty)
  }

}
