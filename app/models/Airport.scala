package models

case class Airport(id: String,
                   ident: String,
                   `type`: String,
                   name: String,
                   latitudeDeg: Double,
                   longitudeDeg: Double,
                   elevationFt: Option[Int],
                   continent: String,
                   isoCountry: String,
                   isoRegion: String,
                   Municipality: String,
                   ScheduledService: String,
                   GPSCode: String,
                   IATACode: String,
                   LocalCode: String,
                   HomeLink: String,
                   Wikipedia: String,
                   keywords: String) {
  require(latitudeDeg < 90 || latitudeDeg > -90, "Latitude must be between -90 and 90")
  require(longitudeDeg < 180 || longitudeDeg > -180, "Longitude must be between -180 and 180")
}
