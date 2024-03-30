package id.g8id.api.rqst

import id.g8id.api.antn.NoArg

@NoArg
data class AddCartRqst(

  var cstmData: Map<String, String>?,
  var ctntType: String?,
  var grupId: String,
  var titl: String?,
  val ctry: String,
  val crcy: String,
  var pblcThumUrl: String?,
  var imgIdList: List<String>?,
  var items: List<PadlItem>,
  val imgPricId: String?,
  val pmptPricId: String?,
  var dsctId: String?,
  var totlPric: Double?,
  var frmtTotl: String?,
  var crtrId: String?,
  var crtrGrad: String?,
  val plfmFeeRate: Int?,
  val imgCnt: Int,
  val pmptCnt: Int,
  var userId: String?
)

data class PadlItem(
  var priceId: String?,
  var quantity: Int = 1
)