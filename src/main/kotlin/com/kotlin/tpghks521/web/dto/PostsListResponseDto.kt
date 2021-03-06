package com.kotlin.tpghks521.web.dto

import com.kotlin.tpghks521.domain.posts.Posts
import java.time.LocalDateTime

data class PostsListResponseDto(
    var id: Long,
    var title: String?,
    var author: String?,
    var modifiedDate: LocalDateTime
) {
    constructor(posts: Posts) : this(posts.id, posts.title, posts.author, posts.modifiedDate)
}
