package com.bbc.bitesizerestservice.service;

import com.bbc.bitesizerestservice.model.Episode;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EpisodeService {

    Map<String, Episode> episodes = Map.of("p089kjkt",
            new Episode("p089kjkt",
                    "Meetings Have Biscuits",
                    "Villanelle agrees to a job that will take her back to London.",
                    List.of("Villanelle", "Eve Polastri", "Carolyn Martens", "Geraldine", "Kenny")));

    public Episode getEpisode(String pid) {
        return episodes.get(pid);
    }
}
