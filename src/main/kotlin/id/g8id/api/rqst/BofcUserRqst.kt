package id.g8id.api.rqst

import id.g8id.api.antn.NoArg
import jakarta.validation.constraints.NotBlank
import jakarta.ws.rs.DefaultValue
import jakarta.ws.rs.QueryParam

@NoArg
data class BofcSignInRqst (
  var userId: String
  , var pswd: String
  , @NotBlank var tokn: String
  , var encPswd: String?
  , var userAgent: String?
  , var ip: String?
  , var host: String?
  , var ctnt: String?
  , var ctry: String?
  , var regn: String?
  , var city: String?
  , var pfrm: String?
  , var lang: String?
  , var pvdr: String?
)

@NoArg
data class BofcSignUpRqst (
  var dispName: String,
  var emal: String,
  var moblNo: String,
  var role: String,
  var pswd: String
)

@NoArg
data class BofcUserUpdtRqst (
  var id: String?,
  var mode: String,
  var tokn: String?,
  var dispName: String?,
  var rgstUserId: String?,
  var email: String?,
  var moblNo: String?,
  var jobTitle: String?,
  var role: String?,
  var stts: String?
)

@NoArg
open class BofcUserSearchRqst {
  @field: QueryParam("dispName") var srchDispName: String? = null
  @field: QueryParam("stts") var srchSttsStr: String? = null
  @field: QueryParam("role") var srchRoleStr: String? = null
  @field: QueryParam("page") @DefaultValue("1") var page: Int = 1

  fun toRqstMap(): MutableMap<String, Any?> {
    val paramList: MutableMap<String, Any?> = HashMap()
    paramList["dispName"] = this.srchDispName
    paramList["sttsStr"] = if (srchSttsStr == "All") null else srchSttsStr
    paramList["roleStr"] = if (srchRoleStr == "All") null else srchRoleStr
    return paramList
  }
}