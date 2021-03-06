package com.kotlin.tpghks521.domain.posts

import com.kotlin.tpghks521.web.dto.PostsSaveRequestDto
import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.assertj.core.api.Assertions.assertThat

@RunWith(SpringRunner::class)
@SpringBootTest
class PostsRepositoryTest(private var postsRepository: PostsRepository) {



    @After
    fun cleanup() {
        postsRepository.deleteAll()
    }

    @Test
    fun 게시글저장_불러오기() {
        //given
        val title = "테스트 게시글"
        val content = "테스트 본문"
       var a = PostsSaveRequestDto("aa","bb","cc")

        postsRepository.save(Posts(title = title, content = content, author = "tpghks521@gamil.com"))

//        when
        val postsList: List<Posts> = postsRepository.findAll()

//        then
        val posts: Posts = postsList.get(0)
        assertThat(posts.title).isEqualTo(title)
        assertThat(posts.content).isEqualTo(content)

    }
}