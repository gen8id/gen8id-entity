package id.g8id.api.rqst

import id.g8id.api.antn.NoArg
import jakarta.ws.rs.DefaultValue
import jakarta.ws.rs.QueryParam
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@NoArg
data class AncmRgstRqst (
    var revNo: String,
    var title: String,
    var body: String,
    var ancmType: String,
    var applySince: LocalDateTime?,
    var applyUntil: LocalDateTime?,
    var lastUpdtID: String?,
    var display: Boolean?
)

@NoArg
data class AncmUpdtRqst(
    var mode: String,
    var tokn: String?,
    var revNo: String?,
    var title: String?,
    var body: String?,
    var ancmType: String?,
    var applySince: LocalDateTime?,
    var applyUntil: LocalDateTime?,
    var lastUpdtID: String?,
    var display: Boolean?
)

@NoArg
open class AncmSearchRqst {
    @field: QueryParam("applySince") var applySince: String? = null
    @field: QueryParam("applyUntil") var applyUntil: String? = null
    @field: QueryParam("title") var title: String? = null
    @field: QueryParam("ancmType") var ancmType: String? = null
    @field: QueryParam("page") @DefaultValue("1") var page: Int = 1

    fun toRqstMap(): MutableMap<String, Any?> {
        val paramList: MutableMap<String, Any?> = HashMap()
        paramList["title"] = this.title
        paramList["ancmType"] = this.ancmType
        paramList["applySince"] = if (this.applySince != null) LocalDateTime.parse(this.applySince, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX")) else null
        paramList["applyUntil"] = if (this.applyUntil != null) LocalDateTime.parse(this.applyUntil, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX")) else null
        return paramList
    }
}