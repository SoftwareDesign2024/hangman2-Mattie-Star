// Matilda 
package game;

import util.ConsoleReader;
import util.HangmanDictionary;

/**
 * This class represents the traditional word-guessing game Hangman
 * that plays interactively with the user.
 *
 * @author Robert C. Duvall
 * @author Shannon Duvall
 */
public class HangmanGame {
	
    // Fields for HangmanGame
    protected Executioner myExecutioner;
    protected Guesser myGuesser;

    /**
     * Create Hangman game with the given dictionary of words to play a game with words 
     * of the given length and giving the user the given number of chances.
     */
    public HangmanGame(HangmanDictionary dictionary, int wordLength, int numGuesses, String userChoice) {
    	if(userChoice.equals("O")) {
        	myExecutioner = new Executioner(dictionary, wordLength);
        	myGuesser = new Guesser(myExecutioner, numGuesses);
        			
    	}if (userChoice.equals("C")) {
    		myExecutioner = new CheatingComputerExecutioner(dictionary, wordLength);
    		myGuesser = new CheatingComputerGuesser(myExecutioner, numGuesses, dictionary.getWords(wordLength));
    	
    	}if (userChoice.equals("A")) {
    		myExecutioner = new AutoGuesserExecutioner(dictionary, wordLength); 
    		myGuesser = new Guesser(myExecutioner, numGuesses);
    	}
    }

    /**
     * Play one complete game.
     */
    public void play () {
        boolean gameOver = false;
        while (!gameOver) {
            printStatus();

            String guess = ConsoleReader.promptString("Make a guess: ");
            if (guess.length() == 1 && Character.isAlphabetic(guess.charAt(0))) {
            	myGuesser.makeGuess(guess.toLowerCase().charAt(0));
                gameOver = isGameOver(gameOver);
            }
            else {
                System.out.println("Please enter a single letter ...");
            }
        }
        myExecutioner.printSecretWordMessage();
    }

    // Prints the game statistics. 
    protected void printStatus () {
        myExecutioner.printDisplayWord();
        myGuesser.printGuessesLeftMessage();
        myGuesser.PrintLettersLeftToGuessMessage();
        // NOT PUBLIC, but makes it easier to test
        //System.out.println("*** " + mySecretWord);
        System.out.println();
    }
    
    // Returns true if the game is over. 
    protected boolean isGameOver(boolean gameOver) {
    	if (myGuesser.isGameLost()) {
            System.out.println("YOU ARE HUNG!!!");
            gameOver = true;
        }
        else if (myExecutioner.isGameWon()) {
            System.out.println("YOU WIN!!!");
            gameOver = true;
        }
    	return gameOver;
    }
}
