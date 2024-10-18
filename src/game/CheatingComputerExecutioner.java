// Matilda
package game;

import util.DisplayWord;
import util.HangmanDictionary;

// The CheatingComputerExecutioner changes the secret word to ensure the user losses. 
public class CheatingComputerExecutioner extends Executioner{
	
	// Constructs a CheatingComputerExecutioner.
	public CheatingComputerExecutioner(HangmanDictionary dictionary, int wordLength) {
		super(dictionary, wordLength);
	}
	
	
	// Changes the myDisplayWord field with the provided DisplayWord.
    public void setDisplayWord(DisplayWord newDisplayWord) {
    	this.myDisplayWord = newDisplayWord;
    }
    
    
    // Changes the mySecretWord field with the provided String.
    public void setSecretWord(String newSecretWord) {
    	this.mySecretWord = newSecretWord;
    }
    

	// Returns the myDisplayWord field for printing.
    public DisplayWord getDisplayWord() {
    	return myDisplayWord;
    }
}
