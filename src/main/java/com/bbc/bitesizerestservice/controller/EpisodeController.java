package com.bbc.bitesizerestservice.controller;

import com.bbc.bitesizerestservice.model.Episode;
import com.bbc.bitesizerestservice.service.EpisodeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EpisodeController {

    EpisodeService episodeService;

    public EpisodeController(EpisodeService episodeService) {
        this.episodeService = episodeService;
    }

    @GetMapping("/episode")
    public ResponseEntity<Episode> getEpisode(@RequestParam(value = "pid") String pid) {
        var episode = episodeService.getEpisode(pid);
        if (episode != null) {
            return new ResponseEntity<>(episode, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
