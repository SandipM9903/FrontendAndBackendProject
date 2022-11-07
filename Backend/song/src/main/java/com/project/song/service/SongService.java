package com.project.song.service;

import com.project.song.model.Songs;

import java.util.List;

public interface SongService
{
    public abstract Songs saveSong(Songs songs);
    public abstract List<Songs> getAllSong();
    public abstract Songs updateSong(Songs songs, String songId);
    public abstract boolean deleteSong(String songId);
}
