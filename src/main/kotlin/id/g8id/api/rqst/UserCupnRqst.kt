package id.g8id.api.rqst

import id.g8id.api.antn.NoArg
import jakarta.validation.constraints.NotBlank
import jakarta.ws.rs.DefaultValue
import jakarta.ws.rs.QueryParam
import java.time.LocalDateTime

@NoArg
data class UserCupnRgstRqst(
  @NotBlank val cupnType: String,
  @NotBlank val actvPerd: Int,
  val asgnUserId: String?
)

// ToDo: Change arguments
@NoArg
data class UserCupnUpdtRqst(
  val mode: String,
  val cupnCode: String?,
  val cupnType: String?,
  val actvPerd: Int?,
  val actv: Boolean?,
  val asgnDttm: LocalDateTime?,
  val asgnUserId: String?,
  val abutCupn: String?
)

@NoArg
open class UserCupnSrchRqst {

  @field: QueryParam("abutCupn") var abutCupn: String? = null
  @field: QueryParam("actv") var actv: Boolean? = null
  @field: QueryParam("cupnCode") var cupnCode: String? = null
  @field: QueryParam("asgnUserId") var asgnUserId: String? = null
  @field: QueryParam("btchSize") var btchSize: Int = 15
  @field: QueryParam("page") @DefaultValue("1") var page: Int = 1

  fun toRqstMap(): MutableMap<String, Any?> {
    val paramList: MutableMap<String, Any?> = HashMap()
    paramList["abutCupn"] = this.abutCupn
    paramList["actv"] = this.actv
    paramList["cupnCode"] = this.cupnCode
    paramList["asgnUserId"] = this.asgnUserId
    return paramList
  }

}