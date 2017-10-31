/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dutchrosemedia.service;

import com.dutchrosemedia.Main;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import org.springframework.stereotype.Service;

/**
 *
 * @author Blackened
 */
@Service
public class PianoServiceImpl implements PianoService {
    
    private static final String RESOURCE_PATH = "/Piano/";
    
    private final HashMap<String, Clip> currentlyPlaying;

    public PianoServiceImpl() {
        this.currentlyPlaying = new HashMap<>();
    }

    
    @Override
    public void stopAll() {
        List<String> noteNames = this.currentlyPlaying.entrySet()
                .stream()
                .map(x -> x.getKey())
                .collect(Collectors.toList());
        noteNames.forEach(x -> this.stopNote(x));
    }

    public static AudioInputStream loadAudioStream(String name) throws UnsupportedAudioFileException, IOException {
        File soundFile = new File(Main.RESOURCE_PATH + RESOURCE_PATH + name + ".wav");
        if (!soundFile.exists()) {
            System.out.println("File does not exist!");
        }
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);

        return audioIn;
    }

    @Override
    public void playNote(String note) throws UnsupportedAudioFileException, IOException {
        if (this.currentlyPlaying.containsKey(note)) {
            return;
        }
        //System.out.println("Playing: " + note);

        AudioInputStream ais = loadAudioStream(note);

        try {
            Clip clip = AudioSystem.getClip();
            clip.addLineListener(x -> {
                if (x.getType() == LineEvent.Type.STOP) {
                    this.currentlyPlaying.remove(note);
                }
            });
            clip.open(ais);
            clip.start();
            this.currentlyPlaying.put(note, clip);

        } catch (LineUnavailableException ex) {
            Logger.getLogger(SongServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void stopNote(String note) {
        if (!this.currentlyPlaying.containsKey(note)) {
            return;
        }

        this.currentlyPlaying.get(note).stop();
    }

}
