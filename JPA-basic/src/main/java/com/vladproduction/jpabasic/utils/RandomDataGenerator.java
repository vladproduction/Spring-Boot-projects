package com.vladproduction.jpabasic.utils;

import java.util.Random;

/**
 * Created by vladproduction on 13-Apr-24
 */

public class RandomDataGenerator {

    public static String uniqueEmail(String baseEmailName, String baseEmailExtend){
        int randomSuffix = new Random().nextInt(99999) +1 ;
        return baseEmailName + randomSuffix + baseEmailExtend;
    }

    public static String uniqueContactPhone(String base){
        StringBuilder sb = new StringBuilder();
        sb.append("+38(").append(base).append(")");
        sb.append(new Random().nextInt(100, 999)).append("-");
        sb.append(new Random().nextInt(10, 99)).append("-");
        sb.append(new Random().nextInt(10, 99));
        return sb.toString();
    }

}
