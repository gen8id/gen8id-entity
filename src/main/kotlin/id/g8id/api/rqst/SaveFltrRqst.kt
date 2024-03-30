package id.g8id.api.rqst

import id.g8id.api.antn.NoArg

@NoArg
data class SaveFltrRqst (
  var id: String
  , var fltrNm: String
  , var userId: String? = null
  , var prvdCd: List<String>? = null
  , var asptRtio: List<String>? = null
  , var ctntAgeGrad: List<String>? = null
  , var stle: List<String>? = null
  , var ctgr: List<String>? = null
  , var kywd: List<String>? = null
  , var ordrBy: String? = null

)