package com.kotlin.tpghks521.web.dto

import com.kotlin.tpghks521.domain.posts.Posts

data class PostsSaveRequestDto(
    val title: String?,
    val content: String?,
    val author: String?) {

    fun toEntity(): Posts {
        return Posts(title = title, content = content, author = author)
    }
}
