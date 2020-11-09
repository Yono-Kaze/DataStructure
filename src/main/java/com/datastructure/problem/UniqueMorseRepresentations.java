package com.datastructure.problem;

import java.util.TreeSet;

/**
 * 
 *<p>Description:804. Unique Morse Code Words<p>
 *International Morse Code defines a standard encoding where each letter is mapped to a series of dots and dashes, 
 *as follows: "a" maps to ".-", "b" maps to "-...", "c" maps to "-.-.", and so on.
 *For convenience, the full table for the 26 letters of the English alphabet is given below:
 *[".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 *Now, given a list of words, each word can be written as a concatenation of the Morse code of each letter. For example, "cab" can be written as "-.-..--...",
 * (which is the concatenation "-.-." + ".-" + "-..."). We'll call such a concatenation, the transformation of a word.
 *Return the number of different transformations among all words we have.	
 * @author Administrator
 * @version 2020-11-9
 *
 */
public class UniqueMorseRepresentations {

	public int uniqueMorseRepresentations(String[] words) {

		String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....",
				"..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-."
				,"...","-","..-","...-",".--","-..-","-.--","--.."};
		
		TreeSet<String> set = new TreeSet<String>();
		for (String word : words) {
			StringBuilder res = new StringBuilder();
			
			for (int i = 0; i < word.length(); i++) {
				res.append(codes[word.charAt(i) - 'a']);
			}
			set.add(res.toString());
		}
		
		return set.size();
	}

}
