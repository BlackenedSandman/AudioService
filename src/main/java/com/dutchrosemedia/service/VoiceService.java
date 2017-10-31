/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dutchrosemedia.service;

import java.io.IOException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Blackened
 */
public interface VoiceService {
    
    public void stopAll();
    
    public void playVoice(String voice) throws UnsupportedAudioFileException, IOException;
    
    public void stopVoice(String voice);
    
}
