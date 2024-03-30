package id.g8id.api.enttcomp.fo

import com.hyperwallet.clientsdk.model.HyperwalletLink
import com.hyperwallet.clientsdk.model.HyperwalletUser
import com.hyperwallet.clientsdk.model.HyperwalletVerificationDocument
import id.g8id.api.data.UserVrfyData
import id.g8id.api.rqst.HyprWletIdvdBsicInfo
import io.quarkus.mongodb.panache.kotlin.PanacheMongoCompanion
import io.quarkus.mongodb.panache.kotlin.PanacheMongoEntity
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.*

/**
 * backoffice user sign in history,
 * even though password not match,
 * just id match, log here
 */
class UserVrfy() : PanacheMongoEntity() {

  constructor(data: UserVrfyData) : this() {
    this.token = data.token
    this.status = data.status
    this.taxVerificationStatus = data.taxVerificationStatus
    this.verificationStatus = data.verificationStatus
    this.businessStakeholderVerificationStatus = data.businessStakeholderVerificationStatus
    this.letterOfAuthorizationStatus = data.letterOfAuthorizationStatus

    this.createdOn = data.createdOn
    this.clientUserId = data.clientUserId
    this.profileType = data.profileType

    this.businessType = data.businessType
    this.businessName = data.businessName
    this.businessOperatingName = data.businessOperatingName
    this.businessRegistrationId = data.businessRegistrationId
    this.businessRegistrationCountry = data.businessRegistrationCountry
    this.businessRegistrationStateProvince = data.businessRegistrationStateProvince
    this.businessContactRole = data.businessContactRole

    this.firstName = data.firstName
    this.middleName = data.middleName
    this.lastName = data.lastName
    this.dateOfBirth = data.dateOfBirth
    this.countryOfBirth = data.countryOfBirth
    this.countryOfNationality = data.countryOfNationality
    this.gender = data.gender
    this.phoneNumber = data.phoneNumber
    this.mobileNumber = data.mobileNumber
    this.email = data.email
    this.governmentId = data.governmentId
    this.governmentIdType = data.governmentIdType
    this.passportId = data.passportId
    this.driversLicenseId = data.driversLicenseId
    this.employerId = data.employerId
    this.addressLine1 = data.addressLine1
    this.addressLine2 = data.addressLine2
    this.city = data.city
    this.stateProvince = data.stateProvince
    this.postalCode = data.postalCode
    this.country = data.country
    this.language = data.language
    this.programToken = data.programToken
    this.timeZone = data.timeZone
    this.documents = data.documents
    this.links = data.links
  }

  fun appendGen8idUserData(param: HyprWletIdvdBsicInfo) {
    this.userId = param.userId
    this.rgstUserId = param.rgstUserId
    this.updtUserId = param.rgstUserId
    this.clientIp = param.clientIp
    this.userAgnt = param.userAgnt
    this.host = param.host
    this.ctnt = param.ctnt
    this.regn = param.regn
    this.pfrm = param.pfrm
    this.cfCity = param.city
  }


  // Generated data
  var userId: String? = null
  var rgstUserId: String? = null
  var updtUserId: String? = null
  var ctnt: String? = null
  var regn: String? = null
  var host: String? = null
  var cfCity: String? = null
  var pfrm: String? = null
  var userAgnt: String? = null
  var clientIp: String? = null

  var rgstDttm: LocalDateTime? = LocalDateTime.now(ZoneOffset.UTC)
  var updtDttm: LocalDateTime? = LocalDateTime.now(ZoneOffset.UTC)

  // Hyperwallet data
  var token: String? = null
  var status: HyperwalletUser.Status? = null
  var taxVerificationStatus: HyperwalletUser.TaxVerificationStatus? = null
  var verificationStatus: HyperwalletUser.VerificationStatus? = null
  var businessStakeholderVerificationStatus: HyperwalletUser.BusinessStakeholderVerificationStatus? = null
  var letterOfAuthorizationStatus: HyperwalletUser.LetterOfAuthorizationStatus? = null

  var createdOn: Date? = null
  var clientUserId: String? = null
  var profileType: HyperwalletUser.ProfileType? = null

  var businessType: HyperwalletUser.BusinessType? = null
  var businessName: String? = null
  var businessOperatingName: String? = null
  var businessRegistrationId: String? = null
  var businessRegistrationCountry: String? = null
  var businessRegistrationStateProvince: String? = null
  var businessContactRole: HyperwalletUser.BusinessContactRole? = null

  var firstName: String? = null
  var middleName: String? = null
  var lastName: String? = null
  var dateOfBirth: Date? = null
  var countryOfBirth: String? = null
  var countryOfNationality: String? = null
  var gender: HyperwalletUser.Gender? = null
  var phoneNumber: String? = null
  var mobileNumber: String? = null
  var email: String? = null
  var governmentId: String? = null
  var governmentIdType: HyperwalletUser.GovernmentIdType? = null
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


  companion object: PanacheMongoCompanion<UserVrfy> {

  }

}
