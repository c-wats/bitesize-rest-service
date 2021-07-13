package com.bbc.bitesizerestservice.service;

import com.bbc.bitesizerestservice.model.Episode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class EpisodeServiceTest {

    private final EpisodeService episodeService = new EpisodeService();

    static final String TEST_PID = "p089kjkt";

    @Test
    void getEpisode_validPidProvided_episodeReturned() {
        Episode expectedEpisode = episodeService.getEpisode(TEST_PID);
        assertNotNull(expectedEpisode);
        assertEquals(TEST_PID, expectedEpisode.getPid());
    }

    @Test
    void getEpisode_invalidPidProvided_episodeNotReturned() {
        assertNull(episodeService.getEpisode("pid"));
    }
}
