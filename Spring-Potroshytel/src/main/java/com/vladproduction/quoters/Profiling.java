package com.vladproduction.quoters;

public @interface Profiling {

    //for all classes annotating @Profiling - logging time of work this class methods;
    //for this operation we have to generate class on that moment time - on flying;
    //1) variant: "dynamic proxy": implementing same interfaces;
    //2) variant: "sglib": extends from origin class and override methods with some additional logic;
}
