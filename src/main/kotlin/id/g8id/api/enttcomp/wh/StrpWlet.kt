package id.g8id.api.enttcomp.wh

import ai.bitflow.api.cnst.StrpCnst
import id.g8id.api.cnst.BotUser
import id.g8id.api.data.StrpExtnAcnt
import id.g8id.api.util.GsonExt
import com.google.gson.annotations.SerializedName
import com.stripe.model.Account
import com.stripe.model.Person
import io.quarkus.mongodb.panache.kotlin.PanacheMongoCompanion
import io.quarkus.mongodb.panache.kotlin.PanacheMongoEntity
import java.time.LocalDateTime
import java.time.ZoneOffset

/**
 * Complete the connection and get the account ID
 * ref. https://docs.stripe.com/connect/oauth-reference#post-token
 */
class StrpWlet : PanacheMongoEntity {

  constructor() : super()

  constructor(param: Account, userId: String, isDflt: Boolean): super() {

    this.cstmUserId = userId
    this.isDflt = isDflt
    this.rgstUserId = userId
    this.updtUserId = userId

    this.strpAcntId = param.id
    this.businessProfile = param.businessProfile
    this.chargesEnabled = param.chargesEnabled
    this.businessType = param.businessType
    this.capabilities = param.capabilities
    this.company = param.company
    this.country = param.country
    this.individual = param.individual
    this.controller = param.controller
    this.created = param.created
    this.defaultCurrency = param.defaultCurrency
    this.deleted = param.deleted
    this.detailsSubmitted = param.detailsSubmitted
    this.email = param.email
    this.externalAccounts = GsonExt.getGson().fromJson(GsonExt.getGson().toJson(param.externalAccounts), StrpExtnAcnt::class.java)
    this.futureRequirements = param.futureRequirements
    this.metadata = param.metadata
    this.`object` = param.`object`
    this.payoutsEnabled = param.payoutsEnabled
    this.requirements = param.requirements
    this.settings = param.settings
    this.tosAcceptance = param.tosAcceptance
    this.type = param.type

  }

  fun updateAccountDetails(param: Account, userId: String): Boolean {

    this.updtUserId = userId
    this.updtDttm = LocalDateTime.now(ZoneOffset.UTC)
//    this.businessType = param.businessType
//    this.company = param.company
//    this.individual = param.individual
    this.businessProfile = param.businessProfile
    this.controller = param.controller
    this.chargesEnabled = param.chargesEnabled
    this.capabilities = param.capabilities
    this.country = param.country
    this.created = param.created
    this.defaultCurrency = param.defaultCurrency
    this.deleted = param.deleted
    this.detailsSubmitted = param.detailsSubmitted
    this.email = param.email
    this.externalAccounts = GsonExt.getGson().fromJson(GsonExt.getGson().toJson(param.externalAccounts), StrpExtnAcnt::class.java)
    this.futureRequirements = param.futureRequirements
    this.metadata = param.metadata
    this.`object` = param.`object`
    this.payoutsEnabled = param.payoutsEnabled
    this.requirements = param.requirements
    this.settings = param.settings
    this.tosAcceptance = param.tosAcceptance
    this.type = param.type

    return true
  }

  var cstmUserId: String? = null
  var isDflt: Boolean = false // 기본 월렛 여부
  var connectStatus: String? = null// stripe connect status (Enabled, Complete)

  var rgstUserId: String? = null
  var updtUserId: String? = null
  var rgstDttm: LocalDateTime = LocalDateTime.now(ZoneOffset.UTC)
  var updtDttm: LocalDateTime = LocalDateTime.now(ZoneOffset.UTC)

  @SerializedName("business_profile")
  var businessProfile: Account.BusinessProfile? = null

  /**
   * The business type. Once you create an [Account Link](https://stripe.com/docs/api/account_links) or [Account Session](https://stripe.com/docs/api/account_sessions), this property is only
   * returned for Custom accounts.
   * One of `company`, `government_entity`, `individual`, or `non_profit`.
   */
  @SerializedName("business_type")
  var businessType: String? = null

  @SerializedName("capabilities")
  var capabilities: Account.Capabilities? = null

  /** Whether the account can create live charges.  */
  @SerializedName("charges_enabled")
  var chargesEnabled: Boolean? = null

  @SerializedName("company")
  var company: Account.Company? = null

  @SerializedName("controller")
  var controller: Account.Controller? = null

  /** The account's country.  */
  @SerializedName("country")
  var country: String? = null

