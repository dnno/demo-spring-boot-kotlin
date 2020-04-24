package com.example.demo

import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get

@WebMvcTest(controllers = [DemoController::class])
internal class DemoControllerTest {

    @Autowired
    lateinit var mockMvc: MockMvc

    @MockkBean
    lateinit var demoService: DemoService

    @Test
    internal fun `internal test method with project name postfix`() {

    }

    @Test
    fun `public test method without project name postfix`() {

        every { demoService.hello() } returns "hello from mockk"

        val response = mockMvc
            .perform(get("/hello"))
            .andReturn()
            .response

        assertThat(response.status).isEqualTo(200)
        assertThat(response.contentAsString).isEqualTo("hello from mockk")
    }
}