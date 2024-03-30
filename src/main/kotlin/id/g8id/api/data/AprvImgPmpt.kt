package id.g8id.api.data

import id.g8id.api.antn.NoArg


@NoArg
data class AprvImgPmpt (
  var wdth: Int? = null,
  var hegt: Int? = null,
  var fileExt: String? = null,
  var byts: Long? = null,
  var bsdeBigUrl: String? = null,
  var pmptName: String? = null
)
