package id.g8id.api.cnst


/**
 * ref. https://docs.hyperwallet.com/content/references/v1/payment-purpose-codes
 */
object HyprWletPaot {
    const val SALEOFINTANGIBLEASSETS = "PP0012" // like patents, copyrights, trademarks etc
    const val MERCHANTINGSERVICES    = "PP1001"	// net receipt from sale and purchase of goods without crossing the border
    const val BONUS                  = "GP0001"
    const val COMMISSION             = "GP0002"
    const val EXPENSE                = "GP0003"
    const val NONTAXABLEPAYMENT      = "GP0004"
    const val INCOME                 = "GP0005"
    const val PENSION                = "GP0006"
    const val CHARITYDONATION        = "GP0007"
}

object HyprWletWbhkEvnt {

    // 1. 사용자
    // 사용자 계정이 생성되었습니다.
    const val USERS_CREATED                      = "USERS.CREATED"
    // 사용자가 계정을 활성화했습니다. 일회성 직접 지불 모델 사용 사례에서는 활성화가 필요하지 않으므로 사용할 수 없습니다.
    const val USERS_UPDATED_STATUS_ACTIVATED     = "USERS.UPDATED.STATUS.ACTIVATED"
    // 일반적으로 과도한 로그인 시도로 인해 사용자 계정이 잠겼습니다.
    const val USERS_UPDATED_STATUS_LOCKED        = "USERS.UPDATED.STATUS.LOCKED"
    // 일반적으로 사기가 의심되어 사용자 계정이 동결되었습니다.
    const val USERS_UPDATED_STATUS_FROZEN        = "USERS.UPDATED.STATUS.FROZEN"
    // 사용자 계정이 고정 해제되거나 잠금 해제된 후 PRE_ACTIVATED 상태 로 반환되었습니다 .
    const val USERS_UPDATED_STATUS_PRE_ACTIVATED = "USERS.UPDATED.STATUS.PRE_ACTIVATED"
    // 사용자 계정이 비활성화되었습니다.
    const val USERS_UPDATED_STATUS_DE_ACTIVATED  = "USERS.UPDATED.STATUS.DE_ACTIVATED"

    // 2. 입금
    // 자금이 자금 계좌에 입금되면 알려줍니다. 판매자 매입자 및 결제 서비스 제공업체(PSP)를 포함한 모든 유형의 자금 조달을 지원.
    const val FINANCIAL_ACCOUNT_FUNDING_ACCOUNT_DEPOSITED =
        "FINANCIAL_ACCOUNT.FUNDING_ACCOUNT.DEPOSITED"

    // 3. 송금
    // 송금이 취소되었습니다.
    const val TRANSFERS_UPDATED_STATUS_CANCELLED   = "TRANSFERS.UPDATED.STATUS.CANCELLED"
    // 송금이 성공적으로 완료되었습니다.
    const val TRANSFERS_UPDATED_STATUS_COMPLETED   = "TRANSFERS.UPDATED.STATUS.COMPLETED"
    // 일반적으로 원본 계정의 자금이 부족하여 송금에 실패했습니다.
    const val TRANSFERS_UPDATED_STATUS_FAILED      = "TRANSFERS.UPDATED.STATUS.FAILED"
    // 송금을 처리 중입니다.
    const val TRANSFERS_UPDATED_STATUS_IN_PROGRESS = "TRANSFERS.UPDATED.STATUS.IN_PROGRESS"
    // 일반적으로 잘못된 계좌 정보로 인해 수취인의 기관에서 이체금을 반환했습니다.
    const val TRANSFERS_UPDATED_STATUS_RETURNED    = "TRANSFERS.UPDATED.STATUS.RETURNED"
    // 이체는 향후 처리될 예정입니다.
    const val TRANSFERS_UPDATED_STATUS_SCHEDULED   = "TRANSFERS.UPDATED.STATUS.SCHEDULED"

    // 4. 환불
    // 환불이 생성되었습니다.
    const val TRANSFERS_REFUND_CREATED = "TRANSFERS.REFUND.CREATED"
    // 환불이 업데이트되었습니다.
    const val TRANSFERS_REFUND_UPDATED = "TRANSFERS.REFUND.UPDATED"
}

