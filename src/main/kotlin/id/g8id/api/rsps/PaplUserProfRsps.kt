package id.g8id.api.rsps

import com.fasterxml.jackson.annotation.JsonProperty
import id.g8id.api.antn.NoArg

/**
 * ref. https://developer.paypal.com/docs/api/identity/v1/#userinfo_get
 */
@NoArg
data class PaplUserProfRsps (
  @JsonProperty("user_id")
  var userId: String? = null
  , @JsonProperty("payer_id") var payerId: String? = null
  , var sub: String? = null
  , var name: String? = null
  , var address: PaplUserAddr? = null
  , var picture: String? = null
  , var email: String? = null
  , var verified: Boolean? = null
  , @JsonProperty("verified_account") var verifiedAccount: Boolean? = null
  , @JsonProperty("email_verified") var emailVerified: Boolean? = null
  , var locale: String? = null
  , var gender: String? = null
  , var birthdate: String? = null
  , var zoneinfo: String? = null
  , @JsonProperty("given_name") var givenName: String? = null
  , @JsonProperty("family_name") var familyName: String? = null
  , @JsonProperty("middle_name") var middleName: String? = null
  , @JsonProperty("phone_number") var phoneNumber: String? = null
  , @JsonProperty("account_type") var accountType: String? = null // PERSONAL, BUSINESS, PREMIER
  , @JsonProperty("age_range") var ageRange: String? = null

)

@NoArg
data class PaplUserAddr(
  var country: String,
  var region: String,
  var locality: String,
  @JsonProperty("street_address") var streetAddress: String,
  @JsonProperty("postal_code") var postalCode: String
)
