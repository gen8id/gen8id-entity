package id.g8id.api.rqst

import id.g8id.api.antn.NoArg

@NoArg
data class CodeRqst (
  var id: String?,
  var grupCode: String,
  var code: String,
  var name: String,
  var valu: String?,
  var ordr: Int?,
  var remk: String?
)

@NoArg
data class CodeUpdt (
  var id: String?,
  var grupCode: String,
  var code: String?,
  var name: String?,
  var valu: String?,
  var ordr: Int?,
  var remk: String?,
  var disp: Boolean?,
  var page: Int = 1
)