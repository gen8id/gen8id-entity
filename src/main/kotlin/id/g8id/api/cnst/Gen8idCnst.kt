package id.g8id.api.cnst

val DSBD_PRVW_IMG_LIST_SIZE = 30
val TOP_KEYWORD_RANK_SIZE   = 20
val SESSION_MINUTES         = 60 * 9
val ACCESS_TOKEN_DURATION   = 5

val FREQ_USED_CODES = arrayOf (
  CodeGrup.MIDJR_VERS
  , CodeGrup.NJJR_VERS
  , CodeGrup.DALLE_VERS
  , CodeGrup.CREATOR_JOIN_STEP
  , CodeGrup.CREATOR_GRADE
  , CodeGrup.ART_RGST_STEPS_MJ
  , CodeGrup.GEN_TOOLS_CURR_AVAIL
  , CodeGrup.MEDIA_AVAIL_GRADES
  , CodeGrup.ART_SORT_STANDARD
  , CodeGrup.USER_ACTIVE_STATUS
  , CodeGrup.CREATOR_CLAIM_CODE
  , CodeGrup.GLOBAL_CONTINENTS
  , CodeGrup.UPSCALERS
  , CodeGrup.BOFC_USER_PERMISSION
  , CodeGrup.CONTENT_RIGHT_ISSUE
  , CodeGrup.IMAGE_ASPECT_RATIO
  , CodeGrup.PURCHASE_STATUS
)

object ContentViewGradeSet {
  val EVERYONE = mutableListOf(ContentAgeGrade.EVERYONE)
  val TEEN = mutableListOf(ContentAgeGrade.EVERYONE, ContentAgeGrade.TEEN)
}

object ArtSortOrderBy {
  const val LATEST     = "AORD0000" // aprvDttm desc
  const val RECOMMEND  = "AORD0001"
  const val PURCHASED  = "AORD0003"
  const val FAVORED    = "AORD0004"
  const val EXPENSIVE  = "AORD0006"
  const val RANDOM     = "AORD0008"
}

object CouponCodes {
  const val INIT_CONTRIBUTOR_LEV_12  = "CPCD0099"
}

object ContentAgeGrade {
  const val EVERYONE  = "MAAG0000"
  const val TEEN      = "MAAG0001"
  const val ADULT     = "MAAG0002"
  const val ADULT_P   = "MAAG0003"
  // const val ALL       = "MAAG0009"
}

object UselessKywds {
  const val K_1     = "adult"
  const val K_2     = "calm"
}

object UserAgeVerify {
  const val NOT_VERIFIED       = "USVG0000" // (=NO_WALLET)
  const val VRFY_BY_PAYPAL     = "USVG0001"
  const val VRFY_BY_STRIPE     = "USVG0002"
  const val INREVIEW_BY_PAYPAL = "USVG0003"
  const val INREVIEW_BY_STRIPE = "USVG0004"
}

object UserClaim {
  const val NO_CLAIM               = "CLRN0000"
  const val NOT_ADULT_CONTENTS     = "CLRN0001"
  const val NOT_CELEBRITY_CONTENTS = "CLRN0002"
}

val CLAIM_CODES = mutableListOf(
  UserClaim.NOT_ADULT_CONTENTS
  , UserClaim.NOT_CELEBRITY_CONTENTS
)

object CreatorAdvantage {
  const val NONE            = "CTAT0000"
  const val IGNORE_APPROVAL = "CTAT0001"
}

object CreatorGrade {
  const val NO_CREATOR = "CTGD0000"
  const val LEVEL_1    = "CTGD0001"
  const val LEVEL_2    = "CTGD0002"
  const val LEVEL_3    = "CTGD0003"
  const val LEVEL_4    = "CTGD0004"
  const val LEVEL_5    = "CTGD0005"
  const val LEVEL_6    = "CTGD0006"
  const val LEVEL_7    = "CTGD0007"
  const val LEVEL_8    = "CTGD0008"
  const val LEVEL_9    = "CTGD0009"
  const val LEVEL_10   = "CTGD0010"
  const val LEVEL_11   = "CTGD0011"
  const val LEVEL_12   = "CTGD0012"
}

object CreatorDetail {
  val COLLECTION_PER_PAGE = 80
}

val ART_CATOGORIES = arrayOf(
  "Funny"
  , "Happy"
  , "Virtue"
  , "Futuristic"
  , "Cyberpunk"
  , "Steampunk"
  , "Angel"
  , "Food"
  , "Architectural design"
  , "Interior"
  , "Abstract"
  , "Fantasy"
  , "Sci-Fi"
  , "Weird/Scary/Horror/Creepy"
  , "Devil/Evil/Vice"
  , "Celebrity"
  , "Religion"
  , "Hero"
  , "Robot"
  , "AI"
  , "Mechanic"
  , "Airplane"
  , "Fast car"
  , "Vehicle"
  , "Landscape"
  , "Creative"
  , "Medieval"
  , "Asian"
  , "Party"
  , "Event"
  , "Graduation"
  , "Celebration"
  , "Portrait"
)

val ART_STYLES = arrayOf(
  "Cartoon"
  , "Realistic"
  , "Photo"
  , "Retro"
  , "Pixel art"
  , "8bit game"
  , "2bit game"
  , "Chinese ink brush"
  , "Renaissance art"
  , "Modern art"
  , "Pop art"
  , "Anime"
  , "Comics"
  , "Manga"
  , "4cut"
  , "Painting"
  , "Sticker"
  , "Multi cut"
  , "Figure"
  , "Minecraft"
  , "Origami"
  , "ASCII art"
)
