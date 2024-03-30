package id.g8id.api.enttcomp.wh

import io.quarkus.mongodb.panache.kotlin.PanacheMongoEntity
import java.time.LocalDateTime

class RfshTokn: PanacheMongoEntity {

    constructor(): super()

    constructor(
        value: String,
        userId: String,
        exprDttm: LocalDateTime
    ) {
        this.vlue = value
        this.userId = userId
        this.exprDttm = exprDttm
    }

    var vlue: String? = null
    var userId: String? = null
    var exprDttm: LocalDateTime? = null // expiration date
    var crtdByIp: String? = null    // Ip, from which token was issued
    var crtdDttm: LocalDateTime? = null
    var prvsVlue: String? = null
    var rvkdByIp: String? = null // Ip, from which token was revoked
    var rvkdDttm: LocalDateTime? = null

}