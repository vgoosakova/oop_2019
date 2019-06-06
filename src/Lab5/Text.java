package Lab5;

class Text {
    private Sentence[] sentences;

    public Text(String s) {
        String[] split = s.split("(?<=[?!.]) ");
        this.sentences = new Sentence[split.length];
        for (int i = 0; i < split.length; i++) {
            this.sentences[i] = new Sentence(split[i]);
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Sentence sentence : this.sentences) {
            result.append(sentence.toString()).append(" ");
        }
        return result.toString();
    }

    public Text largestPalindrome() {
        String text = this.toString();
        return new Text(this.longestPalSubstr(text));
    }

    private String longestPalSubstr(String str) {
        str = str.replaceAll(" ", "");
        int n = str.length();   // get length of input string

        // table[i][j] will be false if substring str[i..j]
        // is not palindrome.
        // Else table[i][j] will be true
        boolean[][] table = new boolean[n][n];

        // All substrings of length 1 are palindromes
        int maxLength = 1;
        for (int i = 0; i < n; ++i)
            table[i][i] = true;

        // check for sub-string of length 2.
        int start = 0;
        for (int i = 0; i < n - 1; ++i) {
            if (str.toLowerCase().charAt(i)
                    == str.toLowerCase().charAt(i + 1)) {
                table[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        // Check for length greater than 2. k is length
        // of substring
        for (int k = 3; k <= n; ++k) {
            // Fix the starting index
            for (int i = 0; i < n - k + 1; ++i) {
                // Get the ending index of substring from
                // starting index i and length k
                int j = i + k - 1;

                // checking for sub-string from ith index to
                // jth index iff str.charAt(i+1) to
                // str.charAt(j-1) is a palindrome
                if (table[i + 1][j - 1] && str.toLowerCase().charAt(i) ==
                        str.toLowerCase().charAt(j)) {
                    table[i][j] = true;

                    if (k > maxLength) {
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }

        return str.substring(start, start + maxLength + 1);
    }
}


