package id.g8id.api.data

import id.g8id.api.antn.NoArg

@NoArg
data class StrpReversals (
  var `object`: String? = null
  , var data: List<String>? = null
  , var hasMore: Boolean? = null
  , var url: String? = null
  , var requestParams: String? = null
)
