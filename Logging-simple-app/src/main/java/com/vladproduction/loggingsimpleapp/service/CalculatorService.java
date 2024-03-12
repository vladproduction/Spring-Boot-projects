package com.vladproduction.loggingsimpleapp.service;

import com.vladproduction.loggingsimpleapp.model.Item;
import org.springframework.stereotype.Service;

/**
 * Created by vladproduction on 12-Mar-24
 */

@Service
public class CalculatorService {

    public int calculate(Item item){
        switch (item.getActionType()){
            case PLUS : return item.getA() + item.getB();
            case MINUS: return item.getA() - item.getB();
            default: throw new IllegalArgumentException("no operation");
        }
    }

}
