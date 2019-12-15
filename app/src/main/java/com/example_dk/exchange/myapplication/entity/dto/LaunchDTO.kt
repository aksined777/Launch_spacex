package com.example_dk.exchange.myapplication.entity.dto

import com.example_dk.exchange.myapplication.entity.core.Launch
import com.squareup.moshi.Json


class LaunchDTO(
    @field:Json(name = "flight_number")
    var id: Int?,

    @field:Json(name = "mission_name")
    var mission_name: String?,

    @field:Json(name = "launch_success")
    var isLaunch_success: Boolean?,

    @field:Json(name = "details")
    var details: String?,

    @field:Json(name = "rocket")
    var rocket: RocketDTO? = null,

    @field:Json(name = "launch_site")
    var launchSite: LaunchSite? = null,

    @field:Json(name = "links")
    var links: Links? = null,

    @field:Json(name = "launch_date_local")
    var date: String? = null

)

fun LaunchDTO.toLaunch(): Launch {
    return Launch(
        id = id ?: 0,
        mission_name = mission_name ?: "",
        isLaunch_success = isLaunch_success ?: false,
        details = details ?: "",
        date = date ?: "",
        rocketName = rocket?.rocketName ?: "",
        rocketType = rocket?.rocketType ?: "",
        siteNameLong = launchSite?.siteNameLong ?: "",
        urlLogo = links?.urlLogo ?: "",
        urlSmallLogo = links?.urlSmallLogo ?: "",
        urlArticle = links?.urlArticle ?: "",
        urlWiki = links?.urlWikipedia ?: "",
        urlVideo = links?.urlVideo ?: ""
    )
}


