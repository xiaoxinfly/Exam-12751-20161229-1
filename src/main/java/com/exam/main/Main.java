package com.exam.main;

public class Main {

    public static void main(String[] args) {
        App app = AppFactory.createApp();
        app.start();
        app.addFilm();
        app.close();
    }
}
