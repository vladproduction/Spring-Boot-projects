package com.vladproduction.xml.repository;

import com.vladproduction.xml.model.Speaker;

import java.util.List;

public interface SpeakerRepo {
    List<Speaker> findAll();
}
