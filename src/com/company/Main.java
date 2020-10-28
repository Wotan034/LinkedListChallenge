package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        ArrayList<Album> albums = new ArrayList<Album>(); //Array list of albums
        Album backToBlack = new Album("Back to Black", "Rehab", 5); //creating two albums
        Album frank = new Album("Frank", "Intro", 5);
        albums.add(backToBlack); //adding albums to the album Arraylist
        albums.add(frank);
        backToBlack.addSong("You know I'm no good", 5);// adding songs to the album
        backToBlack.addSong("Me and Mr. Jones", 5);
        backToBlack.addSong("Just Friends", 5);
        backToBlack.addSong("Back to Black", 5);
        backToBlack.addSong("Life is a losing game", 5);
        backToBlack.addSong("Tears Dry on their own", 5);
        backToBlack.addSong("Wake up alone", 5);
        backToBlack.addSong("Some unholy war", 5);
        backToBlack.addSong("He can only hold her", 5);
        backToBlack.addSong("Addicted", 5);
        frank.addSong("You sent me flying", 5);
        frank.addSong("Know you now", 5);
        frank.addSong("Fuck me pumps", 5);
        frank.addSong("I heard love is blind", 5);
        frank.addSong("Moody's Mood", 5);
        frank.addSong("No Greater Love", 5);
        frank.addSong("In my bed", 5);
        frank.addSong("Take the box", 5);
        frank.addSong("October song", 5);
        frank.addSong("What is it about men", 5);
        frank.addSong("Amy Amy Amy", 5);


        LinkedList<Song> playlist = new LinkedList<Song>(); //initializing playlist
        addSongToPlaylist(playlist, "In my bed", albums); // adding songs to playlist using addSongToPlaylist method
        addSongToPlaylist(playlist, "Addicted", albums);
        addSongToPlaylist(playlist, "October song", albums);
        addSongToPlaylist(playlist, "Life is a losing game", albums);
        addSongToPlaylist(playlist, "Know you now", albums);
        addSongToPlaylist(playlist, "Take the box", albums);
        addSongToPlaylist(playlist, "In my bod", albums);

        play(playlist);


    }

    private static boolean addSongToPlaylist(LinkedList<Song> playlist, String songName, ArrayList<Album> albums) { //checks to see if song exists in albums list. If I own the song it is added to the playlist.
        for (Album checked : albums) {
            if (checked.findSong(songName) != null) {
                Song song = checked.findSong(songName);
                playlist.add(song);
                return true;
            }
        }
        System.out.println("You do not have the song, " + songName + ", and it could not be added to the list"); // tells user if the song does not exist in their collection.
        return false;
    }

    private static void printMenu() { // prints options for user
        System.out.println("Available actions:\npress ");
        System.out.println("0 - to quit\n" +
                "1 - go to next song\n" +
                "2 - go to previous song\n" +
                "3 - Repeat current song\n" +
                "4 - List songs in playlist\n" +
                "5 - Remove song");
    }

    private static void play(LinkedList playlist) { //iterates through playlist allowing options above.
        Scanner scanner = new Scanner(System.in); //initializing scanner
        boolean quit = false; // to exit loop
        boolean goingForward = true; // for repeat action to know is next or previous is needed
        ListIterator<Song> listIterator = playlist.listIterator();

        if (playlist.isEmpty()) { //check to see if playlist has songs added.
            System.out.println("There are no songs on your playlist");
            return;
        } else {
            System.out.println("Now playing " + listIterator.next().toString()); // plays first song
            printMenu();
        }

        while (!quit) { //while loop allowing continuous input until the user is done "listening" to music.
            int action = scanner.nextInt();
            switch (action) {
                case 0:
                    System.out.println("Quitting song player");
                    quit = true;
                    break;
                case 1:
                    if (!goingForward) { // if list has next print out current song and move to next song in the list.
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("Reached the end of the playlist");
                        goingForward = false;
                    }
                    break;

                case 2:
                    if (goingForward) { // if list has previous, move to previous and print song.
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("Reached the beginning of the playlist");
                        goingForward = true;
                    }
                    break;

                case 3:
                    if (goingForward) { //repeat song, if moving forward must use previous to print same song and set boolean goingForward to false.
                        System.out.println("Now playing " + listIterator.previous().toString());
                        goingForward = false;
                    } else { // repeat song, if moving back must use next to repeat song. set boolean goingForward to true.
                        System.out.println("Now playing " + listIterator.next().toString());
                        goingForward = true;
                    }
                    break;

                case 4:
                    printPlayList(playlist); //print current songs in list
                    break;

                case 5:
                    listIterator.remove(); //remove the current song playing from the list
                    System.out.println("Song has been removed");
                    if(listIterator.hasNext()) {
                        System.out.println("Now playing " + listIterator.next());
                    } else if (listIterator.hasPrevious()) {
                        System.out.println("Now playing " + listIterator.previous());
                    }
                    break;

            }
        }


    }

    private static void printPlayList(LinkedList<Song> playlist) { //iterates over each song and prints title and duration for the user
        Iterator<Song> i = playlist.iterator();
        int j = 0;
        while (i.hasNext()) {
            System.out.println("Track " + (j + 1) + ": " + i.next().toString());
            j++;
        }
    }
}
