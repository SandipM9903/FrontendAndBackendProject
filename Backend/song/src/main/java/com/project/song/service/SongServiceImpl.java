package com.project.song.service;

import com.project.song.model.Songs;
import com.project.song.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService
{
    @Autowired
    private SongRepository songRepository;

    @Override
    public Songs saveSong(Songs songs) {
        return songRepository.save(songs);
    }

    @Override
    public List<Songs> getAllSong() {
        return (List<Songs>) songRepository.findAll();
    }

    @Override
    public Songs updateSong(Songs songs, String songId) {
        if (songRepository.findById(songId).isEmpty())
        {
            return null;
        }
        else
        {
            return songRepository.save(songs);
        }
    }

    @Override
    public boolean deleteSong(String songId) {
        songRepository.deleteById(songId);
        return true;
    }
}
