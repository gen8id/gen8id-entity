package id.g8id.api.rqst

import com.fasterxml.jackson.annotation.JsonProperty
import id.g8id.api.antn.NoArg

/**
 * checkout.completed
 * ref. https://developer.paddle.com/paddlejs/general/checkout-completed
 */
@NoArg
data class PcseCpltRqst (
  @JsonProperty("id") val checkOutId: String
  , @JsonProperty("transaction_id") val transactionId: String
  , val status: String
  , @JsonProperty("custom_data") val customData: PaidCstmData?
  , @JsonProperty("currency_code") val currencyCode: String
  , val customer: PadlCstm
  , val items: List<PadlPricItem>
  , val totals: PadlTotlItem
  , val payment: PadlPamt
  , val settings: PadlPamtSetn
  , val discount: PadlDsct?
  , @JsonProperty("recurring_totals") val recurringTotals: PadlRcurTotl?
)

class PadlCstm {
  constructor()

  constructor(
    id: String?
    , email: String?
    , address: PadlCstmAddr?
    , business: PadlCstmBsns?
  ) {
    this.id = id
    this.email = email
    this.address = address
    this.business = business
  }
  var id: String? = null
  var email: String? = null
  var address: PadlCstmAddr? = null
  var business: PadlCstmBsns? = null

}

class PadlCstmAddr {
  constructor()

  constructor(
    id: String
    , @JsonProperty("country_code") countryCode: String?
    , @JsonProperty("postal_code") postalCode: String?
    , city: String?
    , region: String?
    , @JsonProperty("first_line") firstLine: String?
  ) {
    this.id = id
    this.countryCode = countryCode
    this.postalCode = postalCode
    this.city = city
    this.region = region
    this.firstLine = firstLine
  }

  var id: String? = null
  var countryCode: String? = null
  var postalCode: String? = null
  var city: String? = null
  var region: String? = null
  var firstLine: String? = null

}


class PadlCstmBsns {

  constructor()

  constructor(
    id: String
    , name: String?
    , @JsonProperty("tax_identifier") taxIdentifier: String?
  ) {
    this.id = id
    this.name = name
    this.taxIdentifier = taxIdentifier
  }

  var id: String? = null
  var name: String? = null
  var taxIdentifier: String? = null

}

class PadlPricItem {

  constructor()

  constructor(
    @JsonProperty("price_id") priceId: String
    , product: PadlPrdtItem
    , @JsonProperty("billing_cycle") billingCycle: PadlBillCycl?
    , @JsonProperty("trial_period") trialPeriod: String?
    , quantity: Int
    , totals: PadlTotlItem
    , @JsonProperty("recurring_totals") recurringTotals: PddItemlRcurTotl?
  ) {
    this.priceId = priceId
    this.product = product
    this.billingCycle = billingCycle
    this.trialPeriod = trialPeriod
    this.quantity = quantity
    this.totals = totals
    this.recurringTotals = recurringTotals
  }

  var priceId: String? = null
  var product: PadlPrdtItem? = null
  var billingCycle: PadlBillCycl? = null
  var trialPeriod: String? = null
  var quantity: Int? = null
  var totals: PadlTotlItem? = null
  var recurringTotals: PddItemlRcurTotl? = null

}

class PadlPrdtItem {
  constructor()

  constructor(
    id: String
    , name: String
    , description: String?
    , @JsonProperty("image_url") imageUrl: String?
  ) {
    this.id = id
    this.name = name
    this.description = description
    this.imageUrl = imageUrl
  }
  var id: String? = null
  var name: String? = null
  var description: String? = null
  var imageUrl: String? = null
}

class PadlTotlItem {

  constructor()

  constructor(
    subtotal: Double,
    tax: Double,
    total: Double,
    discount: Double,
    balance: Double,
    credit: Double
  ) {
    this.subtotal = subtotal
    this.tax = tax
    this.total = total
    this.discount = discount
    this.balance = balance
    this.credit = credit
  }

  constructor(
    subtotal: String,
    tax: String,
    total: String,
    discount: String,
    balance: String,
    credit: String
  ) {
    this.subtotal = subtotal.toDouble()/100
    this.tax = tax.toDouble()/100
    this.total = total.toDouble()/100
    this.discount = discount.toDouble()/100
    this.balance = balance.toDouble()/100
    this.credit = credit.toDouble()/100
  }


  var subtotal: Double? = null
  var tax: Double? = null
  var total: Double? = null
  var discount: Double? = null
  var balance: Double? = null
  var credit: Double? = null

}

class PadlPamt {

  constructor()

  constructor(
    @JsonProperty("method_details") methodDetails: PadlPamtMthd
  ) {
    this.methodDetails = methodDetails
  }

  var methodDetails: PadlPamtMthd? = null

}

class PadlPamtMthd {
  constructor()

  constructor(
    type: String?
    , card: PadlPamtCard?
  ) {
    this.type = type
    this.card = card
  }
  var type: String? = null
  var card: PadlPamtCard? = null
}

class PadlPamtCard {
  constructor()

  constructor(
    type: String?
    , last4: String?
    , @JsonProperty("expiry_month") expiryMonth: Int?
    , @JsonProperty("expiry_year") expiryYear: Int?
  ) {
    this.type = type
    this.last4 = last4
    this.expiryMonth = expiryMonth
    this.expiryYear = expiryYear
  }
  var type: String? = null
  var last4: String? = null
  var expiryMonth: Int? = null
  var expiryYear: Int? = null
}

class PadlPamtSetn {

  constructor()

  constructor(
    @JsonProperty("displayMode") display_mode: String?
    , theme: String?
  ) {
    this.display_mode = display_mode
    this.theme = theme
  }
  var display_mode: String? = null
  var theme: String? = null
}

class PadlDsct {

  constructor()

  constructor(
    id: String?
    , code: String?
  ) {
    this.id = id
    this.code = code
  }

  var id: String? = null
  var code: String? = null

}

class PddItemlRcurTotl {
  constructor()

  constructor(
    subtotal: Double
    , tax: Double
    , discount: Double
    , total: Double
  ) {
    this.subtotal = subtotal
    this.tax = tax
    this.discount = discount
    this.total = total
  }
  var subtotal: Double? = null
  var tax: Double? = null
  var discount: Double? = null
  var total: Double? = null
}

class PadlRcurTotl {

  constructor()

  constructor(
    subtotal: Double,
    tax: Double,
    total: Double,
    discount: Double,
    balance: Double,
    credit: Double
  ) {
    this.subtotal = subtotal
    this.tax = tax
    this.total = total
    this.discount = discount
    this.balance = balance
    this.credit = credit
  }
  var subtotal: Double? = null
  var tax: Double? = null
  var total: Double? = null
  var discount: Double? = null
  var balance: Double? = null
  var credit: Double? = null

}

@NoArg
data class PaidCstmData(
  var userId: String? = null
  , var grupId: String? = null
  , var crtrId: String? = null
  , var imgList: MutableList<String>? = null
)