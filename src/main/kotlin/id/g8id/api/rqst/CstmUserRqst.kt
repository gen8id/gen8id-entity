package id.g8id.api.rqst

import id.g8id.api.antn.NoArg
import jakarta.ws.rs.DefaultValue
import jakarta.ws.rs.QueryParam
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@NoArg
data class CstmUserEmalSginRqst (
    var userId: String,
    var pswd: String,
    var t1: String,
    var encPswd: String?,
    var fngrPrnt: String,
    var pvdr: String? = "e",

    var userStts: String?,
    var userAgnt: String?,
    var ctnt: String?,
    var ctry: String?,
    var regn: String?,
    var city: String?,
    var plfm: String?,
    var lang: String?,
    var host: String?,
    var connIp: String?,
    var tmzn: String?,
    var refr: String?,
    var xRealIp: String?

)


@NoArg
data class CstmUserSnsSginRqst (
    var t1: String?,
    var tokn: String,
    var fngrPrnt: String,
    var uid: String?,
    var pvdr: String?,
    var userId: String?,

    var userStts: String?,
    var userAgnt: String?,
    var ctnt: String?,
    var ctry: String?,
    var regn: String?,
    var city: String?,
    var plfm: String?,
    var lang: String?,
    var host: String?,
    var connIp: String?,
    var tmzn: String?,
    var refr: String?,
    var xRealIp: String?,

    var isMobile: Boolean = false
)

@NoArg
data class CstmUserSgupRqst (
    var userId: String,
    var emal: String,
    var pswd: String?,
    var dispName: String?,
    var frstName: String?,
    var lastName: String?,
    var pvdr: String,
    var emalVrfy: Boolean?,
    var phtoUrl: String?,
    var fbseUid: String?,

    var userAgnt: String?,
    var ctnt: String?,
    var ctry: String?,
    var regn: String?,
    var city: String?,
    var plfm: String?,
    var lang: String?,
    var host: String?,
    var connIp: String?,
    var tmzn: String?,
    var refr: String?,
    var xRealIp: String?
)

@NoArg
data class CstmUserFbseToknRqst (
    var fbseId: String,
    var emal: String
)

@NoArg
data class CstmUserFbseSgupRqst (
    var userId: String,
    var pswd: String,
    var emal: String,
)

@NoArg
data class CstmUserUpdtRqst(
    var id: String? = null,
    var mode: String,
    var pswd: String? = null,
    var fbseUid: String? = null,
    var dispName: String? = null,
    var rgstUserId: String? = null,
    var emal: String? = null,
    var moblNo: String? = null,
    var userStts: String? = null,
    var type: String? = null,
    var selrJoinStep: String? = null,
    var bofcRgst: Boolean? = null,
    var ageVrfyCd: String? = null,
    var frstName: String? = null,
    var midlName: String? = null,
    var lastName: String? = null,
    var regn: String? = null,
    var natnCtry: String? = null,
    var addrLine1: String? = null,
    var selfItro: String? = null,
)

@NoArg
open class CstmUserSrchRqst {
    @field: QueryParam("dispName") var dispName: String? = null
    @field: QueryParam("userStts") var userStts: String? = null
    @field: QueryParam("userClass") var userClass: String? = null
    @field: QueryParam("lang") var lang: String? = null
    @field: QueryParam("ctry") var ctry: String? =null
    @field: QueryParam("rgstFrom") var rgstFrom: String? = null
    @field: QueryParam("rgstTo") var rgstTo: String? = null
    @field: QueryParam("page") @DefaultValue("1") var page: Int = 1
    @field: QueryParam("bofcRgst") var bofcRgst: Boolean? = null

    fun toRqstMap(): MutableMap<String, Any?> {
        val paramList: MutableMap<String, Any?> = HashMap()
        paramList["dispName"] = this.dispName
        paramList["userStts"] = if (this.userStts == "All") null else this.userStts
        paramList["userClass"] = if (this.userClass == "All") null else this.userClass
        paramList["lang"] = if (this.lang == "All") null else this.lang
        paramList["ctry"] = if (this.ctry == "All") null else this.ctry
        paramList["bofcRgst"] = if (this.bofcRgst != null) this.bofcRgst else null
        paramList["rgstFrom"] = if (this.rgstFrom != null) LocalDateTime.parse(this.rgstFrom, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX")) else null
        paramList["rgstTo"] = if (this.rgstTo != null) LocalDateTime.parse(this.rgstTo, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX")) else null
        return paramList
    }
}