package com.vladproduction.xml.service;



import com.vladproduction.xml.model.Speaker;
import com.vladproduction.xml.repository.SpeakerRepo;

import java.util.List;

public class SpeakerServiceImpl implements SpeakerService {

    private SpeakerRepo repository;

    public SpeakerServiceImpl() {
    }

    public SpeakerServiceImpl(SpeakerRepo repository) {
        this.repository = repository;
    }

    @Override
    public List<Speaker> findAll(){
        return  repository.findAll();
    }

    public void setRepository(SpeakerRepo repository) {
        this.repository = repository;
    }
}