object HyprWletWbhkEvntAll {
    const val USERS_CREATED                      = "USERS.CREATED" // The user account has been created.
    const val USERS_UPDATED_STATUS_ACTIVATED     = "USERS.UPDATED.STATUS.ACTIVATED" // The user has activated their account. This is not available in the one-time use case of the Straight-Through Payout Model as no activation is required.
    const val USERS_UPDATED_STATUS_LOCKED        = "USERS.UPDATED.STATUS.LOCKED" // The user account has been locked, typically due to excessive login attempts.
    const val USERS_UPDATED_STATUS_FROZEN        = "USERS.UPDATED.STATUS.FROZEN" // The user account has been frozen, typically due to suspected fraud.
    const val USERS_UPDATED_STATUS_PRE_ACTIVATED = "USERS.UPDATED.STATUS.PRE_ACTIVATED" // The user account has been returned to a PRE_ACTIVATED state after being unfrozen or unlocked.
    const val USERS_UPDATED_STATUS_DE_ACTIVATED  = "USERS.UPDATED.STATUS.DE_ACTIVATED" // The user account has been deactivated.

    const val USERS_UPDATED_VERIFICATION_STATUS_REQUIRED     = "USERS.UPDATED.VERIFICATION_STATUS.REQUIRED" // Identity verification is required. Please notify the payee that action is required to complete verification.
    const val USERS_UPDATED_VERIFICATION_STATUS_UNDER_REVIEW = "USERS.UPDATED.VERIFICATION_STATUS.UNDER_REVIEW" // Identity verification data is under review. Notifying payee is optional.
    const val USERS_UPDATED_VERIFICATION_STATUS_VERIFIED     = "USERS.UPDATED.VERIFICATION_STATUS.VERIFIED" // Identity verification has completed successfully. Notifying the payee is optional.
    const val USERS_UPDATED_VERIFICATION_STATUS_NOT_REQUIRED = "USERS.UPDATED.VERIFICATION_STATUS.NOT_REQUIRED" // Identity verification is not required. This notification will only be sent in the event of verification being disabled for all standard wallets or if support is troubleshooting an account.

    const val USERS_UPDATED_TAX_VERIFICATION_STATUS_REQUIRED     = "USERS.UPDATED.TAX_VERIFICATION_STATUS.REQUIRED" // Tax verification is required. Please notify the payee that action is required to complete tax verification.
    const val USERS_UPDATED_TAX_VERIFICATION_STATUS_UNDER_REVIEW = "USERS.UPDATED.TAX_VERIFICATION_STATUS.UNDER_REVIEW" // Tax verification data is under review. Notifying payee is optional.
    const val USERS_UPDATED_TAX_VERIFICATION_STATUS_VERIFIED     = "USERS.UPDATED.TAX_VERIFICATION_STATUS.VERIFIED" // Tax verification has completed successfully. Notifying the payee is optional.
    const val USERS_UPDATED_TAX_VERIFICATION_STATUS_NOT_REQUIRED = "USERS.UPDATED.TAX_VERIFICATION_STATUS.NOT_REQUIRED" // Tax verification is not required. This notification will only be sent if support is troubleshooting an account.

    const val USERS_BANK_ACCOUNTS_CREATED                     = "USERS.BANK_ACCOUNTS.CREATED" // The bank account has been created for the user.
    const val USERS_BANK_ACCOUNTS_UPDATED_STATUS_ACTIVATED    = "USERS.BANK_ACCOUNTS.UPDATED.STATUS.ACTIVATED" // The bank account has been activated.
    const val USERS_BANK_ACCOUNTS_UPDATED_STATUS_INVALID      = "USERS.BANK_ACCOUNTS.UPDATED.STATUS.INVALID" // The bank account has been marked as invalid, typically due to incorrect account details.
    const val USERS_BANK_ACCOUNTS_UPDATED_STATUS_DE_ACTIVATED = "USERS.BANK_ACCOUNTS.UPDATED.STATUS.DE_ACTIVATED" // The bank account has been deactivated.
    const val USERS_BANK_ACCOUNTS_UPDATED_STATUS_VERIFIED     = "USERS.BANK_ACCOUNTS.UPDATED.STATUS.VERIFIED" // The updated bank account has been verified.

