package com.kotlin.tpghks521.service.posts

import com.kotlin.tpghks521.domain.posts.Posts
import com.kotlin.tpghks521.domain.posts.PostsRepository
import com.kotlin.tpghks521.web.dto.PostsListResponseDto
import com.kotlin.tpghks521.web.dto.PostsResponseDto
import com.kotlin.tpghks521.web.dto.PostsSaveRequestDto
import com.kotlin.tpghks521.web.dto.PostsUpdateRequestDto
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException
import java.util.function.Function
import javax.transaction.Transactional

@Service
open class PostsService(private val postsRepository: PostsRepository) {

    @Transactional
    open fun save(requestDto: PostsSaveRequestDto): Posts? {
        print("PostsService  save  ${requestDto.title}")
        return postsRepository.save(requestDto.toEntity())
    }

    @Transactional
    open fun update(id: Long, requestDto: PostsUpdateRequestDto): Long {
        val posts = postsRepository.findById(id).orElseThrow { IllegalArgumentException("해당 게시글이 없습니다. id = $id") }
        posts.update(requestDto.title, requestDto.content)

        return id
    }

    @Transactional
    open fun getList(id: Long): List<Posts> {
        return postsRepository.findAllById(id)
    }

    @Transactional
    open fun findAllDesc(): List<PostsListResponseDto> {
        return postsRepository.findAllDesc().map { data ->
            PostsListResponseDto(data)
        }.toList()
    }


    fun findById(id: Long): PostsResponseDto {
        val entity = postsRepository.findById(id).orElseThrow {
            IllegalArgumentException("해당 게시글이 없습니다. id = $id")
        }
        return PostsResponseDto(entity)
    }

}