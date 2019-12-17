package com.example_dk.exchange.myapplication.entity.core

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
data class Launch(
    @PrimaryKey
    var id: Int,
    var missionName: String,
    var isLaunchSuccess: Boolean,
    var details: String,
    var date: String,
    var rocketName: String,
    var rocketType: String,
    var siteNameLong: String,
    var urlLogo: String,
    var urlSmallLogo: String,
    var urlArticle: String,
    var urlWiki: String,
    var urlVideo: String
) : Serializable