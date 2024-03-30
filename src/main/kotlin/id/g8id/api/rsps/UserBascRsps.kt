package id.g8id.api.rsps

import id.g8id.api.antn.NoArg

@NoArg
data class UserBascRsps (

  var userId: String? = null
  , var dispName: String? = null
  , var moblNo: String? = null
  , var emal: String? = null
  , var lang: String? = null

  // Vendor specific data
  , var padlCstmId: String? = null
  , var padlAddrId: String? = null
  , var padlBsnsId: String? = null
  , var padlTaxIdfy: String? = null

  // Address
  , var ctnt: String? = null
  , var natnCtry: String? = null
  , var accsCtnt: String? = null
  , var accsCtry: String? = null
  , var regn: String? = null
  , var city: String? = null
  , var zipCode: String? = null
  , var frstName: String? = null
  , var midlName: String? = null
  , var lastName: String? = null
  , var addrLine1: String? = null
  , var addrLine2: String? = null
  , var telNo: String? = null

)