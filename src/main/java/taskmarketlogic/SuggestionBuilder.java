package taskmarketlogic;

import java.util.Iterator;
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

    }

    /** The maximum amount of words which can be combined to a suggestion */

    private final static int MAX_COMBINED_TOKENS = 3;

    private static final String[] TOKENS  =  {"The", "beautiful", "girl", "from", "the", "farmers", "market", ".", "I", "like", "chewing", "gum", "." };

    private static final String[] STOP_WORDS = {"is", "can", "the"};

    private static Set<Suggestion> buildSuggestionsFromTokenFromString(Iterator<String> tokens, Set<String> stopWords) {

        // Implementation comes here

		// Please don't change the signature of this method
    	return null;
    }
}
