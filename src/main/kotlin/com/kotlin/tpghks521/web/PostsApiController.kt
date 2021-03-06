package com.kotlin.tpghks521.web

import com.kotlin.tpghks521.domain.posts.Posts
import com.kotlin.tpghks521.service.posts.PostsService
import com.kotlin.tpghks521.web.dto.PostsResponseDto
import com.kotlin.tpghks521.web.dto.PostsSaveRequestDto
import com.kotlin.tpghks521.web.dto.PostsUpdateRequestDto
import org.slf4j.LoggerFactory
import org.springframework.boot.ApplicationRunner
import org.springframework.web.bind.annotation.*

@RestController
class PostsApiController(private val postsService: PostsService) {

//    private Logger logger = LoggerFactory.getLogger(AppRunner.class);

    var logger = LoggerFactory.getLogger(ApplicationRunner::class.java)

    @PostMapping("/api/v1/posts")
    fun save(
        @RequestBody requestDto: PostsSaveRequestDto
    ): Posts? {
        logger.debug("save")
        return postsService.save(requestDto)
    }


    @PutMapping("/api/v1/posts/{id}")
    fun update(@PathVariable id: Long, @RequestBody requestDto: PostsUpdateRequestDto): Long {
        return postsService.update(id, requestDto)
    }

    @GetMapping("/api/v1/posts/list/{id}")
    fun getList(@PathVariable("id") id:Long): List<Posts>
    {
        return postsService.getList(id)
    }

}