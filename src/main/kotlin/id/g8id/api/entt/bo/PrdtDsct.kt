package src.main.kotlin.id.g8id.api.entt.bo

import com.fasterxml.jackson.annotation.JsonProperty
import io.quarkus.mongodb.panache.kotlin.PanacheMongoCompanion
import io.quarkus.mongodb.panache.kotlin.PanacheMongoEntity
import java.time.LocalDateTime

class PrdtDsct: PanacheMongoEntity {

  constructor(): super()

  @JsonProperty("id")
  lateinit var dsctId: String
  lateinit var status: String
  lateinit var description: String
  lateinit var type: String
  lateinit var amount: String
  @JsonProperty("created_at")
  lateinit var createdAt: LocalDateTime
  @JsonProperty("updated_at")
  lateinit var updatedAt: LocalDateTime
  @JsonProperty("enabled_for_checkout")
  var enabledForCheckout: Boolean? = null
  @JsonProperty("external_id")
  var externalId: String? = null
  var code: String? = null
  @JsonProperty("currency_code")
  var currencyCode: String? = null
  var recur: Boolean? = null
  @JsonProperty("restrict_to")
  var restrictTo: List<String>? = null
  @JsonProperty("maximum_recurring_intervals")
  var maximumRecurringIntervals: Int? = null
  @JsonProperty("usage_limit")
  var usageLimit: Int? = null
  @JsonProperty("expires_at")
  var expiresAt: LocalDateTime? = null
  @JsonProperty("times_used")
  var timesUsed: Int? = 0
  
  companion object: PanacheMongoCompanion<PrdtDsct> {

  }

}

