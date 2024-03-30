package id.g8id.api.entt.bo


import io.quarkus.mongodb.panache.kotlin.PanacheMongoCompanion
import io.quarkus.mongodb.panache.kotlin.PanacheMongoEntity
import java.time.LocalDateTime
import java.time.ZoneOffset


/**
 * ref. https://docs.hyperwallet.com/content/api/v4/resources/users/retrieve
 * API : https://uat-api.paylution.com/rest/v4/users/{user-token}
 */
class PadlCstm : PanacheMongoEntity {

  constructor() : super()

  /**
   * 1. When user has Paddle Id
   */
  constructor(userId: String, cstmId: String, email: String, rgstUserId: String) : super() {
    this.userId = userId
    this.customerId = cstmId
    this.email = email
    this.rgstUserId = rgstUserId
    this.updtUserId = rgstUserId
  }

  /**
   * 2. For individual user
   */
  constructor(userId: String, email: String, countryCode: String) : super() {
    this.userId = userId
    this.email = email
    this.countryCode = countryCode
  }

  /**
   * 3. For business user
   */
  constructor(userId: String, bsnsName: String, taxIdentifier: String
              , countryCode: String, postalCode: String, region: String, city: String
              , firstLine: String) : super() {
    this.userId = userId
    this.businessName = bsnsName
    this.taxIdentifier = taxIdentifier
    this.countryCode = countryCode
    this.postalCode = postalCode
    this.region = region
    this.city = city
    this.firstLine = firstLine
  }

  // personal
  lateinit var userId: String
  var customerId: String? = null       // ctm_*****
  var email: String? = null        // useless when using Paddle ID

  // address
  var addressId: String? = null       // add_*****
  var countryCode: String? = null  // useless when using Paddle ID // required when no Paddle ID
  var postalCode: String? = null   // useless when using Paddle ID // required when no Paddle ID
  var region: String? = null       // useless when using Paddle ID // required when Business and no Paddle ID
  var city: String? = null         // useless when using Paddle ID // required when Business and no Paddle ID
  var firstLine: String? = null    // useless when using Paddle ID // required when Business and no Paddle ID

  // business => require address field
  var businessId: String? = null          // ???_*****
  var businessName: String? = null            // useless when using Paddle ID
  var taxIdentifier: String? = null   // useless when using Paddle ID

  var rgstUserId: String? = null
  var updtUserId: String? = null
  var rgstDttm: LocalDateTime = LocalDateTime.now(ZoneOffset.UTC)
  var updtDttm: LocalDateTime = LocalDateTime.now(ZoneOffset.UTC)

  companion object: PanacheMongoCompanion<PadlCstm> {

  }

}