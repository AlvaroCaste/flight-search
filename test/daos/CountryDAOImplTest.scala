package daos

import org.scalatest.{AsyncFlatSpec, Matchers}

class CountryDAOImplTest extends AsyncFlatSpec with Matchers {

  behavior of "CountryDaoImpl"

  it should "find a Country by its name" in {
    val countryDAOImpl = new CountryDAOImpl
    val countryName = "Spain"
    countryDAOImpl.findByName(countryName).map(_.get.name shouldBe countryName)
  }

  it should "not find a Country when it doesn't exist" in {
    val countryDAOImpl = new CountryDAOImpl
    val nonCountry = "nonCountry"
    countryDAOImpl.findByName(nonCountry).map(_ shouldBe None)
  }

}
