// Matilda 
package game;

import util.DisplayWord;
import util.HangmanDictionary;

// The Executioner class checks if a guess is right. 
public class Executioner {
	
	// Word that is being guessed.
    protected String mySecretWord;
    // What is shown to the user.
    protected DisplayWord myDisplayWord;
    
    // Constructor for Executioner. 
    public Executioner (HangmanDictionary dictionary, int wordLength) {
    	mySecretWord = makeSecretWord(dictionary, wordLength);
    	myDisplayWord = new DisplayWord(mySecretWord);
    }

    // Returns a secret word.
    private String makeSecretWord (HangmanDictionary dictionary, int wordLength) {
        return dictionary.getRandomWord(wordLength).toLowerCase();
    }
    
    // Returns true if given guess is in the secret word.
    public boolean checkGuessInSecret (char guess) {
        if (mySecretWord.indexOf(guess) >= 0) {
            myDisplayWord.update(guess, mySecretWord);
            return true;
        }
        return false;
    }

    // Returns true only if the guesser has guessed all letters in the secret word.
    public boolean isGameWon() {
        return myDisplayWord.equals(mySecretWord);
    }
    
    
    // Prints the secret word. 
    public void printSecretWordMessage() {
    	System.out.println("The secret word was " + mySecretWord);
    }
    
    // Prints the display word .
    public void printDisplayWord() {
    	System.out.println(myDisplayWord);
    }
}
