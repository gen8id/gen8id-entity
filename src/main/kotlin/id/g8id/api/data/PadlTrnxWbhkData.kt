package id.g8id.api.data

import ai.bitflow.api.comn.rqst.PaidCstmData
import com.google.gson.annotations.SerializedName

class PadlTrnxWbhkData() {

  lateinit var data: PadlTrnxWbhkDetail
  @SerializedName("event_id")
  var eventId: String? = null
  @SerializedName("event_type")
  var eventType: String? = null
  @SerializedName("occurred_at")
  var occurredAt: String? = null
  @SerializedName("notification_id")
  var notificationId: String? = null
}

class PadlTrnxWbhkDetail() {

  var id: String? = null
  var origin: String? = null
  var status: String? = null
  @SerializedName("invoice_id")
  var invoiceId: String? = null
  @SerializedName("invoice_number")
  var invoiceNumber: String? = null
  @SerializedName("customer_id")
  var customerId: String? = null
  @SerializedName("address_id")
  var addressId: String? = null
  @SerializedName("business_id")
  var businessId: String? = null
  @SerializedName("subscription_id")
  var subscriptionId: String? = null
  @SerializedName("custom_data")
  var customData: PaidCstmData? = null
  @SerializedName("discount_id")
  var discountId: String? = null
  var details: PadlTrnxDetl? = null
  var checkout: PadlChckOut? = null
  var payments: List<PadlPamts>? = null
  @SerializedName("currency_code")
  var currencyCode: String? = null
}

class PadlChckOut() {
  var url: String? = null
}

class PadlTrnxDetl() {

  var totals: PadlBigTotl? = null
  @SerializedName("line_items")
  var lineItems: List<PadlLineItem>? = null
  @SerializedName("payout_totals")
  var payoutTotals: PadlBigTotl? = null
  @SerializedName("tax_rates_used")
  var taxRatesUsed: List<PadlTaxRateUsed>? = null
  @SerializedName("adjusted_totals")
  var adjustedTotals: PadlAdjtTotl? = null
}

class PadlPamts() {

  var amount: String? = null
  var status: String? = null
  @SerializedName("error_code")
  var errorCode: String? = null
  @SerializedName("method_details")
  var methodDetails: PadlPamtMthdDetl? = null
  @SerializedName("stored_payment_method_id")
  var storedPaymentMethodId: String? = null

}

class PadlPamtMthdDetl() {

  var type: String? = null
  var card: PadlPamtCardDetl? = null
}

class PadlPamtCardDetl() {

  var type: String? = null
  var last4: String? = null
  @SerializedName("expiry_month")
  var expiryMonth: Int? = null
  @SerializedName("expiry_year")
  var expiryYear: Int? = null
}

class PadlTaxRateUsed() {

  var totals: PadlWbhkTotlItem? = null
  @SerializedName("tax_rate")
  var taxRate: String? = null
}

class PadlBigTotl() {

  var fee: String? = null
  var tax: String? = null
  var total: String? = null
  var credit: String? = null
  var balance: String? = null
  var discount: String? = null
  var earnings: String? = null
  @SerializedName("fee_rate")
  var feeRate: String? = null
  var subtotal: String? = null
  @SerializedName("grand_total")
  var grandTotal: String? = null
  @SerializedName("currency_code")
  var currencyCode: String? = null
  @SerializedName("exchange_rate")
  var exchangeRate: String? = null
  @SerializedName("credit_to_balance")
  var creditToBalance: String? = null
}

class PadlAdjtTotl() {

  var fee: String? = null
  var tax: String? = null
  var total: String? = null
  var earnings: String? = null
  var subtotal: String? = null
  @SerializedName("grand_total")
  var grandTotal: String? = null
  @SerializedName("currency_code")
  var currencyCode: String? = null
}

class PadlLineItem() {

  @SerializedName("id")
  var unitTrnxId: String? = null
  var product: PadlPrdt? = null
  @SerializedName("unit_totals")
  var unitTotals: PadlWbhkTotlItem? = null
  var quantity: Int? = null
  var totals: PadlWbhkTotlItem? = null
}

class PadlPrdt() {

  var name: String? = null
  var status: String? = null
  @SerializedName("image_url")
  var imageUrl: String? = null
  @SerializedName("custom_data")
  var customData: Map<String, Any>? = null
  var description: String? = null
}

class PadlWbhkTotlItem() {

  var subtotal: String? = null
  var tax: String? = null
  var total: String? = null
  var discount: String? = null

}


