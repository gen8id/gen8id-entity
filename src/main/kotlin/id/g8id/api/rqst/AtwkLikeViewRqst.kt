package id.g8id.api.rqst

import id.g8id.api.antn.NoArg

@NoArg
data class AtwkLikeViewRqst (
  val grupId: String
  , val ctntType: String
  , var userId: String?
)