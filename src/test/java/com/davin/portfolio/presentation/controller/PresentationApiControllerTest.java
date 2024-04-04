package com.davin.portfolio.presentation.controller;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("[API 컨트롤러 테스트]")
class PresentationApiControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Introductions 조회")
    void testGetIntroductions() throws Exception {
        // given
        String uri = "/api/v1/introductions";

        // when
        MvcResult mvcResult = performGet(uri);
        String contentAsString = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);  // 한글깨짐 방지
        JSONArray jsonArray = new JSONArray(contentAsString);

        // then
        assertThat(jsonArray.length()).isPositive();
    }

    @Test
    @DisplayName("Links 조회")
    void testGetLinks() throws Exception {
        // given
        String uri = "/api/v1/links";

        // when
        MvcResult mvcResult = performGet(uri);
        String contentAsString = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
        JSONArray jsonArray = new JSONArray(contentAsString);

        // then
        assertThat(jsonArray.length()).isPositive();
    }

    @Test
    @DisplayName("Resume 조회")
    void testGetResume() throws Exception {
        // given
        String uri = "/api/v1/resume";

        // when
        MvcResult mvcResult = performGet(uri);
        String contentAsString = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
        JSONObject jsonObject = new JSONObject(contentAsString);

        // then
        assertThat(jsonObject.optJSONArray("experiences").length()).isPositive();
        assertThat(jsonObject.optJSONArray("achievements").length()).isPositive();
        assertThat(jsonObject.optJSONArray("skills").length()).isPositive();
    }

    @Test
    @DisplayName("Projects 조회")
    void testGetProjects() throws Exception {
        // given
        String uri = "/api/v1/projects";

        // when
        MvcResult mvcResult = performGet(uri);
        String contentAsString = mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8);
        JSONArray jsonArray = new JSONArray(contentAsString);

        // then
        assertThat(jsonArray.length()).isPositive();
    }

    private MvcResult performGet(String uri) throws Exception {
        return mockMvc.perform(MockMvcRequestBuilders.get(uri))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
    }
}