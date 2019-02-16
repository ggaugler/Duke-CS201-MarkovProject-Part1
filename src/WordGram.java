import java.util.Arrays;

/**
 * A WordGram represents a sequence of strings
 * just as a String represents a sequence of characters
 * 
 * @author Geoff Gaugler
 *
 */
public class WordGram {
	
	private String[] myWords;   
	private String myToString;  // cached string
	private int myHash;         // cached hash value

	/**
	 * Create WordGram (add comments)
	 * @param source
	 * @param start
	 * @param size
	 */
	public WordGram(String[] source, int start, int size) {
		myWords = new String[size];
		for (int i = 0; i < size; i++)
		{
			myWords[i] = source[start + i];
		}
		myToString = null;
		myHash = 0;
	}

	/**
	 * Return string at specific index in this WordGram
	 * @param index in range [0..length() ) for string 
	 * @return string at index
	 */
	public String wordAt(int index) {
		if (index < 0 || index >= myWords.length) {
			throw new IndexOutOfBoundsException("bad index in wordAt "+index);
		}
		return myWords[index];
	}

	/**
	 *
	 * @return the number of words in the instance variable myWords
	 */
	public int length()
	{
		return myWords.length;
	}

	@Override
	public boolean equals(Object o) {
		if (! (o instanceof WordGram) || o == null){
			return false;
		}
		WordGram wg = (WordGram) o;
		if (!Arrays.equals(this.myWords, wg.myWords))
		{
			return false;
		}
		return true;
	}

	@Override
	public int hashCode()
	{
		if(myHash == 0)
			myHash = this.toString().hashCode();
		return myHash;
	}
	

	/**
	 * Create and complete this comment
	 * @param last is last String of returned WordGram
	 * @return a new WordGram object with k entries where k is the order of this WordGram
	 * whose first k-1 entries are the same as the last k-1 entries of this WordGram and whose
	 * last entry is the parameter last.
	 */
	public WordGram shiftAdd(String last) {
		WordGram wg = new WordGram(myWords,0,myWords.length);
		for (int i = 1; i < myWords.length; i++)
		{
			wg.myWords[i-1] = this.myWords[i];
		}
		wg.myWords[wg.length() - 1] = last;
		return wg;
	}

	@Override
	public String toString()
	{
		if(myToString == null)
			myToString = String.join(" ", myWords);
		return myToString;
	}
}
