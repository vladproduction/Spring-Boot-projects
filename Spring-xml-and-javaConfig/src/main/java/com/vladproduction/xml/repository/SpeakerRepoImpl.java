package com.vladproduction.xml.repository;



import com.vladproduction.xml.model.Speaker;

import java.util.ArrayList;
import java.util.List;

public class SpeakerRepoImpl implements SpeakerRepo {

    @Override
    public List<Speaker> findAll(){
        List<Speaker> speakers = new ArrayList<Speaker>();

        Speaker speaker = new Speaker();
        speaker.setFirstName("John");
        speaker.setSecondName("Dow");

        speakers.add(speaker);
        return speakers;
    }
}
