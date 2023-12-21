package com.vladproduction.declaratively.aspects;

import com.vladproduction.declaratively.flyer.Flyer;
import com.vladproduction.declaratively.flyer.FlyerImpl;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class FlightAspect {

    @DeclareParents(value="com.vladproduction.declaratively.management.Flight", defaultImpl= FlyerImpl.class)

    private Flyer flyer;

    public FlightAspect() {
    }
}
