package tutorial.baps.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import tutorial.baps.response.TalentResponse;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static tutorial.baps.request.TalentRequestFixture.invalidTalentRequest;
import static tutorial.baps.request.TalentRequestFixture.talentRequest;
import static tutorial.baps.response.TalentResponseFixture.talentResponse;

/**
 * FIXME: this is an example of how you should implement integration testing in your application.
 * It allows you to test a complete behavior, allowing your components to interact.
 */
@SpringBootTest
class ExampleControllerTest {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private ObjectMapper objectMapper;

    private MockMvc mockMvc;


    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    void shouldReturnAllTalents() throws Exception {
        MvcResult result = mockMvc.perform(get("/api/v1/example"))
                .andExpect(status().isOk())
                .andReturn();
        String json = result.getResponse().getContentAsString();
        List<TalentResponse> talentResponses = objectMapper.readerForListOf(TalentResponse.class).readValue(json);

        assertThat(talentResponses).isEmpty();
    }

    @Test
    void shouldReturnNotFoundOnGetOne() throws Exception {
        mockMvc.perform(get("/api/v1/example/{id}", 0))
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldCreateTalent() throws Exception {
        MvcResult result = mockMvc.perform(post("/api/v1/example")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(talentRequest())))
                .andExpect(status().isCreated())
                .andReturn();
        String json = result.getResponse().getContentAsString();
        TalentResponse talentResponse = objectMapper.readValue(json, TalentResponse.class);

        assertThat(talentResponse).usingRecursiveComparison().isEqualTo(talentResponse());
    }

    @Test
    void shouldReturnBadRequestOnCreation() throws Exception {
        mockMvc.perform(post("/api/v1/example")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(invalidTalentRequest())))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldUpdateTalent() throws Exception {
        MvcResult result = mockMvc.perform(patch("/api/v1/example/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(talentRequest())))
                .andExpect(status().isOk())
                .andReturn();
        String json = result.getResponse().getContentAsString();
        TalentResponse talentResponse = objectMapper.readValue(json, TalentResponse.class);

        assertThat(talentResponse).usingRecursiveComparison().isEqualTo(talentResponse());
    }

    @Test
    void shouldReturnBadRequestOnUpdate() throws Exception {
        mockMvc.perform(patch("/api/v1/example/{id}", 0)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(talentRequest())))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldDeactivateTalent() throws Exception {
        MvcResult result = mockMvc.perform(put("/api/v1/example/{id}/activation", 1))
                .andExpect(status().isOk())
                .andReturn();
        String json = result.getResponse().getContentAsString();
        assertThat(json).isBlank();
    }

    @Test
    void shouldReturnBadRequestOnDeactivation() throws Exception {
        mockMvc.perform(put("/api/v1/example/{id}/activation", 0))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldDeleteTalent() throws Exception {
        mockMvc.perform(delete("/api/v1/example/{id}", 1))
                .andExpect(status().isNoContent());
    }

    @Test
    void shouldReturnBadRequestOnDeletion() throws Exception {
        mockMvc.perform(delete("/api/v1/example/{id}", 0))
                .andExpect(status().isBadRequest());
    }
}