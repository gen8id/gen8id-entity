package id.g8id.api.entt.wh.entt

import id.g8id.api.antn.NoArg
import com.fasterxml.jackson.annotation.JsonProperty
import io.quarkus.mongodb.panache.kotlin.PanacheMongoCompanion
import io.quarkus.mongodb.panache.kotlin.PanacheMongoEntity
import org.bson.codecs.pojo.annotations.BsonProperty

@NoArg
data class PrdtPric(
  @BsonProperty("pricId")
  @JsonProperty("id")
  var pricId: String? = null,
  @JsonProperty("product_id")
  var productId: String? = null,
  var description: String? = null,
  @JsonProperty("billing_cycle")
  var billingCycle: String? = null,
  @JsonProperty("trial_period")
  var trialPeriod: String? = null,
  @JsonProperty("tax_mode")
  var taxMode: String? = null,
  var status: String? = null,
  @JsonProperty("custom_data")
  var customData: Map<String, Any>? = null,
  @JsonProperty("unit_price")
  var unitPrice: PrdtUnitPric? = null,
  var inUse: Boolean = false
) : PanacheMongoEntity() {

  companion object: PanacheMongoCompanion<PrdtPric> {

    fun getImagePriceRangeByCreatorGrade(gradCd: String): List<PrdtPric> {
      val rowCnt = PrdtPric.list("{}").size
      var ret = listOf<PrdtPric>()
      if (rowCnt > 1) {
        val list: List<PrdtPric>? = PrdtPric.listAll()
        var maxIdx = 0
        var minIdx = 0
        if (!list.isNullOrEmpty()) {
          list.sortedByDescending { it.unitPrice?.amount?.toInt() }
          if (minIdx + 21 > list.size) {
            maxIdx = list.size
          } else {
            maxIdx = minIdx + 21
          }
          ret = list.subList(minIdx, maxIdx).reversed()
        }
      }
      return ret
    }

    fun getPmptPriceRangeByCreatorGrade(gradCd: String): List<PrdtPric> {
      val rowCnt = PrdtPric.list("{}").size
      var ret = listOf<PrdtPric>()
      if (rowCnt > 0) {
        val list: List<PrdtPric>? = PrdtPric.list("{}")
        var maxIdx = 0
        var minIdx = 0
        if (!list.isNullOrEmpty()) {
          list.sortedByDescending { it.unitPrice?.amount?.toInt() }
          if (minIdx + 21 > list.size) {
            maxIdx = list.size
          } else {
            maxIdx = minIdx + 21
          }
          ret = list.subList(minIdx, maxIdx).reversed()
        }
      }
      return ret
    }
  }

}

@NoArg
data class PrdtUnitPric(
  var amount: String? = null,
  var currencyMode: String? = null,
  var unitPriceOverrides: List<PrdtUnitPric>? = null,
  var status: String? = null,
  var quantity: PurchasbleQuantity? = null
)

@NoArg
data class PurchasbleQuantity(
  var minimum: Int? = null,
  var maximum: Int? = null
)
