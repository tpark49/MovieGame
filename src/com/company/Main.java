package com.company;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Main {

    public static void main(String[] args) {
        //load the text file
        File file = new File("src\\MovieList.txt");
        try{
            Scanner scanner = new Scanner(file);

            //figure out how many movies there are
            int numberOfMovies = 0;
            while (scanner.hasNextLine()){
                numberOfMovies++;
                scanner.nextLine();
            }

            int randomInt = (int) Math.ceil(Math.random()*numberOfMovies);

            //pick out a random movie
            Scanner newScanner = new Scanner(file);
            String randomMovie = "xyz";
            while (randomInt>0){
                randomMovie = newScanner.nextLine();
                randomInt --;
            }

            Scanner input = new Scanner(System.in);
            //10 for loops for the game
            String myGuess = "";
            String Sub = "-";
            String Space = " ";
            Boolean hasWon = false;
            for(int h=0;h<randomMovie.length();h++) {
                if (randomMovie.indexOf(" ") == h) {
                    myGuess += " ";
                } else {
                    myGuess += "-";
                }
            }
            for(int i=10; i>0; i--){
                System.out.print("You have "+i+" guess(es) remaining\n");
                System.out.print(myGuess + "\n");
                System.out.print("Your Guess: ");
                String Guess = input.nextLine();



                String temp = "";

                for (int j=0; j<randomMovie.length();j++){
                    if (randomMovie.charAt(j) == Guess.charAt(0)){
                        temp += Guess.charAt(0);
                    }
                    else if (randomMovie.charAt(j) == Space.charAt(0)){
                        temp += " ";
                    }
                    else if (myGuess.charAt(j) != Sub.charAt(0)){
                        temp += myGuess.charAt(j);
                    }
                    else{
                        temp += "-";
                    }
                }

                myGuess = temp;

                if (myGuess == randomMovie){
                    hasWon = true;
                    System.out.print("You've guessed it!");
                    break;
                }else{
                    System.out.print(myGuess);
                }

            }
            if (myGuess == randomMovie){
                System.out.print("You've guessed it");
            }else{
                System.out.print("GameOver");
                System.out.print("Correct answer was "+ randomMovie + "." + "\n");
            }


        }catch(FileNotFoundException exception){
            System.out.print("File Not Found");
        }

    }
}
