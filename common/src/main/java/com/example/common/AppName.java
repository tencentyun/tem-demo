package com.example.common;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class AppName {
    public static String name(String appName) {
        String hostname = null;
        try {
            hostname = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return "pong from " + appName + "(" + hostname + ")";
    }
}