    const val USERS_BANK_ACCOUNTS_DIRECT_DEBIT_AUTHORIZATIONS_CREATED                  = "USERS.BANK_ACCOUNTS.DIRECT_DEBIT_AUTHORIZATIONS.CREATED" // The Direct Debit Authorization has been created.
    const val USERS_BANK_ACCOUNTS_DIRECT_DEBIT_AUTHORIZATIONS_UPDATED_STATUS_ACTIVATED = "USERS.BANK_ACCOUNTS.DIRECT_DEBIT_AUTHORIZATIONS.UPDATED.STATUS.ACTIVATED" // The authorization has been successfully setup and transfer can be collected.
    const val USERS_BANK_ACCOUNTS_DIRECT_DEBIT_AUTHORIZATIONS_UPDATED_STATUS_CANCELLED = "USERS.BANK_ACCOUNTS.DIRECT_DEBIT_AUTHORIZATIONS.UPDATED.STATUS.CANCELLED" // The authorization has expired due to dormancy.
    const val USERS_BANK_ACCOUNTS_DIRECT_DEBIT_AUTHORIZATIONS_UPDATED_STATUS_EXPIRED   = "USERS.BANK_ACCOUNTS.DIRECT_DEBIT_AUTHORIZATIONS.UPDATED.STATUS.EXPIRED" // The authorization could not be created.
    const val USERS_BANK_ACCOUNTS_DIRECT_DEBIT_AUTHORIZATIONS_UPDATED_STATUS_FAILED    = "USERS.BANK_ACCOUNTS.DIRECT_DEBIT_AUTHORIZATIONS.UPDATED.STATUS.FAILED" // The authorization has been deactivated.

    const val USERS_BANK_CARDS_CREATED                     = "USERS.BANK_CARDS.CREATED" // The bank card has been created for the user.
    const val USERS_BANK_CARDS_UPDATED_STATUS_ACTIVATED    = "USERS.BANK_CARDS.UPDATED.STATUS.ACTIVATED" // The bank card has been activated.
    const val USERS_BANK_CARDS_UPDATED_STATUS_VERIFIED     = "USERS.BANK_CARDS.UPDATED.STATUS.VERIFIED" // The bank card has been verified.
    const val USERS_BANK_CARDS_UPDATED_STATUS_INVALID      = "USERS.BANK_CARDS.UPDATED.STATUS.INVALID" // The bank card has been marked as invalid.
    const val USERS_BANK_CARDS_UPDATED_STATUS_DE_ACTIVATED = "USERS.BANK_CARDS.UPDATED.STATUS.DE_ACTIVATED" // The bank card has been deactivated.

    const val FINANCIAL_ACCOUNT_FUNDING_ACCOUNT_DEPOSITED = "FINANCIAL_ACCOUNT.FUNDING_ACCOUNT.DEPOSITED" // You will be notified when funds have been deposited into your funding account.

    const val USERS_PAYPAL_ACCOUNTS_CREATED                     = "USERS.PAYPAL_ACCOUNTS.CREATED" // The PayPal account has been created for the user.
    const val USERS_PAYPAL_ACCOUNTS_UPDATED_STATUS_ACTIVATED    = "USERS.PAYPAL_ACCOUNTS.UPDATED.STATUS.ACTIVATED" // The PayPal account has been activated.
    const val USERS_PAYPAL_ACCOUNTS_UPDATED_STATUS_INVALID      = "USERS.PAYPAL_ACCOUNTS.UPDATED.STATUS.INVALID" // The PayPal account has been marked as invalid.
    const val USERS_PAYPAL_ACCOUNTS_UPDATED_STATUS_DE_ACTIVATED = "USERS.PAYPAL_ACCOUNTS.UPDATED.STATUS.DE_ACTIVATED" // The PayPal account has been deactivated.
    const val USERS_PAYPAL_ACCOUNTS_UPDATED_STATUS_VERIFIED     = "USERS.PAYPAL_ACCOUNTS.UPDATED.STATUS.VERIFIED" // The PayPal account was verified.

    const val USERS_VENMO_ACCOUNTS_CREATED                     = "USERS.VENMO_ACCOUNTS.CREATED" // The Venmo account has been created for the user.
    const val USERS_VENMO_ACCOUNTS_UPDATED_STATUS_ACTIVATED    = "USERS.VENMO_ACCOUNTS.UPDATED.STATUS.ACTIVATED" // The Venmo account has been activated.
    const val USERS_VENMO_ACCOUNTS_UPDATED_STATUS_INVALID      = "USERS.VENMO_ACCOUNTS.UPDATED.STATUS.INVALID" // The Venmo account has been marked as invalid.
    const val USERS_VENMO_ACCOUNTS_UPDATED_STATUS_DE_ACTIVATED = "USERS.VENMO_ACCOUNTS.UPDATED.STATUS.DE_ACTIVATED" // The Venmo account has been deactivated.
    const val USERS_VENMO_ACCOUNTS_UPDATED_STATUS_VERIFIED     = "USERS.VENMO_ACCOUNTS.UPDATED.STATUS.VERIFIED" // The Venmo account was verified.

