package com.vladproduction.javaConfig.repository;


import com.vladproduction.javaConfig.model.Speaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Repository("speakerRepository")
@Profile("dev")
public class SpeakerRepositoryImpl implements SpeakerRepository {

    @Autowired
    @Qualifier("calendar")
    private Calendar calendar;

    @Value("#{T(Math).random()*100}")
    private double seedNum;


    @Override
    public List<Speaker> findAll(){
        List<Speaker> speakers = new ArrayList<>();

        Speaker speaker = new Speaker();
        speaker.setFirstName("John");
        speaker.setSecondName("Dow");
        speaker.setSeedNum(seedNum);

        System.out.println("calendar: " + calendar.getTime());

        speakers.add(speaker);
        return speakers;
    }
}
