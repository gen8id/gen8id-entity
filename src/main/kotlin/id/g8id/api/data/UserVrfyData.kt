package id.g8id.api.data

import com.hyperwallet.clientsdk.model.HyperwalletLink
import com.hyperwallet.clientsdk.model.HyperwalletUser.*
import com.hyperwallet.clientsdk.model.HyperwalletVerificationDocument
import java.util.*

class UserVrfyData {

  var token: String? = null
  var status: Status? = null
  var taxVerificationStatus: TaxVerificationStatus? = null
  var verificationStatus: VerificationStatus? = null
  var businessStakeholderVerificationStatus: BusinessStakeholderVerificationStatus? = null
  var letterOfAuthorizationStatus: LetterOfAuthorizationStatus? = null

  var createdOn: Date? = null
  var clientUserId: String? = null
  var profileType: ProfileType? = null

  var businessType: BusinessType? = null
  var businessName: String? = null
  var businessOperatingName: String? = null
  var businessRegistrationId: String? = null
  var businessRegistrationCountry: String? = null
  var businessRegistrationStateProvince: String? = null
  var businessContactRole: BusinessContactRole? = null

  var firstName: String? = null
  var middleName: String? = null
  var lastName: String? = null
  var dateOfBirth: Date? = null
  var countryOfBirth: String? = null
  var countryOfNationality: String? = null
  var gender: Gender? = null
  var phoneNumber: String? = null
  var mobileNumber: String? = null
  var email: String? = null
  var governmentId: String? = null
  var governmentIdType: GovernmentIdType? = null
  var passportId: String? = null
  var driversLicenseId: String? = null
  var employerId: String? = null
  var addressLine1: String? = null
  var addressLine2: String? = null
  var city: String? = null
  var stateProvince: String? = null
  var postalCode: String? = null
  var country: String? = null
  var language: String? = null
  var programToken: String? = null
  var timeZone: String? = null
  var documents: List<HyperwalletVerificationDocument>? = null
  var links: List<HyperwalletLink>? = null

}