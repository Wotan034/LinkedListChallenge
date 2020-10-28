package com.company;

import java.util.ArrayList;


public class Album { //album class with an arraylist to hold the songs each album has

    private String name;
    private ArrayList<Song> songList;

    public Album(String name, String songName, int songDuration) {
        this.name = name;
        this.songList = new ArrayList<Song>();
        addSong(songName, songDuration);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Song> getSongList() {
        return songList;
    }

    public boolean addSong(String songName, int duration) { //method for adding songs
        if (findSong(songName) == null) {
            this.songList.add(new Song(songName, duration));
            return true;
        }
        return false;
    }


    public Song findSong(String song) { //method for finding songs comparing song title in the list to song title you are checking
        for (Song checked : songList) {
            if (checked.getTitle().equals(song)) {
                return checked;
            }
        }
        return null;
    }


}
