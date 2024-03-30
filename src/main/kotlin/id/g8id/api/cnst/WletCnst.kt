package id.g8id.api.cnst

object WletCnst {
  val WALLET_NAME_PAYPAL = "paypal"
  val WALLET_NAME_STRIPE = "stripe"
}

object PayoneerAccount {
  object Status {
    // Card/Account not issued
    val NOT_ISSUED = 0
    // Card issued but not activated
    val ISSUED_NOT_ACTIVATED = 1
    // Card/Account Issued and activated
    val ACTIVATED = 2
    // Card/Account blocked
    val BLOCKED = 99
    // Card cancelled
    val CANCELLED = 100
    // Card lost or stolen
    val LOST_OR_STOLEN = 101
  }
}

object StrpCnst {
  val GRANT_TYPE_AUTH_CODE = "authorization_code"
  val DEFAULT_CURRENCY     = "usd"
  val VERIFIED_USER        = "verified"
  val ACTIVE_USER          = "active"
  val CONNECT_ENABLED      = "enabled"
  val CONNECT_COMPLETE     = "complete"
}

object PaplCnst {
  val TOKN_RQST_BODY = mapOf("grant_type" to "client_credentials")
  val GRANT_TYPE_AUTH_CODE = "authorization_code"
  val SCHEMA = "openid"
}