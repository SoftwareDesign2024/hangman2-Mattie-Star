// Matilda
package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import util.DisplayWord;

// The CheatingComputerGuesser process a guess made by the user prompting the change of the word being guess to ensure the user losses.
public class CheatingComputerGuesser extends Guesser{
	
	// Fields for CheatingComputerGuesser.
    private List<String> myRemainingWords;
    private CheatingComputerExecutioner myExecutioner;
    
 
    // Constructs a CheatingComputerGuesser. 
	public CheatingComputerGuesser(Executioner executioner, int numGuesses, List<String> myRemainingWords) {
		super(executioner, numGuesses);
		this.myRemainingWords = myRemainingWords;
		myExecutioner = (CheatingComputerExecutioner) executioner;
	}

	// Process a guess by updating the necessary internal state.
    public void makeGuess (char guess) {
    	cheat(guess);
    	super.makeGuess(guess);
    }
    
    // Prompts the corresponding Executioner to change the word being guessed when a letter in it has been guessed. 
    public void cheat(char guess) {
        // create template of guesses and find one with most matching remaining words
        HashMap<DisplayWord, List<String>> templatedWords = new HashMap<DisplayWord, List<String>>();
        for (String w : myRemainingWords) {
            DisplayWord template = new DisplayWord(myExecutioner.getDisplayWord());
            template.update(guess, w);
            if (!templatedWords.containsKey(template)) {
                templatedWords.put(template, new ArrayList<>());
            }
            templatedWords.get(template).add(w);
        }
        int max = 0;
        DisplayWord maxKey = new DisplayWord("");
        for (Entry<DisplayWord, List<String>> entry : templatedWords.entrySet()) {
            //System.out.println(entry.getValue());
            if (entry.getValue().size() > max) {
                max = entry.getValue().size();
                maxKey = entry.getKey();
            }
        }

        // update secret word to match template of guesses
        myRemainingWords = templatedWords.get(maxKey);
        Collections.shuffle(myRemainingWords);
        myExecutioner.setSecretWord(myRemainingWords.get(0));
        myExecutioner.setDisplayWord(maxKey);
    }
}
