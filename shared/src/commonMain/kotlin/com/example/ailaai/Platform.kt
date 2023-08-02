package com.example.ailaai
interface Platform {
    val name: String
}

expect fun getPlatform(): Platform