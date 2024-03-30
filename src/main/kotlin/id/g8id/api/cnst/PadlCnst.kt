package id.g8id.api.cnst


const val PADDLE_REQUEST_HEADER = "paddle-signature"

object PadlPrdt {
    const val CSTM_DATA_IMAGE  = "imag"
    const val CSTM_DATA_PROMPT = "pmpt"
}

object PadlPrdtPric {
    const val STATUS               = "status"
    const val PRICES               = "prices"
    const val PER_PAGE             = 20
    const val TAX_MODE             = "account_setting"
    const val TAX_CATEGORY         = "digital-goods"
    const val STATUS_ACTIVE        = "active"
    const val CURRENCY_CODE        = "USD"
    const val ORDER_BY_NAME        = "name[ASC]"
    const val ORDER_BY_DATE_DESC   = "created_at[DESC]"
    const val ORDER_BY_PRIC_DESC   = "unit_price.amount[DESC]"
    const val ORDER_BY_PRDT_NM_ASC = "custom_data.type[ASC]"
}

object PadlWbhkEvnt {
    const val TRANSACTION_BILLED         = "transaction.billed"
    const val TRANSACTION_CANCELED       = "transaction.canceled"
    const val TRANSACTION_COMPLETED      = "transaction.completed"
    const val TRANSACTION_CREATED        = "transaction.created"
    const val TRANSACTION_PAID           = "transaction.paid"
    const val TRANSACTION_PAST_DUE       = "transaction.past_due"
    const val TRANSACTION_PAYMENT_FAILED = "transaction.payment_failed"
    const val TRANSACTION_READY          = "transaction.ready"
    const val TRANSACTION_UPDATED        = "transaction.updated"

    const val ADJUSTMENT_CREATED         = "adjustment.created"
    const val ADJUSTMENT_UPDATED         = "adjustment.updated"

    const val PAYOUT_CREATED             = "payout.created"
    const val PAYOUT_PAID                = "payout.paid"
}

object PadlLoclTrnxEvnt {
    const val COMPLETED = "completed"
}
