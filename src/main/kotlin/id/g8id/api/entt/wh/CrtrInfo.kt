package ai.bitflow.api.comn.entt


import io.quarkus.mongodb.panache.kotlin.PanacheMongoCompanion
import io.quarkus.mongodb.panache.kotlin.PanacheMongoEntity
import java.time.LocalDateTime
import java.time.ZoneOffset


class CrtrInfo : PanacheMongoEntity {

  constructor() : super()

  constructor(programToken: String, token: String, clientUserId: String, profileType: String, email: String, language: String
          , firstName: String, lastName: String) : super() {
    this.programToken = programToken
    this.token        = token
    this.clientUserId = clientUserId
    this.profileType  = profileType
    this.email        = email
    this.language     = language
    this.firstName    = firstName
    this.lastName     = lastName
  }

  lateinit var programToken: String // "prg-6a1d5641-5368-48f8-8246-03e1233d4d36"
  lateinit var token: String        // "usr-f9154016-94e8-4686-a840-075688ac07b5",

  lateinit var clientUserId: String // "t-1701221686711",
  lateinit var profileType: String  // "INDIVIDUAL",
  lateinit var email: String        // "t-1701221686711@email.com",
  lateinit var language: String     // "en"
  lateinit var firstName: String    // "John",
  lateinit var lastName: String     // "Developer",

  var rgstUserId: String? = null   // admin id at JWT
  var updtUserId: String? = null   // admin id at JWT

  var middleName: String? = null // "John",
  var dateOfBirth: String? = null // "1991-02-15",
  var countryOfBirth: String? = null
  var countryOfNationality: String? = null
  var phoneNumber: String? = null
  var mobileNumber: String? = null
  var governmentId: String? = null
  var governmentIdType: String? = null // PASSPORT, NATIONAL_ID_CARD
  var passportId: String? = null
  var driversLicenseId: String? = null
  var employerId: String? = null

  var addressLine1: String? = null // "575 Market St",
  var addressLine2: String? = null // "575 Market St",

  var city: String? = null // San Francisco",
  var stateProvince: String? = null // "CA",
  var country: String? = null // "US",
  var postalCode: String? = null // "94105",
  var businessType: String? = null // CORPORATION (default) PRIVATE_COMPANY PARTNERSHIP NOT_FOR_PROFIT_ ORGANIZATION GOVERNMENT_ENTITY PUBLIC_COMPANY
  var businessRegistrationId: String? = null
  var businessRegistrationStateProvince: String? = null
  var businessRegistrationCountry: String? = null
  var businessOperatingName: String? = null

  var rgstDttm: LocalDateTime = LocalDateTime.now(ZoneOffset.UTC)
  var updtDttm: LocalDateTime = LocalDateTime.now(ZoneOffset.UTC)

  companion object: PanacheMongoCompanion<CrtrInfo> {

  }

}