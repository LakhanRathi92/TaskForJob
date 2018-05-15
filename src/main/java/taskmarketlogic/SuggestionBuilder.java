package taskmarketlogic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class SuggestionBuilder {

private static final class Suggestion {
        private final String text;

        public Suggestion(String text) {

            this.text = text;

        }

        public String toString() {

            return text;

        }
		//Auto generated from eclipse
	    @Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((text == null) ? 0 : text.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Suggestion other = (Suggestion) obj;
			if (text == null) {
				if (other.text != null)
					return false;
			} else if (!text.equals(other.text))
				return false;
			return true;
		}

    }

    /** The maximum amount of words which can be combined to a suggestion */

    private final static int MAX_COMBINED_TOKENS = 3;

    private static final String[] TOKENS  =  {"The", "beautiful", "girl", "from", "the", "farmers", "market", ".", "I", "like", "chewing", "gum", "." };

    private static final String[] STOP_WORDS = {"is", "can", "the"};

    private static Set<Suggestion> buildSuggestionsFromTokenFromString(Iterator<String> tokens, Set<String> stopWords) {
        // Implementation comes here
		// Please don't change the signature of this method
		
		//Assumptions:
		//Stop words are always in lower case letters
		
		Set<Suggestion> reply = new HashSet<>();
    	LinkedList<String> tempLinkedList = new LinkedList<String>();
    	int counter = 0;
    	while(tokens.hasNext()){
    		String tempWord = tokens.next().toLowerCase();
    		if((!stopWords.contains(tempWord)) && (tempWord.length() > 1)){ 
        		counter++;
    			tempLinkedList.add(tempWord);
        		if(tempLinkedList.size() > 0 && counter == MAX_COMBINED_TOKENS){
    				LinkedList<String> tempLl = new LinkedList<>(tempLinkedList);
    				Set<Suggestion> suggestionsCompiled = createSuggestions(tempLl, tempLl.size());
    				reply.addAll(suggestionsCompiled);
    			    tempLinkedList.removeFirst();
    				counter -=1;
    			}
    		} else { //stop word found, process whatever you have and reset the data structures.
    			LinkedList<String> tempLl = new LinkedList<>(tempLinkedList);    			
    			if(tempLl.size()>0){
					Set<Suggestion> suggestions = createSuggestions(tempLl, tempLl.size());
					reply.addAll(suggestions);
					tempLinkedList.clear();
					counter = 0; 
				}
    		}
    	}
    	return reply;
    }
	
	private static Set<Suggestion> createSuggestions(LinkedList<String> tempWords, int size){
    	Set<Suggestion> ret = new HashSet<>();    	
    	StringBuilder sb = new StringBuilder();    	
    	for(int i=0; i<size; i++){
    		sb.append(tempWords.get(i) + " ");    		
    		Suggestion tempSuggestion = new Suggestion(sb.toString());
    		ret.add(tempSuggestion);
    	}
    	//emptyLinkedList
    	if(tempWords.size() > 0){
        	tempWords.removeFirst();        
        	ret.addAll(createSuggestions(tempWords, tempWords.size()));        	
    	} 	
    	return ret;
    }
}
