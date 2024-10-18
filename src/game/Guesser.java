// Matilda 
package game;

// The Guesser class processes a guess made by the user. 
public class Guesser {
	
	// Constants for Guesser
    private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

	// Tracks letters guessed.
	protected StringBuilder myLettersLeftToGuess;
	// How many guesses are remaining.
    protected int myNumGuessesLeft;
    // Executioner object.
    private Executioner executioner;
    
    // Creates a Guesser.
    public Guesser (Executioner exicutioner, int numGuesses) {
    	myLettersLeftToGuess = new StringBuilder(ALPHABET);
    	this.executioner = exicutioner;
    	myNumGuessesLeft = numGuesses;
    }
    
	// Process a guess by updating the necessary internal state.
    public void makeGuess (char guess) {
        // Does not count repeated guesses as a miss.
        int index = myLettersLeftToGuess.indexOf("" + guess);
        if (index >= 0) {
            recordGuess(index);
            if (!executioner.checkGuessInSecret(guess)) {
                myNumGuessesLeft -= 1;
            }
        }
    }
    
    // Record that a specific letter was guessed.
    private void recordGuess (int index) {
        myLettersLeftToGuess.deleteCharAt(index);
    }
    
    // Returns true if the guesser has used up all their chances to guess.
    public boolean isGameLost() {
        return myNumGuessesLeft == 0;
    }
    
    // Prints the number of guesses left.
    public void printGuessesLeftMessage() {
    	System.out.println(myNumGuessesLeft + " misses left.");
    }
    
    // Prints the letter left to guess.
    public void PrintLettersLeftToGuessMessage() {
    	System.out.println("letters not yet guessed = " + myLettersLeftToGuess);
    }
}
