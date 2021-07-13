package com.bbc.bitesizerestservice.model;

import java.util.List;

public class Episode {

    private final String pid;
    private final String title;
    private final String synopsis;
    private final List<String> characters;

    public Episode(String pid, String title, String synopsis, List<String> characters) {
        this.pid = pid;
        this.title = title;
        this.synopsis = synopsis;
        this.characters = characters;
    }

    public String getPid() {
        return pid;
    }

    public String getTitle() {
        return title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public List<String> getCharacters() {
        return characters;
    }
}
