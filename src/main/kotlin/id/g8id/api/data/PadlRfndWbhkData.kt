package id.g8id.api.data

import com.google.gson.annotations.SerializedName

data class PadlRfndWbhkData(
    @SerializedName("event_id")
    val eventId: String,
    @SerializedName("event_type")
    val eventType: String,
    @SerializedName("occurred_at")
    val occurredAt: String,
    @SerializedName("notification_id")
    val notificationId: String,
    val data: PadlRfndWbhkDetail
)

data class PadlRfndWbhkDetail(
    val id: String,
    val items: List<RfndItem>,
    val action: String,
    val reason: String,
    val status: String,
    val totals: Totals,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("customer_id")
    val customerId: String,
    @SerializedName("currency_code")
    val currencyCode: String,
    @SerializedName("payout_totals")
    val payoutTotals: Totals,
    @SerializedName("transaction_id")
    val transactionId: String,
    @SerializedName("subscription_id")
    val subscriptionId: String,
    @SerializedName("credit_applied_to_balance")
    val creditAppliedToBalance: String?
)

data class RfndItem(
    val adjItmId: String,
    @SerializedName("item_id")
    val itemId: String?,
    val type: String?,
    val amount: String?,
    val totals: Totals?,
    val proration: String?
)

data class Totals(
    val subtotal: String?,
    val tax: String?,
    val total: String?,
    val fee: String?,
    val earnings: String?,
    @SerializedName("currency_code")
    val currencyCode: String?
)