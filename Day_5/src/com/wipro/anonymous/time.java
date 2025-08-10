package com.wipro.anonymous;

import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.util.function.Consumer;

public class time {
    public static void main(String[] args) {
        Consumer<String> tm = zone -> 
            System.out.println("Time in " + zone + " : " + ZonedDateTime.now(ZoneId.of(zone)));

        tm.accept("Europe/London"); // calling the lambda
    }
}