  /** Time at which the account was connected. Measured in seconds since the Unix epoch.  */
  @SerializedName("created")
  var created: Long? = null

  /**
   * Three-letter ISO currency code representing the default currency for the account. This must be
   * a currency that [Stripe supports in the account's
 * country](https://stripe.com/docs/payouts).
   */
  @SerializedName("default_currency")
  var defaultCurrency: String? = null

  /** Always true for a deleted object.  */
  @SerializedName("deleted")
  var deleted: Boolean? = null

  /**
   * Whether account details have been submitted. Standard accounts cannot receive payouts before
   * this is true.
   */
  @SerializedName("details_submitted")
  var detailsSubmitted: Boolean? = null

  /**
   * An email address associated with the account. It's not used for authentication and Stripe
   * doesn't market to this field without explicit approval from the platform.
   */
  @SerializedName("email")
  var email: String? = null

  /**
   * External accounts (bank accounts and debit cards) currently attached to this account. External
   * accounts are only returned for requests where `controller[is_controller]` is true.
   */
//  @SerializedName("external_accounts")
  var externalAccounts: StrpExtnAcnt? = null

  @SerializedName("future_requirements")
  var futureRequirements: Account.FutureRequirements? = null

  /** Unique identifier for the object.  */
//  @SerializedName("id")
  var strpAcntId: String? = null

  /**
   * This is an object representing a person associated with a Stripe account.
   *
   *
   * A platform cannot access a Standard or Express account's persons after the account starts
   * onboarding, such as after generating an account link for the account. See the [Standard onboarding](https://stripe.com/docs/connect/standard-accounts) or [Express onboarding documentation](https://stripe.com/docs/connect/express-accounts)
   * for information about platform prefilling and account onboarding steps.
   *
   *
   * Related guide: [Handling
 * identity verification with the API](https://stripe.com/docs/connect/handling-api-verification#person-information)
   */
  @SerializedName("individual")
  var individual: Person? = null

  /**
   * Set of [key-value pairs](https://stripe.com/docs/api/metadata) that you can attach
   * to an object. This can be useful for storing additional information about the object in a
   * structured format.
   */
  @SerializedName("metadata")
  var metadata: Map<String, String>? = null

  /**
   * String representing the object's type. Objects of the same type share the same value.
   *
   *
   * Equal to `account`.
   */
  @SerializedName("object")
  var `object`: String? = null

  /** Whether Stripe can send payouts to this account.  */
  @SerializedName("payouts_enabled")
  var payoutsEnabled: Boolean? = null

  @SerializedName("requirements")
  var requirements: Account.Requirements? = null

  /** Options for customizing how the account functions within Stripe.  */
  @SerializedName("settings")
  var settings: Account.Settings? = null

  @SerializedName("tos_acceptance")
  var tosAcceptance: Account.TosAcceptance? = null

  /** The Stripe account type. Can be `standard`, `express`, or `custom`.  */
  @SerializedName("type")
  var type: String? = null

  fun putWebhookData(
    param: Account
  ) {
    this.businessProfile = param.businessProfile
    this.capabilities = param.capabilities
    this.chargesEnabled = param.chargesEnabled
    this.detailsSubmitted = param.detailsSubmitted
    this.externalAccounts = GsonExt.getGson().fromJson(GsonExt.getGson().toJson(param.externalAccounts), StrpExtnAcnt::class.java)
    this.futureRequirements = param.futureRequirements
    if (param.individual != null) {
      this.individual = param.individual
    }
    this.payoutsEnabled = param.payoutsEnabled
    this.requirements = param.requirements
    this.settings = param.settings
    this.tosAcceptance = param.tosAcceptance
    this.connectStatus = StrpCnst.CONNECT_ENABLED

    this.updtUserId = BotUser.STRP_WBHK_USER
    this.updtDttm = LocalDateTime.now(ZoneOffset.UTC)
  }

  fun connectComplete() {
    if (this.requirements?.alternatives?.isEmpty()!!
      && this.requirements?.currentDeadline == null
      && this.requirements?.currentlyDue?.isEmpty()!!
      && this.requirements?.disabledReason == null
      && this.requirements?.errors?.isEmpty()!!
      && this.requirements?.eventuallyDue?.isEmpty()!!
      && this.requirements?.pastDue?.isEmpty()!!
      && this.requirements?.pendingVerification?.isEmpty()!!
    ) {
      this.connectStatus = StrpCnst.CONNECT_COMPLETE
    }
  }

  companion object: PanacheMongoCompanion<StrpWlet> {

  }

}