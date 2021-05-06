package com.example.restaurants.model

import com.google.gson.annotations.SerializedName


data class Restaurants(

    @SerializedName("num_results") var numResults : Int? = null,
    @SerializedName("is_first_time_user") var isFirstTimeUser : Boolean? = null,
    @SerializedName("sort_order") var sortOrder : String? = null,
    @SerializedName("next_offset") var nextOffset : Int? = null,
    @SerializedName("show_ArrayList_as_pickup") var showArrayListAsPickup : Boolean? = null,
    @SerializedName("stores") var stores : ArrayList<Stores>? = null
)

data class DeliveryFeeMonetaryFields (

    @SerializedName("currency") var currency : String? = null,
    @SerializedName("display_string") var displayString : String? = null,
    @SerializedName("unit_amount") var unitAmount : Int? = null,
    @SerializedName("decimal_places") var decimalPlaces : Int? = null

)

data class ExtraSosDeliveryFeeMonetaryFields (

    @SerializedName("currency") var currency : String? = null,
    @SerializedName("display_string") var displayString : String? = null,
    @SerializedName("unit_amount") var unitAmount : Int? = null,
    @SerializedName("decimal_places") var decimalPlaces : Int? = null

)

data class PopularItems (

    @SerializedName("price") var price : Int? = null,
    @SerializedName("img_url") var imgUrl : String? = null,
    @SerializedName("description") var description : String? = null,
    @SerializedName("name") var name : String? = null,
    @SerializedName("id") var id : Int? = null

)

data class Menus (

    @SerializedName("popular_items") var popularItems : ArrayList<PopularItems>? = null,
    @SerializedName("subtitle") var subtitle : String? = null,
    @SerializedName("id") var id : Int? = null,
    @SerializedName("name") var name : String? = null,
    @SerializedName("is_catering") var isCatering : Boolean? = null

)

data class Location (

    @SerializedName("lat") var lat : Double? = null,
    @SerializedName("lng") var lng : Double? = null

)

data class Status (

    @SerializedName("unavailable_reason") var unavailableReason : String? = null,
    @SerializedName("pickup_available") var pickupAvailable : Boolean? = null,
    @SerializedName("asap_available") var asapAvailable : Boolean? = null,
    @SerializedName("scheduled_available") var scheduledAvailable : Boolean? = null,
    @SerializedName("asap_minutes_range") var asapMinutesRange : ArrayList<Int>? = null

)

data class MinimumSubtotalMonetaryFields (

    @SerializedName("currency") var currency : String? = null,
    @SerializedName("display_string") var displayString : String? = null,
    @SerializedName("decimal_places") var decimalPlaces : Int? = null,
    @SerializedName("unit_amount") var unitAmount : String? = null

)


data class MerchantPromotions (

    @SerializedName("category_new_store_customers_only") var categoryNewStoreCustomersOnly : Boolean? = null,
    @SerializedName("minimum_subtotal_monetary_fields") var minimumSubtotalMonetaryFields : MinimumSubtotalMonetaryFields? = null,
    @SerializedName("daypart_constraints") var daypartConstraints : ArrayList<String>? = null,
    @SerializedName("delivery_fee") var deliveryFee : String? = null,
    @SerializedName("delivery_fee_monetary_fields") var deliveryFeeMonetaryFields : DeliveryFeeMonetaryFields? = null,
    @SerializedName("minimum_subtotal") var minimumSubtotal : String? = null,
    @SerializedName("id") var id : Int? = null

)

data class Stores (

    @SerializedName("is_consumer_subscription_eligible") var isConsumerSubscriptionEligible : Boolean? = null,
    @SerializedName("promotion_delivery_fee") var promotionDeliveryFee : Int? = null,
    @SerializedName("delivery_fee") var deliveryFee : Int? = null,
    @SerializedName("delivery_fee_monetary_fields") var deliveryFeeMonetaryFields : DeliveryFeeMonetaryFields? = null,
    @SerializedName("num_ratings") var numRatings : Int? = null,
    @SerializedName("id") var id : Int? = null,
    @SerializedName("extra_sos_delivery_fee_monetary_fields") var extraSosDeliveryFeeMonetaryFields : ExtraSosDeliveryFeeMonetaryFields? = null,
    @SerializedName("menus") var menus : ArrayList<Menus>? = null,
    @SerializedName("average_rating") var averageRating : Double? = null,
    @SerializedName("location") var location : Location? = null,
    @SerializedName("status") var status : Status? = null,
    @SerializedName("display_delivery_fee") var displayDeliveryFee : String? = null,
    @SerializedName("description") var description : String? = null,
    @SerializedName("business_id") var businessId : Int? = null,
    @SerializedName("extra_sos_delivery_fee") var extraSosDeliveryFee : Int? = null,
    @SerializedName("cover_img_url") var coverImgUrl : String? = null,
    @SerializedName("header_img_url") var headerImgUrl : String? = null,
    @SerializedName("price_range") var priceRange : Int? = null,
    @SerializedName("name") var name : String? = null,
    @SerializedName("is_newly_added") var isNewlyAdded : Boolean? = null,
    @SerializedName("url") var url : String? = null,
    @SerializedName("next_close_time") var nextCloseTime : String? = null,
    @SerializedName("next_open_time") var nextOpenTime : String? = null,
    @SerializedName("service_rate") var serviceRate : String? = null,
    @SerializedName("distance_from_consumer") var distanceFromConsumer : Double? = null,
    @SerializedName("merchant_promotions") var merchantPromotions : ArrayList<MerchantPromotions>? = null

)