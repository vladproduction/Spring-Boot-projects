package com.vladproduction.javaConfig.repository;



import com.vladproduction.javaConfig.model.Speaker;

import java.util.List;

public interface SpeakerRepository {
    List<Speaker> findAll();
}
