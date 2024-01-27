package com.vladproduction.execution;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;



public interface ArithmeticOperation {

    int execute(int a, int b);
}
