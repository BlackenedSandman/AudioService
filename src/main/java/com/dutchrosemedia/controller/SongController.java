/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dutchrosemedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dutchrosemedia.service.SongService;
import java.io.IOException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Blackened
 */
@RestController
@RequestMapping("songs")
public class SongController {
    
    @Autowired
    SongService audioService;
    
    @RequestMapping("/stopAll")
    public void stopAll(){
        this.audioService.stopAll();
    }
    
    @RequestMapping("/play")
    public void playSong(String song) throws UnsupportedAudioFileException, IOException{
        this.audioService.playSong(song);
    }
    
    @RequestMapping("/stop")
    public void stopSong(String song){
        this.audioService.stopSong(song);
    }
    
}
