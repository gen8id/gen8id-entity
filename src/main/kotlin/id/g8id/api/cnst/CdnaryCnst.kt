package id.g8id.api.cnst


object CdnaryCode {
  const val APPROVED    = "approved"
  const val REJECTED    = "rejected"
}

object Cdnary {

  /**
   * ref. Transformations on upload : https://cloudinary.com/documentation/transformations_on_upload
   * e.g. eager=c_crop,w_400,h_400,g_face|w_50,h_50,c_scale|w_30,h_30,c_crop,g_south
   * e.g. eager=f_wdp|f_jp2|f_webp,fl_awebp
   * e.g. eager_async=true&eager_notification_url=https://mysite.example.com/eager_endpoint&notification_url=https://mysite.example.com/upload_endpoint&eager=
   */
  const val DETECT_CAPTION          = "captioning"
  const val DETECT_CELEBS           = "aws_rek_face"
  const val MODERATOR_AWSREK        = "aws_rek"
  const val AUTOTAG_THRES_STRG      = "0.85"
  const val AUTOTAG_THRES_FLOT      = 0.85
  const val WATERMARK_PUBLIC_ID     = "assets/watermark-L"
  const val RESIZE_MODE_FIT         = "fit"         // c_limit,f_webp,h_180,q_75,w_900
  const val RESIZE_MODE_LIMIT       = "limit"       // c_limit,f_webp,h_180,q_75,w_900
  const val THUMB_S_MIN_HEIGHT      = 180
  const val THUMB_S_MAX_WIDTH       = 720
  const val THUMB_L_MAX_FIT         = 1920
  const val UPSCALE_EFFECT          = "upscale"
  const val EXT_WEBP                = "webp"
  const val QUALITY_WEBP            = "auto:good" // 75
}

object Face {
  object Emotion {
    const val CALM = "CALM"
    const val SAD = "SAD"
    const val CONFUSED = "CONFUSED"
    const val ANGRY = "ANGRY"
    const val DISGUSTED = "DISGUSTED"
    const val HAPPY = "HAPPY"
    const val FEAR = "FEAR"
    const val SURPRISED = "SURPRISED"
  }
}

/**
 * ref. https://docs.aws.amazon.com/rekognition/latest/dg/moderation.html
 */
object Moderation {

  object AdultTags {
    const val BRCHSTD = "barechested"
    const val BRCHST2 = "barechest"
  }

  object ParentAdultLabel {
    const val P_ADLT_1 = "Visually Disturbing"
    const val P_ADLT_2 = "Explicit Nudity"
    const val P_ADLT_3 = "Violence"
  }

  val ParentAdultLabelArr = arrayOf(
    ParentAdultLabel.P_ADLT_1
    , ParentAdultLabel.P_ADLT_2
    , ParentAdultLabel.P_ADLT_3
  )

  object ParentTeenLabel {
    const val SUGGST = "Suggestive"
    const val TOBBCO = "Tobacco"
    const val GAMBLN = "Gambling"
    const val HTESYM = "Hate Symbols"
    const val RUDEGS = "Rude Gestures"
    const val DRUGS  = "Drugs"
    const val ALCHOL = "Alcohol"
  }

  val ParentTeenLabelArr = arrayOf(
    ParentTeenLabel.SUGGST, ParentTeenLabel.TOBBCO
    , ParentTeenLabel.GAMBLN, ParentTeenLabel.HTESYM
    , ParentTeenLabel.RUDEGS, ParentTeenLabel.DRUGS
    , ParentTeenLabel.ALCHOL
  )

  val AllParentLableArr = arrayOf(
    ParentAdultLabel.P_ADLT_1
    , ParentAdultLabel.P_ADLT_2
    , ParentAdultLabel.P_ADLT_3
    , ParentTeenLabel.SUGGST
    , ParentTeenLabel.TOBBCO
    , ParentTeenLabel.GAMBLN
    , ParentTeenLabel.HTESYM
    , ParentTeenLabel.RUDEGS
    , ParentTeenLabel.DRUGS
    , ParentTeenLabel.ALCHOL
  )

  object AdultLable {
    const val ADLT_1  = "Emaciated Bodies"
    const val ADLT_2  = "Corpses"
    const val ADLT_3  = "Hanging"
    const val ADLT_4  = "Nudity"
    const val ADLT_5  = "Graphic Male Nudity"
    const val ADLT_6  = "Graphic Female Nudity"
    const val ADLT_7  = "Sexual Activity"
    const val ADLT_8  = "Illustrated Explicit Nudity"
    const val ADLT_9  = "Graphic Violence Or Gore"
    const val ADLT_10 = "Self Injury"
    const val ADLT_11 = "Drug Paraphernalia"
    const val ADLT_12 = "Gambling"
    const val ADLT_13 = "Nazi Party"
    const val ADLT_14 = "White Supremacy"
    const val ADLT_15 = "Extremist"
    const val ADLT_16 = "Air Crash"
    const val ADLT_17 = "Explosions And Blasts"
    const val ADLT_18 = "Sexual Situations"
    const val ADLT_19 = "Weapon Violence"
  }


  object TeenLable {
    const val SGST_1  = "Female Swimwear Or Underwear"
    const val SGST_2  = "Male Swimwear Or Underwear"
    const val SGST_3  = "Partial Nudity"
    const val SGST_4  = "Barechested Male"
    const val SGST_5  = "Revealing Clothes"
    const val SGST_6  = "Physical Violence"
    const val SGST_7  = "Weapons"
    const val SGST_8  = "Middle Finger"
    const val SGST_9  = "Drug Products"
    const val SGST_10 = "Drug Use"
    const val SGST_11 = "Pills"
    const val SGST_12 = "Tobacco Products"
    const val SGST_13 = "Smoking"
    const val SGST_14 = "Drinking"
    const val SGST_15 = "Alcoholic Beverages"
  }

  val AdultLableArr = arrayOf(
    AdultLable.ADLT_1,
    AdultLable.ADLT_2,
    AdultLable.ADLT_3
    ,
    AdultLable.ADLT_4,
    AdultLable.ADLT_5,
    AdultLable.ADLT_6
    ,
    AdultLable.ADLT_7,
    AdultLable.ADLT_8,
    AdultLable.ADLT_9
    ,
    AdultLable.ADLT_10,
    AdultLable.ADLT_11,
    AdultLable.ADLT_12
    ,
    AdultLable.ADLT_13,
    AdultLable.ADLT_14,
    AdultLable.ADLT_15
    ,
    AdultLable.ADLT_16,
    AdultLable.ADLT_17,
    AdultLable.ADLT_18
    ,
    AdultLable.ADLT_19
  )

  // Parental advisory
  val TeenLableArr = arrayOf(
    TeenLable.SGST_1,
    TeenLable.SGST_2,
    TeenLable.SGST_3
    ,
    TeenLable.SGST_4,
    TeenLable.SGST_5,
    TeenLable.SGST_6
    ,
    TeenLable.SGST_7,
    TeenLable.SGST_8,
    TeenLable.SGST_9
    ,
    TeenLable.SGST_10,
    TeenLable.SGST_11,
    TeenLable.SGST_12
    ,
    TeenLable.SGST_13,
    TeenLable.SGST_14,
    TeenLable.SGST_15
  )

}

