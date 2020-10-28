package com.company;

public class Song {  // song class with title and duration

    private String title;
    private int duration;

    public Song(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() { //basic to string method
        return this.title + ": " + this.duration;
    }
}
