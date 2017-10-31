/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dutchrosemedia.controller;

import com.dutchrosemedia.Main;
import com.dutchrosemedia.service.PianoService;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.UnsupportedAudioFileException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Blackened
 */
@RestController
@RequestMapping("piano")
public class PianoController {
    
    @Autowired
    PianoService pianoService;
    
    
    @RequestMapping("/stopAll")
    public void stopAll(){
        this.pianoService.stopAll();
    }
    
    @RequestMapping("/play")
    public void playNote(String note) throws UnsupportedAudioFileException, IOException{
        this.pianoService.playNote(note);
    }
    
    @RequestMapping("/stop")
    public void stopNote(String note){
        this.pianoService.stopNote(note);
    }
    
}
