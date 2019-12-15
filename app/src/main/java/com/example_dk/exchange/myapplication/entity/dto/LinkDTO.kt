package com.example_dk.exchange.myapplication.entity.dto

import com.squareup.moshi.Json

class Links(

    @field:Json(name = "mission_patch")
    var urlLogo: String,

    @field:Json(name = "mission_patch_small")
    var urlSmallLogo: String,

    @field:Json(name = "article_link")
    var urlArticle: String,

    @field:Json(name = "wikipedia")
    var urlWikipedia: String,

    @field:Json(name = "video_link")
    var urlVideo: String
)

