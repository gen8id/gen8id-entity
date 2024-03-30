package id.g8id.api.cnst

const val ART_META_ROOT = "view/atwk/"

object GenTool {
  const val MID_JRNY  = "GNTL0000"
  const val NIJI_JRNY = "GNTL0001"
  const val STBL_DIFF = "GNTL0002"
}

object ArtRegistStep {
  const val REQUESTED     = "RGMJ0000"
  const val APPROVED      = "RGMJ0001"
  const val REJECTED      = "RGMJ0002"
  const val IN_REVIEW     = "RGMJ0007"
  const val WORKING_1     = "RGMJ0008"
  const val WORKING_2     = "RGMJ0009"
}

object AspectRatio {
  const val LAND = "APRT0000"
  const val SQRE = "APRT0001"
  const val PORT = "APRT0002"
}

object AspectRatioVal {
  const val LAND = 1.1
  const val SQRE = 1.0
  const val PORT = 0.9
}

object PricType {
  const val IMAGE    = "imag"
  const val PROMPT   = "pmpt"
}

object ContentType {
  const val IMAGE    = "image"
  const val VIDEO    = "video"
  const val AUDIO    = "audio"
  const val TEXT     = "text"
}

object ContentTypeShort {
  const val IMAGE    = "IMAG"
  const val VIDEO    = "VIDO"
  const val AUDIO    = "AUDO"
  const val TEXT     = "TEXT"
  const val PROMPT   = "PMPT"
}

val CONTENT_TYPE_ARR = arrayOf(
  ContentType.IMAGE
  , ContentType.VIDEO
  , ContentType.AUDIO
  , ContentType.TEXT
)

val CONTENT_TYPE_SHORT_ARR = arrayOf(
  ContentTypeShort.IMAGE
  , ContentTypeShort.VIDEO
  , ContentTypeShort.AUDIO
  , ContentTypeShort.TEXT
)

object UselessKywd {
  const val WOMAN   = "woman"
  const val MAN     = "man"
  const val ADULT   = "adult"
  const val FEMALE  = "female"
  const val MALE    = "male"
  const val FACE    = "face"
  const val HEAD    = "head"
  const val PERSON  = "person"
}

val NO_USE_KEYWORDS = arrayOf(
  UselessKywd.WOMAN
  , UselessKywd.MAN
  , UselessKywd.ADULT
  , UselessKywd.FEMALE
  , UselessKywd.MALE
  , UselessKywd.FACE
  , UselessKywd.HEAD
  , UselessKywd.PERSON
)

object Product {
  const val MIN_LEN_PROMPT = 10
  const val MIN_LEN_IMG_RESOL = 200000L
  const val MAX_GRAD = 64
}
