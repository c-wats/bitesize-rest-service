package com.bbc.bitesizerestservice.controller;

import com.bbc.bitesizerestservice.model.Episode;
import com.bbc.bitesizerestservice.service.EpisodeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class EpisodeController {

    EpisodeService episodeService;

    public EpisodeController(EpisodeService episodeService) {
        this.episodeService = episodeService;
    }

    @GetMapping(value = "/episode", params = "pid")
    public ResponseEntity<Episode> getEpisode(@RequestParam(required = true, value = "pid") String pid) {
        var episode = episodeService.getEpisode(pid);
        if (episode != null) {
            return new ResponseEntity<>(episode, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/episode/list")
    public ResponseEntity<List<Episode>> getEpisode() {
        var episodes = episodeService.getEpisodes();
        if (episodes != null) {
            return new ResponseEntity<>(episodes, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping(path = "/episode", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Episode> createEpisode(@RequestBody Episode episode) {
        var createdEpisode = episodeService.createEpisode(episode);
        if (createdEpisode != null) {
            return new ResponseEntity<>(createdEpisode, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(episode, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping(path = "/episode/{pid}")
    public ResponseEntity<Episode> updateEpisode(@PathVariable(value = "pid") String pid,
                                                 @RequestBody Episode episode) {
        var updatedEpisode = episodeService.updateEpisode(pid, episode);
        if (updatedEpisode != null) {
            return new ResponseEntity<>(updatedEpisode, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(episode, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(path = "/episode/{pid}")
    public void deleteEpisode(@PathVariable(value = "pid") String pid) {
        episodeService.deleteEpisode(pid);
    }
}
