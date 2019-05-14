package Lab5;
import java.util.ArrayList;
import java.util.Arrays;

class Word extends SentenceMember {
    private Letter[] letters;
    private int palindromeStart = -1;
    private int palindromeEnd = -1;

    private static boolean isPalindrome(ArrayList<Letter> smallText) {
        int q = smallText.size();
        for (int i = 0; i < q / 2; i++) {
            char chr = smallText.get(i).getaChar();
            char chrE = smallText.get(q - i - 1).getaChar();
            if (chr < 1072 && chr > 1039 || chr >= 65 && chr <= 90)
                chr += 32;
            if (chrE < 1072 && chrE > 1039 || chrE >= 65 && chrE <= 90) chrE += 32;
            if (chr != chrE) return false;
        }
        return true;
    }

    Word(String s) {
        letters = new Letter[s.length()];
        for (int i = 0; i < s.length(); i++)
            letters[i] = new Letter(s.charAt(i));
    }

    static String getMaxPalindromeFromWords(Word[] words) {
        ArrayList<Letter> letters = new ArrayList<>();
        for (Word word : words)
            letters.addAll(Arrays.asList(word.letters));//TODO А тута третья лабка
        int len = letters.size();
        ArrayList<Letter> smallletters = new ArrayList<>();
        exitlabel:
        for (int end = 0; end < len; end++) {
            for (int start = 0; start < end + 1; start++) {
                smallletters.clear();
                for (int i = start; i < len - end + start; i++) {
                    smallletters.add(letters.get(i));
                }
                if (isPalindrome(smallletters)) {
                    break exitlabel;
                }
            }
        }

        initPalindromeBounds(words, letters, smallletters);

        return smallletters.toString();
    }

    private static void initPalindromeBounds(Word[] words,
                                             ArrayList<Letter> originalLetters,
                                             ArrayList<Letter> palindromeLetters) {
        Bounds palindromeLetterBounds =
                getPalindromeLetterBounds(originalLetters, palindromeLetters);

        int startIndexPalindromeLetter = palindromeLetterBounds.getStart();
        int endIndexPalindromeLetter = palindromeLetterBounds.getEnd();
        Word wordPalindromeStart = getWordWithPalindromeStart(words, startIndexPalindromeLetter);
        // todo
        Word wordPalindromeEnd = getWordWithPalindromeEnd(words, endIndexPalindromeLetter);
        System.out.println(wordPalindromeStart);
        System.out.println(wordPalindromeEnd);
        for (int i = 0; i < words.length; i++) {
            if (words[i] == wordPalindromeStart) {
                output(words[i].palindromeStart, words[i].size() - 1, words[i]);
                i++;
                while (words[i] != wordPalindromeEnd) {
                    output(0,words[i].size()-1,words[i]);
                    i++;
                }
                output(0, words[i].palindromeEnd, words[i]);
            }

        }
    }

    private static void output(int from, int to, Word word) {
        ArrayList<Letter> letters = new ArrayList<>(Arrays.asList(word.letters));
        for (int i = 0; i < letters.size(); i++) {
            if (i >= from && i <= to)
                System.out.print(letters.get(i).toString());
        }
    }

    private static Word getWordWithPalindromeEnd(Word[] words, int endIndexPalindromeLetter) {
        int index = 0;
        int currentAggregatedLength = words[0].size();

        while (currentAggregatedLength < endIndexPalindromeLetter) {
            index++;
            currentAggregatedLength += words[index].size();
        }

        Word resultWord = words[index];
        resultWord.setPalindromeEnd(resultWord.size() -
                (currentAggregatedLength - endIndexPalindromeLetter) - 1);

        return resultWord;
    }


    private static Word getWordWithPalindromeStart(Word[] words,
                                                   int startIndexPalindromeLetter) {
        int index = 0;
        int currentAggregatedLength = words[0].size();

        while (currentAggregatedLength <= startIndexPalindromeLetter) {
            index++;
            currentAggregatedLength += words[index].size();
        }

        Word resultWord = words[index];
        resultWord.setPalindromeStart(resultWord.size() -
                (currentAggregatedLength - startIndexPalindromeLetter));

        return resultWord;
    }

    private int size() {
        return letters.length;
    }

    private static Bounds getPalindromeLetterBounds(ArrayList<Letter> originalLetters,
                                                    ArrayList<Letter> palindromeLetters) {
        String lettersString = "";
        for (Letter letter : originalLetters) {
            lettersString += letter.toString();
        }

        String palindromeLettersString = "";
        for (Letter letter : palindromeLetters) {
            palindromeLettersString += letter.toString();
        }

        int startBound = lettersString.indexOf(palindromeLettersString);
        int endBound = startBound + palindromeLettersString.length();
        return new Bounds(startBound, endBound);
    }

    public int getPalindromeStart() {
        return palindromeStart;
    }

    public void setPalindromeStart(int palindromeStart) {
        this.palindromeStart = palindromeStart;
    }

    public int getPalindromeEnd() {
        return palindromeEnd;
    }

    public void setPalindromeEnd(int palindromeEnd) {
        this.palindromeEnd = palindromeEnd;
    }

    static class Bounds {
        private int start;
        private int end;

        public Bounds(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }
    }

    @Override
    public String toString() {
        return "Word{" +
                "letters=" + Arrays.toString(letters) +
                ", palindromeStart=" + palindromeStart +
                ", palindromeEnd=" + palindromeEnd +
                '}';
    }
//    public String toString() {
//        ArrayList<Letter> letters = new
//    }
}
