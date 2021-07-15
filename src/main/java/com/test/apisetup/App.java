package com.test.apisetup;

import java.util.Arrays;
import java.util.List;


/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        int starsRecieved = 166000;
        int baseLimit = 1000;
        if (starsRecieved >= baseLimit) {
            starsRecieved = Math.round(starsRecieved / baseLimit);
        }
        System.out.println(starsRecieved);
    }

}