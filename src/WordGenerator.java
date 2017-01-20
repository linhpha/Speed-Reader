import java.util.Scanner;
import java.io.File;
import java.io.IOException;


public class WordGenerator {
	public Scanner text;
	public int wordCount;
	public int sentenceCount;	
	
	/**
	 * @param filename
	 * @return constructs a new generator that processes text from the given file
	 */
	public WordGenerator(String filename) throws IOException {
		this.text = new Scanner(new File(filename));
		this.wordCount = 0;
		this.sentenceCount = 0;
	}

	/**
	 * @return boolean value whether the scanner has words to proceed or not
	 */
	public boolean hasNext(){
		if(this.text.hasNext()) {
			return true;
		} else {
			return false;
		}
	}

	/** 
	 * @return the next word of the underlying Scanner
	 */
	public String next() {
		String nextWord = this.text.next();
		this.wordCount ++;
		char lastChar = nextWord.charAt(nextWord.length() - 1);
		if(lastChar == '.' || lastChar == '!' || lastChar == '?') {
			this.sentenceCount ++;
		}
		return nextWord;
	}
	
	/**
	 * @return the number of words of the file
	 */
	public int getWordCount() {
		return this.wordCount;
	}
	
	/**
	 * @return the number of sentences of the file
	 */
	public int getSentenceCount() {		
			return this.sentenceCount;
	}
}

	
