package com.kotlin.tpghks521.web

import com.kotlin.tpghks521.service.posts.PostsService
import com.kotlin.tpghks521.web.dto.HelloResponseDto
import com.kotlin.tpghks521.web.dto.PostsSaveRequestDto
import org.springframework.web.bind.annotation.*

@RestController
class HelloController(private val postsService: PostsService) {

    @GetMapping("/hello")
    fun hello(): String {
        return "hello"
    }

    @GetMapping("/hello/dto")
    fun helloDto(
        @RequestParam("name") name: String,
        @RequestParam("amount") amount: Int
    ): HelloResponseDto {



        return HelloResponseDto(name, amount)
    }



}