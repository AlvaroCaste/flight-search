package daos

import org.scalatest.{AsyncFlatSpec, Matchers}

class AirportDAOImplTest extends AsyncFlatSpec with Matchers {

  behavior of "AirportDAOImpl"

  it should "find airports from ISO country" in {
    val airportDAOImpl = new AirportDAOImpl
    val isoCountry = "AG" // Antigua and Barbuda
    val airportsFound = List("V.C. Bird International Airport",
      "Codrington Airport",
      "Coco Point Lodge Airstrip")
    airportDAOImpl.findAirportsByISOCountry(isoCountry)
      .map(_.map(_.name) should contain theSameElementsAs airportsFound)
  }

  it should "not find an airport" in {
    val airportDAOImpl = new AirportDAOImpl
    val nonIsoCountry = "XX"
    airportDAOImpl.findAirportsByISOCountry(nonIsoCountry)
      .map(_ shouldBe empty)
  }

}
