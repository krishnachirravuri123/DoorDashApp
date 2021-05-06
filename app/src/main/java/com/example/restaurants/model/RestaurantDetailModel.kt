package com.example.restaurants.model

import com.google.gson.annotations.SerializedName


data class RestaurantDetailModel (
    @SerializedName("phone_number") var phoneNumber : String?  = null,
    @SerializedName("yelp_review_count") var yelpReviewCount : Int?  = null,
    @SerializedName("is_consumer_subscription_eligible") var isConsumerSubscriptionEligible : Boolean?  = null,
    @SerializedName("offers_delivery") var offersDelivery : Boolean?  = null,
    @SerializedName("max_order_size") var maxOrderSize : String?  = null,
    @SerializedName("delivery_fee") var deliveryFee : Int? = null,
    @SerializedName("max_composite_score") var maxCompositeScore : Int?  = null,
    @SerializedName("provides_external_courier_tracking") var providesExternalCourierTracking : Boolean?  = null,
    @SerializedName("id") var id : Int?  = null,
    @SerializedName("average_rating") var averageRating : Double?  = null,
    @SerializedName("tags") var tags : ArrayList<String>? = null,
    @SerializedName("delivery_radius") var deliveryRadius : Int?  = null,
    @SerializedName("inflation_rate") var inflationRate : Int? = null,
    @SerializedName("menus") var menus : List<DetailMenus>? = null,
    @SerializedName("show_store_menu_header_photo") var showStoreMenuHeaderPhoto : Boolean? = null,
    @SerializedName("composite_score") var compositeScore : Int?  = null,
    @SerializedName("fulfills_own_deliveries") var fulfillsOwnDeliveries : Boolean?  = null,
    @SerializedName("offers_pickup") var offersPickup : Boolean? = null,
    @SerializedName("number_of_ratings") var numberOfRatings : Int? = null,
    @SerializedName("status_type") var statusType : String? = null,
    @SerializedName("is_only_catering") var isOnlyCatering : Boolean? = null,
    @SerializedName("status") var status : String? = null,
    @SerializedName("delivery_fee_details") var deliveryFeeDetails : DeliveryFeeDetails? = null,
    @SerializedName("object_type") var objectType : String? = null,
    @SerializedName("description") var description : String? = null,
    @SerializedName("business") var business : Any? = null,
    @SerializedName("yelp_biz_id") var yelpBizId : String? = null,
    @SerializedName("asap_time") var asapTime : Int? = null,
    @SerializedName("should_show_store_logo") var shouldShowStoreLogo : Boolean? = null,
    @SerializedName("yelp_rating") var yelpRating : Double? = null,
    @SerializedName("extra_sos_delivery_fee") var extraSosDeliveryFee : Int? = null,
    @SerializedName("business_id") var businessId : Int? = null,
    @SerializedName("special_instructions_max_length") var specialInstructionsMaxLength : String? = null,
    @SerializedName("cover_img_url") var coverImgUrl : String? = null,
    @SerializedName("address") var address : Address? = null,
    @SerializedName("price_range") var priceRange : Int? = null,
    @SerializedName("slug") var slug : String? = null,
    @SerializedName("show_suggested_items") var showSuggestedItems : Boolean? = null,
    @SerializedName("name") var name : String? = null,
    @SerializedName("is_newly_added") var isNewlyAdded : Boolean? = null,
    @SerializedName("is_good_for_group_orders") var isGoodForGroupOrders : Boolean? = null,
    @SerializedName("service_rate") var serviceRate : Int? = null,
    @SerializedName("merchant_promotions") var merchantPromotions : List<MerchantPromotions>? = null,
    @SerializedName("header_image_url") var headerImageUrl : String? = null
        )

data class OpenHours (

    @SerializedName("hour") var hour : Int? = null,
    @SerializedName("minute") var minute : Int? = null

)

data class DetailMenus (

    @SerializedName("status") var status : String? = null,
    @SerializedName("menu_version") var menuVersion : Int? = null,
    @SerializedName("subtitle") var subtitle : String? = null,
    @SerializedName("name") var name : String? = null,
    @SerializedName("open_hours") var openHours : List<List<OpenHours>>? = null,
    @SerializedName("is_business_enabled") var isBusinessEnabled : Boolean? = null,
    @SerializedName("is_catering") var isCatering : Boolean? = null,
    @SerializedName("id") var id : Int? = null,
    @SerializedName("status_type") var statusType : String? = null

)

data class FinalFee (

    @SerializedName("display_string") var displayString : String? = null,
    @SerializedName("unit_amount") var unitAmount : Int? = null

)

data class Amount (

    @SerializedName("currency") var currency : String? = null,
    @SerializedName("display_string") var displayString : String? = null,
    @SerializedName("unit_amount") var unitAmount : Int? = null

)

data class MinSubtotal (

    @SerializedName("currency") var currency : String? = null,
    @SerializedName("display_string") var displayString : String? = null,
    @SerializedName("unit_amount") var unitAmount : Int? = null

)

data class Discount (

    @SerializedName("description") var description : String? = null,
    @SerializedName("source_type") var sourceType : String? = null,
    @SerializedName("text") var text : String? = null,
    @SerializedName("discount_type") var discountType : String? = null,
    @SerializedName("amount") var amount : Amount? = null,
    @SerializedName("min_subtotal") var minSubtotal : MinSubtotal? = null

)

data class SurgeFee (

    @SerializedName("display_string") var displayString : String? = null,
    @SerializedName("unit_amount") var unitAmount : Int? = null

)

data class OriginalFee (

    @SerializedName("display_string") var displayString : String? = null,
    @SerializedName("unit_amount") var unitAmount : Int? = null

)

data class DeliveryFeeDetails (

    @SerializedName("final_fee") var finalFee : FinalFee? = null,
    @SerializedName("discount") var discount : Discount? = null,
    @SerializedName("surge_fee") var surgeFee : SurgeFee? = null,
    @SerializedName("original_fee") var originalFee : OriginalFee? = null

)

data class Business (

    @SerializedName("business_vertical") var businessVertical : String? = null,
    @SerializedName("id") var id : Int? = null,
    @SerializedName("name") var name : String? = null

)

data class Address (

    @SerializedName("city") var city : String? = null,
    @SerializedName("subpremise") var subpremise : String? = null,
    @SerializedName("id") var id : Int? = null,
    @SerializedName("printable_address") var printableAddress : String? = null,
    @SerializedName("state") var state : String? = null,
    @SerializedName("street") var street : String? = null,
    @SerializedName("country") var country : String? = null,
    @SerializedName("lat") var lat : Double? = null,
    @SerializedName("lng") var lng : Double? = null,
    @SerializedName("shortname") var shortname : String? = null,
    @SerializedName("zip_code") var zipCode : String? = null

)


