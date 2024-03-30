package id.g8id.api.cnst


object Cloudflare {
  // ref. https://developers.cloudflare.com/rules/transform/managed-transforms/reference/
  const val CF_IP          = "cf-ip"
  const val CF_IPCITY      = "cf-city" // The visitor's city (value from the ip.src.city field).
  const val CF_IPCOUNTRY   = "cf-country" // The visitor's country (value from the ip.src.country field).
  const val CF_IPCONTINENT = "cf-continent" // The visitor's continent (value from the ip.src.continent field).
  const val CF_REGION      = "cf-region" // The visitor's region (value from the ip.src.region field).
  const val CF_PLATFORM    = "cf-platform"
  const val CF_LANG        = "cf-lang"
  const val CF_HOST        = "cf-host"

  const val CF_REGION_CODE = "cf-region-code"  // The visitor's region code (value from the ip.src.region_code field).
  const val CF_TIMEZONE    = "cf-timezone" //  The name of the visitor's timezone (value from the ip.src.timezone.name field).
  const val CF_POSTALCODE  = "cf-postal-code" // The visitor’s postal code (value from the ip.src.postal_code field).

}
