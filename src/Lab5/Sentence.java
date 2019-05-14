package Lab5;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

class Sentence {
    private static final String PUNCTUATION_SYMBOLS = ",.!?";
    private SentenceMember[] sentenceMembers;


    Sentence(String s) {
        String[] split = s.split("(?=[,.!?])|\\s");
        sentenceMembers = new SentenceMember[split.length];
        for (int i = 0; i < split.length; i++) {
            if (PUNCTUATION_SYMBOLS.contains(split[i])) {
                sentenceMembers[i] = new Punctuation(split[i]);
            } else {
                sentenceMembers[i] = new Word(split[i]);
            }
        }
    }

    private static String getMaxPalindromeFromWords(Word[] words) {
        return Word.getMaxPalindromeFromWords(words);
    }

    private Word[] getWords() {
        return Arrays.stream(sentenceMembers)
                .filter(sentenceMember -> sentenceMember instanceof Word)
                .collect(Collectors.toList()).toArray(new Word[]{});
    }

    static String getMaxPalindromeFromSentences(Sentence[] sentences) {
        ArrayList<Word> words = new ArrayList<>();
        for (Sentence sentence : sentences) {
            words.addAll(Arrays.asList(sentence.getWords()));
        }
        return getMaxPalindromeFromWords(words.toArray(new Word[]{}));
    }
}
