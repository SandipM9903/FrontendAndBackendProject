package com.project.song.controller;

import com.project.song.model.Songs;
import com.project.song.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/")
public class SongController
{
    @Autowired
    private SongService songService;

    //http://localhost:8085/api/v1/add-song
    @PostMapping("add-song")
    public ResponseEntity<?> addSong(@RequestBody Songs songs)
    {
        return new ResponseEntity<>(songService.saveSong(songs), HttpStatus.CREATED);
    }

    //http://localhost:8085/api/v1/get-all-song
    @GetMapping("get-all-song")
    public ResponseEntity<?> getAllSongs()
    {
        return new ResponseEntity<>(songService.getAllSong(), HttpStatus.OK);
    }

    //http://localhost:8085/api/v1/song/{songId}
    @PutMapping("song/{songId}")
    public ResponseEntity<?> updateSong(@RequestBody Songs songs, @PathVariable("songId") String songId)
    {
        return new ResponseEntity<>(songService.updateSong(songs, songId), HttpStatus.OK);
    }

    //http://localhost:8085/api/v1/song/{songId}
    @DeleteMapping("song/{songId}")
    public ResponseEntity<?> deleteSong(@PathVariable("songId") String songId)
    {
        return new ResponseEntity<>(songService.deleteSong(songId), HttpStatus.OK);
    }
}
