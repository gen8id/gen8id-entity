package id.g8id.api.rqst

import id.g8id.api.antn.NoArg

@NoArg
data class HyprWletIdvdBsicInfo(
  var userId: String
  , val emal: String
  , val frstName: String
  , val lastName: String
  , var midlName: String? = null
  , var profileType: String? = null

  , var userAgnt: String? = null
  , var lang: String? = null
  , var clientIp: String? = null
  , var host: String? = null
  , var city: String? = null
  , var ctnt: String? = null
  , var regn: String? = null
  , var pfrm: String? = null
  , var rgstUserId: String? = null
)
