package id.g8id.api.rqst

import id.g8id.api.cnst.PadlPrdtPric

class PadlCret1TimeImgPricRqst() {

  constructor(product_id: String, description: String, amount: String, custom_data: Map<String, Any>?) : this() {
    this.product_id = product_id
    this.description = description
    this.unit_price = PadlUnitPric(amount)
    this.custom_data = custom_data
  }

  lateinit var product_id: String
  lateinit var description: String
  lateinit var unit_price: PadlUnitPric
  var custom_data: Map<String, Any>? = null
  val quantity = PadlQntt()
  val tax_mode = PadlPrdtPric.TAX_MODE
  var billing_cycle: PadlBillCycl? = null
  var trial_period: PadlTralPerd? = null

}

class PadlUnitPric(var amount: String) {
  var currency_code: String = PadlPrdtPric.CURRENCY_CODE
}

class PadlPricCustomData() {
  var valu: Int? = null
  var levl: Int? = null
  var grad: String? = null
}

data class PadlQntt(
  val minimum: Int,
  val maximum: Int
) {
  constructor () : this(1, 12)
}

data class PadlBillCycl(
  val interval: String, // month, day, week...
  val frequency: Int,
)

data class PadlTralPerd(
  val interval: String, // month, day, week...
  val frequency: Int,
)
