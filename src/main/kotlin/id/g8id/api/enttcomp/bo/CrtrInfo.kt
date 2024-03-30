package id.g8id.api.enttcomp.bo

import io.quarkus.mongodb.panache.kotlin.PanacheMongoCompanion
import io.quarkus.mongodb.panache.kotlin.PanacheMongoEntity
import java.time.LocalDateTime
import java.time.ZoneOffset


/**
 * ref. https://docs.hyperwallet.com/content/api/v4/resources/users/retrieve
 * API : https://uat-api.paylution.com/rest/v4/users/{user-token}
 */
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

  lateinit var token: String                  // "usr-f9154016-94e8-4686-a840-075688ac07b5" <= user token
  lateinit var status: String                 // PRE_ACTIVATED (at HyprWletUserStat)
  var verificationStatus: String? = null      // NOT_REQUIRED (at HyprWletUserVrfyStat)
  var vtaxVerificationStatus: String? = null  // NOT_REQUIRED
  var createdOn: LocalDateTime? = null        // 2023-12-06T15:35:51
  lateinit var clientUserId: String           // "methodtweak@naver.com"
  lateinit var profileType: String            // "INDIVIDUAL"
  lateinit var firstName: String              // "John"
  var middleName: String? = null              // "John"
  lateinit var lastName: String               // "Developer"
  var dateOfBirth: String? = null             // "1991-02-15"
  lateinit var email: String                  // "test15@naver.com"
  var addressLine1: String? = null            // "575 Market St"
  var addressLine2: String? = null            // "575 Market St"
  var city: String? = null                    // New York
  var stateProvince: String? = null           // NY
  var country: String? = null                 // "US"
  var postalCode: String? = null              // "94105"
  var language: String? = null                // "en"
  var timeZone: String? = null                // "GMT"
  lateinit var programToken: String           // "prg-6a1d5641-5368-48f8-8246-03e1233d4d36"

  var countryOfBirth: String? = null
  var countryOfNationality: String? = null
  var phoneNumber: String? = null
  var mobileNumber: String? = null
  var governmentId: String? = null            // The user's government ID number, such as a Social Security Number.
  var governmentIdType: String? = null        // PASSPORT, NATIONAL_ID_CARD (at HyprWletUserIdType)
  var passportId: String? = null              // The user's passport number.
  var driversLicenseId: String? = null        // driversLicenseIdstring
  var employerId: String? = null              // The user's employer identifier, generally used for tax purposes.

  var businessType: String? = null            // CORPORATION, PRIVATE_COMPANY (at HyprWletBusinessType)
  var businessName: String? = null            // The business name.
  var businessRegistrationId: String? = null
  var businessRegistrationStateProvince: String? = null
  var businessRegistrationCountry: String? = null
  var businessOperatingName: String? = null   // The business' operating name.

  var businessStakeholderVerificationStatus: String? = null // UNDER_REVIEW... (at HyprWletBsnsVrfyStat)
  var letterOfAuthorizationStatus: String? = null           // UNDER_REVIEW... (at HyprWletBsnsLetrAuthStat)

  var rgstUserId: String? = null   // admin id at JWT
  var updtUserId: String? = null   // admin id at JWT

  var rgstDttm: LocalDateTime = LocalDateTime.now(ZoneOffset.UTC)
  var updtDttm: LocalDateTime = LocalDateTime.now(ZoneOffset.UTC)

  companion object: PanacheMongoCompanion<CrtrInfo> {

  }

}