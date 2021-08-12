package com.bbc.bitesizerestservice.service;

import com.bbc.bitesizerestservice.model.Episode;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EpisodeService {

    Map<String, Episode> episodes;

    public EpisodeService() {
        episodes = new HashMap<>();
        episodes.put("p089kjkt",
                new Episode("p089kjkt",
                        "Meetings Have Biscuits",
                        "Villanelle agrees to a job that will take her back to London.",
                        List.of("Villanelle", "Eve Polastri", "Carolyn Martens", "Geraldine", "Kenny")));
    }

    public Episode getEpisode(String pid) {
        return episodes.get(pid);
    }

    public List<Episode> getEpisodes() {
        return new ArrayList<>(episodes.values());
    }

    public Episode createEpisode(Episode episode) {
        if (episode != null) {
            episodes.put(episode.getPid(), episode);
        }
        return episode;
    }

    public Episode updateEpisode(String pid, Episode episode) {
        if (episode != null) {
            if (pid.equals(episode.getPid())){
                var storedEpisode = episodes.get(pid);
                if ( storedEpisode != null ) {
                    episodes.remove(pid);
                    episodes.put(pid, episode);
                } else {
                    return null;
                }
            } else {
                return null;
            }
        }
        return episode;
    }

    public void deleteEpisode(String pid) {
        var episode = episodes.get(pid);
        if (episode != null) {
            episodes.remove(pid);
        }
    }
}