    const val USERS_PREPAID_CARDS_CREATED                                  = "USERS.PREPAID_CARDS.CREATED" // The prepaid card has been created for the user.
    const val USERS_PREPAID_CARDS_UPDATED                                  = "USERS.PREPAID_CARDS.UPDATED" // The user information for the prepaid card has been updated.
    const val USERS_PREPAID_CARDS_UPDATED_STATUS_ACTIVATED                 = "USERS.PREPAID_CARDS.UPDATED.STATUS.ACTIVATED" // The prepaid card has been activated.
    const val USERS_PREPAID_CARDS_UPDATED_STATUS_COMPLIANCE_HOLD           = "USERS.PREPAID_CARDS.UPDATED.STATUS.COMPLIANCE_HOLD" // Account is under review by Hyperwallet
    const val USERS_PREPAID_CARDS_UPDATED_STATUS_DECLINED                  = "USERS.PREPAID_CARDS.UPDATED.STATUS.DECLINED" // The prepaid card has been declined.
    const val USERS_PREPAID_CARDS_UPDATED_STATUS_DE_ACTIVATED              = "USERS.PREPAID_CARDS.UPDATED.STATUS.DE_ACTIVATED" // The prepaid card has been deactivated.
    const val USERS_PREPAID_CARDS_UPDATED_STATUS_KYC_HOLD                  = "USERS.PREPAID_CARDS.UPDATED.STATUS.KYC_HOLD" // The prepaid card has been triggered for KYC.
    const val USERS_PREPAID_CARDS_UPDATED_STATUS_LOCKED                    = "USERS.PREPAID_CARDS.UPDATED.STATUS.LOCKED" // The prepaid card has been temporarily locked.
    const val USERS_PREPAID_CARDS_UPDATED_STATUS_LOST_OR_STOLEN            = "USERS.PREPAID_CARDS.UPDATED.STATUS.LOST_OR_STOLEN" // The prepaid card has been reported lost or stolen.
    const val USERS_PREPAID_CARDS_UPDATED_STATUS_QUEUED                    = "USERS.PREPAID_CARDS.UPDATED.STATUS.QUEUED" // The request for prepaid card has been received.
    const val USERS_PREPAID_CARDS_UPDATED_STATUS_SUSPENDED                 = "USERS.PREPAID_CARDS.UPDATED.STATUS.SUSPENDED" // The prepaid card has been suspended.
    const val USERS_PREPAID_CARDS_UPDATED_VERIFICATION_STATUS_REQUIRED     = "USERS.PREPAID_CARDS.UPDATED.VERIFICATION_STATUS.REQUIRED\t" // Additional information is required from the user to verify their identity.
    const val USERS_PREPAID_CARDS_UPDATED_VERIFICATION_STATUS_UNDER_REVIEW = "USERS.PREPAID_CARDS.UPDATED.VERIFICATION_STATUS.UNDER_REVIEW" // Hyperwallet is reviewing information provided by the user to verify their identity.
    const val USERS_PREPAID_CARDS_UPDATED_VERIFICATION_STATUS_VERIFIED     = "USERS.PREPAID_CARDS.UPDATED.VERIFICATION_STATUS.VERIFIED" // The user has been successfully verified.

    const val USERS_PAPER_CHECKS_CREATED = "USERS.PAPER_CHECKS.CREATED" // The paper check transfer method was created for the user.
    const val USERS_PAPER_CHECKS_UPDATED = "USERS.PAPER_CHECKS.UPDATED" // The paper check transfer method was updated.
    const val USERS_PAPER_CHECKS_UPDATED_STATUS_ACTIVATED = "USERS.PAPER_CHECKS.UPDATED.STATUS.ACTIVATED" // The paper check transfer method has been activated.
    const val USERS_PAPER_CHECKS_UPDATED_STATUS_DE_ACTIVATED = "USERS.PAPER_CHECKS.UPDATED.STATUS.DE_ACTIVATED" // The paper check transfer method has been deactivated.
    const val USERS_PAPER_CHECKS_UPDATED_STATUS_INVALID = "USERS.PAPER_CHECKS.UPDATED.STATUS.INVALID" // The paper check transfer method has been marked as invalid.

