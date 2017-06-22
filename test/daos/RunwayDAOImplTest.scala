package daos

import models.Runway
import org.scalatest.{AsyncFlatSpec, Matchers}

class RunwayDAOImplTest extends AsyncFlatSpec with Matchers {

  behavior of "RunwayDAOImpl"

  private val runwayDAOImpl = new RunwayDAOImpl

  it should "find runways from an airport ID" in {
    val airportId = "4019" // Adolfo Suárez Madrid–Barajas Airport
    val runwaysFound = List(
        Runway("238903", "4019", "LEMD", Some(11483), Some(197), "ASP", 1, 0,	"14L", Some(40.4949), Some(-3.55787),
          Some(1942), Some(144.2), None, "32R",	Some(40.47), Some(-3.53258), Some(1876), Some(324.2), Some(1640)),
      Runway("238902", "4019", "LEMD", Some(13084), Some(197), "ASP", 1, 0,	"14R", Some(40.4849), Some(-3.57601),
        Some(1995), Some(144.2), None, "32L",	Some(40.4557), Some(-3.54638), Some(1909), Some(324.2), Some(3445)),
      Runway("238905", "4019", "LEMD", Some(11483), Some(197), "ASP", 1, 0,	"18L", Some(40.5326), Some(-3.55938),
        Some(1919), Some(181), Some(1640), "36R",	Some(40.5011), Some(-3.55921), Some(1942), Some(1), None),
      Runway("238904", "4019", "LEMD", Some(13711), Some(197), "ASP", 1, 0,	"18R", Some(40.5318), Some(-3.57485),
        Some(1998), Some(181), Some(3232), "36L",	Some(40.4926), Some(-3.57463), Some(1985), Some(1.7), None))
    runwayDAOImpl.findRunwaysByAirportId(airportId)
      .map(_ should contain theSameElementsAs runwaysFound)
  }

  it should "not find any runways" in {
    val nonAirportId = "0000"
    runwayDAOImpl.findRunwaysByAirportId(nonAirportId)
      .map(_ shouldBe empty)
  }
}
