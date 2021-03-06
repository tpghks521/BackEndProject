package com.kotlin.tpghks521.domain.posts

import com.kotlin.tpghks521.domain.BaseTimeEntity
import javax.persistence.*

@Entity
data class Posts(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    @Column(length = 500, nullable = false)
    var title: String? = null,
    @Column(columnDefinition = "TEXT", nullable = false)
    var content: String? = null,
    val author: String? = null,
) : BaseTimeEntity() {

    constructor() : this(
        content = "Test"
    )

    fun update(title: String, content: String) {
        this.title = title
        this.content = content

    }
}