    const val PAYMENTS_UPDATED_STATUS_SCHEDULED                        = "PAYMENTS.UPDATED.STATUS.SCHEDULED" // The payment has been scheduled to process at a future date.
    const val PAYMENTS_UPDATED_STATUS_PENDING_ACCOUNT_ACTIVATION       = "PAYMENTS.UPDATED.STATUS.PENDING_ACCOUNT_ACTIVATION" // The payment has been held pending the user activating their account. This is available in the recurring use case of the Straight-Through Payout Model only.
    const val PAYMENTS_UPDATED_STATUS_PENDING_ID_VERIFICATION          = "PAYMENTS.UPDATED.STATUS.PENDING_ID_VERIFICATION" // The payment has been held pending the user verifying their identity. This is available for the Straight-Through Payout Model only.
    const val PAYMENTS_UPDATED_STATUS_PENDING_TAX_VERIFICATION         = "PAYMENTS.UPDATED.STATUS.PENDING_TAX_VERIFICATION" // The payment has been held pending the user verifying their tax information. This is available for the Straight-Through Payout Model only.
    const val PAYMENTS_UPDATED_STATUS_PENDING_TRANSFER_METHOD_ACTION   = "PAYMENTS.UPDATED.STATUS.PENDING_TRANSFER_METHOD_ACTION" // The payment has been held pending the user registering a transfer method. This is available for the Straight-Through Payout Model only.
    const val PAYMENTS_UPDATED_STATUS_PENDING_TRANSACTION_VERIFICATION = "PAYMENTS.UPDATED.STATUS.PENDING_TRANSACTION_VERIFICATION" // The payment has been held for internal review. This is available for the Straight-Through Payout Model only.
    const val PAYMENTS_UPDATED_STATUS_IN_PROGRESS                      = "PAYMENTS.UPDATED.STATUS.IN_PROGRESS" // The payment is processing. This is available for the Straight-Through Payout Model only.
    const val PAYMENTS_UPDATED_STATUS_WAITING_FOR_SUPPLEMENTAL_DATA    = "PAYMENTS.UPDATED.STATUS.WAITING_FOR_SUPPLEMENTAL_DATA" // The payment has been held pending the receipt of supplemental data. This status is only applicable if the payment is being made to a local bank account in China in CNY currency. It is not applicable to the Virtual Account Payout Model.
    const val PAYMENTS_UPDATED_STATUS_UNCLAIMED                        = "PAYMENTS.UPDATED.STATUS.UNCLAIMED" // The payment has not been claimed by the payee yet and is eligible for cancellation. This is available for PayPal/Venmo payments only.
    const val PAYMENTS_UPDATED_STATUS_COMPLETED                        = "PAYMENTS.UPDATED.STATUS.COMPLETED" // The payment has been cleared to the user's transfer method.
    const val PAYMENTS_UPDATED_STATUS_FAILED                           = "PAYMENTS.UPDATED.STATUS.FAILED" // The payment has failed, typically due to insufficient funds in the source account.
    const val PAYMENTS_UPDATED_STATUS_RECALLED                         = "PAYMENTS.UPDATED.STATUS.RECALLED" // The payment has been recalled before having cleared the system. This is available for the Straight-Through Payout Model only.
    const val PAYMENTS_UPDATED_STATUS_RETURNED                         = "PAYMENTS.UPDATED.STATUS.RETURNED" // The payment has been returned by the recipient's institution, typically due to incorrect account details. This is available for the Straight-Through Payout Model only.
    const val PAYMENTS_UPDATED_STATUS_EXPIRED                          = "PAYMENTS.UPDATED.STATUS.EXPIRED" // The payment has expired.
    const val PAYMENTS_UPDATED_STATUS_CANCELLED                        = "PAYMENTS.UPDATED.STATUS.CANCELLED" // The payment has been cancelled.

    const val TRANSFERS_UPDATED_STATUS_CANCELLED   = "TRANSFERS.UPDATED.STATUS.CANCELLED" // The transfer has been cancelled.
    const val TRANSFERS_UPDATED_STATUS_COMPLETED   = "TRANSFERS.UPDATED.STATUS.COMPLETED" // The transfer has been completed successfully.
    const val TRANSFERS_UPDATED_STATUS_FAILED      = "TRANSFERS.UPDATED.STATUS.FAILED" // The transfer has failed, typically due to insufficient funds in the source account.
    const val TRANSFERS_UPDATED_STATUS_IN_PROGRESS = "TRANSFERS.UPDATED.STATUS.IN_PROGRESS" // The transfer is processing.
    const val TRANSFERS_UPDATED_STATUS_RETURNED    = "TRANSFERS.UPDATED.STATUS.RETURNED" // The transfer has been returned by the recipient's institution, typically due to incorrect account details.
    const val TRANSFERS_UPDATED_STATUS_SCHEDULED   = "TRANSFERS.UPDATED.STATUS.SCHEDULED" // The transfer has been scheduled to be processed at a future date.

    const val TRANSFERS_REFUND_CREATED = "TRANSFERS.REFUND.CREATED" // The refund has been created.
    const val TRANSFERS_REFUND_UPDATED = "TRANSFERS.REFUND.UPDATED" // The refund has been updated.
}
