/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dutchrosemedia.controller;

import com.dutchrosemedia.service.VoiceService;
import java.io.IOException;
import javax.sound.sampled.UnsupportedAudioFileException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Blackened
 */
@RestController
@RequestMapping("voice")
public class VoiceController {
    
    @Autowired
    VoiceService pianoService;
    
    
    @RequestMapping("/stopAll")
    public void stopAll(){
        this.pianoService.stopAll();
    }
    
    @RequestMapping("/play")
    public void playNote(String voice) throws UnsupportedAudioFileException, IOException{
        this.pianoService.playVoice(voice);
    }
    
    @RequestMapping("/stop")
    public void stopNote(String voice){
        this.pianoService.stopVoice(voice);
    }
    
}
