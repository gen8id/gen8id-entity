package id.g8id.api.data

import id.g8id.api.antn.NoArg

@NoArg
data class PaidSum (
  val currencyCode: String = "USD"
  , var earnings: Double = 0.0
  , var fee: Double = 0.0
  , var discount: Double = 0.0
  , var tax: Double = 0.0
  , var grandTotal: Double = 0.0
)
