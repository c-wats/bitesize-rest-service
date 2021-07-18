package com.bbc.bitesizerestservice.controller;

import com.bbc.bitesizerestservice.model.Episode;
import com.bbc.bitesizerestservice.service.EpisodeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class EpisodeControllerTest {

    @Mock
    EpisodeService episodeService;

    EpisodeController episodeController;

    static final String TEST_PID = "p089kjkt";

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        episodeController = new EpisodeController(episodeService);
    }

    @Test
    void getEpisode_validPid_episodeReturned_200() {
        when(episodeService.getEpisode(TEST_PID))
                .thenReturn(new Episode(TEST_PID, "Test","Test", List.of("Test")));
        ResponseEntity<Episode> response =  episodeController.getEpisode(TEST_PID);
        assertEquals(TEST_PID, response.getBody().getPid());
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void getEpisode_invalidPid_badRequest_400() {
        when(episodeService.getEpisode("pid"))
                .thenReturn(null);
        ResponseEntity<Episode> response =  episodeController.getEpisode("pid");
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }
}
