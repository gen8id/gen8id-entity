package id.g8id.api.data

import com.google.gson.annotations.SerializedName
import com.stripe.model.Account.FutureRequirements
import com.stripe.model.Account.Requirements
import id.g8id.api.antn.NoArg

@NoArg
data class StrpExtnAcnt(
  val `object`: String? = null
  , val data: List<StrpExtnAcntData>? = null
  , val hasMore: Boolean? = null
  , val url: String? = null
)

@NoArg
data class StrpExtnAcntData(
  var account: StrpAcnt? = null
  , @SerializedName("available_payout_methods") var availablePayoutMethods: List<String>? = null // express. standard
  , @SerializedName("bank_name") var bankName: String? = null
  , var country: String? = null
  , var currency: String? = null
  , @SerializedName("default_for_currency") var defaultForCurrency: Boolean? = null
  , var fingerprint: String? = null
  , @SerializedName("future_requirements") var futureRequirements: FutureRequirements? = null
  , var id: String? = null
  , var last4: String? = null
  , var metadata: MutableMap<String, Any>? = null
  , var `object`: String? = null
  , var requirements: Requirements? = null
  , @SerializedName("routing_number") var routingNumber: String? = null
  , var status: String? = null
)

@NoArg
data class StrpAcnt(
  var id: String? = null
)