package hangman;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    private final List<String> words = List.of("car", "cat", "ball", "computer", "hangman", "building", "card", "desk", "monitor");
    private final int maximumWrongAnswers = 5;
    private String wordToGuess;
    private char[] userWord;
    private int wrongAnswers = 0;

    public void play() {
        System.out.println("Start of the game");
        HangmanStates hangmanStates = new HangmanStates();

        generateRandomWord();
        userWord = new char[wordToGuess.length()];
        Arrays.fill(userWord, '_');

        while (!gameEnded()) {
            System.out.println("\nWrong answers: " + wrongAnswers);
//            displayDrawing();
            System.out.print(hangmanStates.getHangmanStates(wrongAnswers));
            displayUserWord();
            if (!guessLetter()) {
                wrongAnswers++;
            }
        }

        System.out.print("\n" + hangmanStates.getHangmanStates(wrongAnswers));
        displayUserWord();
        System.out.println();
        if (wrongAnswers <= maximumWrongAnswers) {
            System.out.println("\nCongratulations!\nYou won the game!\n");
//            System.out.println("Wrong answers: " + wrongAnswers);
        }
        else {
            System.out.println("\nYou lost the game");
            System.out.println("The word was: " + wordToGuess);
        }
    }

    private void generateRandomWord() {
        Random rand = new Random();
        wordToGuess = words.get(rand.nextInt(words.size()));
    }

    private void displayUserWord() {
        System.out.print(" ");
        for (char letter : userWord) {
            System.out.print(letter);
        }
        System.out.print(" ");
    }

    private boolean gameEnded() {
        if (wrongAnswers > maximumWrongAnswers) {
            return true;
        }

        for (int i = 0; i < wordToGuess.length(); i++) {
            if (userWord[i] != wordToGuess.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    private boolean guessLetter() {
        boolean letterInWord = false;
        Scanner scanner = new Scanner(System.in);
        try {
            char userLetter = scanner.next().charAt(0);

            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == userLetter) {
                    letterInWord = true;
                    userWord[i] = userLetter;
                }
            }
        } catch (Exception e) {
            System.out.println("Something went wrong");
        }

        return letterInWord;
    }

//    First version of code to display drawing of hangman from file
//
//    private void displayDrawing() {
//        System.out.println("Displaying drawing");
//        try {
//            URL resource = Hangman.class.getResource("image.txt");
//            File myFile = Paths.get(resource.toURI()).toFile();
//            Scanner reader = new Scanner(myFile);
//
//            while (reader.hasNextLine()) {
//                System.out.println(reader.nextLine());
//            }
//            reader.close();
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (URISyntaxException e) {
//            throw new RuntimeException(e);
//        } catch (NullPointerException e) {
//            System.out.println("Something went wrong");
//        }
//    }
}
