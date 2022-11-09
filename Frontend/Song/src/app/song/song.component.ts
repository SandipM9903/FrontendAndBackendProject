import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { SongService } from '../song.service';

@Component({
  selector: 'app-song',
  templateUrl: './song.component.html',
  styleUrls: ['./song.component.css']
})
export class SongComponent implements OnInit {

  editMode:boolean = false;
  currentSongId: string | undefined;
  constructor(private songService: SongService) { }

  ngOnInit(): void {
    this.getALlSongs();
  }

  songData:any;

  getALlSongs()
  {
    this.songService.getAllSong().subscribe(
      response=>{
        this.songData=response;
      }
    )
  }

  songForm = new FormGroup({
    "songId" : new FormControl(''),
    "songName" : new FormControl(''),
    "singerName" : new FormControl(''),
    "songType" : new FormControl('')
  });

  saveData()
  {
    if(!this.editMode)
    {
      this.songService.addSong(this.songForm.value).subscribe(
        response =>{
          alert("Song is added");
          this.getALlSongs();
        }
      )
    }
    else if(this.editMode)
    {
      this.songService.updateSong(this.currentSongId, this.songForm.value).subscribe(
        response =>{
          alert("Song is edited");
          this.getALlSongs();
        }
      )
    }
    else
    {
      this.songService.addSong(this.songForm.value).subscribe(
        response =>{
          alert("Song is added");
          this.getALlSongs();
        }
      )
    }
  }

  deleteSong(songId:string)
  {
    this.songService.deleteSong(songId).subscribe(
      response=>{
        alert("Song is deleted");
        this.getALlSongs();
      }
    )
  }

  editSong(songId:string,songName:string, singerName:string, songType:string)
  {
    this.currentSongId = songId;
    this.songForm.setValue({
      songId: songId,
      songName: songName,
      singerName: singerName,
      songType: songType
    });
    this.editMode = true;
  }
}
