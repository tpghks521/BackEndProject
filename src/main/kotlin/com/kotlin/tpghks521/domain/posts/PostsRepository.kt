package com.kotlin.tpghks521.domain.posts

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

@Repository
interface PostsRepository : JpaRepository<Posts, Long> {

    fun findAllById(id: Long): List<Posts>
    fun findAllByIdAndTitleAndContent(id: Long, title: String, content: String): List<Posts>
    fun findAllByTitle(title: String): List<Posts>

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    fun findAllDesc(): List<Posts>

}