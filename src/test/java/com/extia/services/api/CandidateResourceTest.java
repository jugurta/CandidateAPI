package com.extia.services.api;


import com.extia.services.api.candidate.Candidate;
import com.extia.services.api.candidate.CandidateResource;
import com.extia.services.api.candidate.CandidateService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = CandidateResource.class)


public class CandidateResourceTest {


    @Autowired
    private MockMvc mockMvc;

    @MockBean
    CandidateService candidateService;


    @Test
    public void getCandidate() throws Exception {
        String url = "/api/v1/candidates";
        String parameter = "/1";

        Candidate mockCandidate = new Candidate(1, "HELLO", "WORLD", 25, 5);
        Mockito.when(candidateService.getById(Mockito.anyLong())).thenReturn(Optional.ofNullable(mockCandidate));
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                url.concat(parameter)).accept(
                MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String output = result.getResponse().getContentAsString();
        String expected = "{\"id\":1,\"name\":\"HELLO\",\"surname\":\"WORLD\",\"age\":25,\"interview_mark\":5}";
        assertThat(expected).isEqualTo(output);
    }

    @Test
    public void createCandidate() throws Exception {
        String url = "/api/v1/candidates";
        String exampleCandidateJson = "{\"id\":1,\"name\":\"HELLO\",\"surname\":\"WORLD\",\"age\":25,\"interview_mark\":5}";
        Candidate mockCandidate = new Candidate(1, "HELLO", "WORLD", 25, 5);
        Mockito.when(candidateService.insertCandidate(Mockito.any(Candidate.class))).thenReturn(mockCandidate);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post(url)
                .accept(MediaType.APPLICATION_JSON).content(exampleCandidateJson)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertThat(HttpStatus.CREATED.value()).isEqualTo(response.getStatus());
        assertThat(response.getContentAsString()).isEqualTo(exampleCandidateJson);


    }


    @Test
    public void deleteCandidate() throws Exception {
        String url = "/api/v1/candidates";
        String parameter = "/1";
        Mockito.when(candidateService.deleteCandidateById(Mockito.anyLong())).thenReturn(true);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete(
                url.concat(parameter)).accept(
                MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpect(status().isOk());
    }

    @Test
    public void deleteMultipleCandidates() throws Exception {
        String url = "/api/v1/candidates/many";
        String exampleCandidateList = "[{\"id\":1,\"name\":\"HELLO\",\"surname\":\"WORLD\",\"age\":25,\"interview_mark\":5}]";
        Mockito.when(candidateService.deletesCandidates(Mockito.anyList())).thenReturn(true);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.delete(
                url).accept(
                MediaType.APPLICATION_JSON).content(exampleCandidateList).contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(requestBuilder).andExpect(status().isOk());
    }
}
