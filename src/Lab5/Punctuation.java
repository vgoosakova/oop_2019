package Lab5;

public class Punctuation extends SentenceMember {
    private String symbols;

    Punctuation(String symbols) {
        this.symbols = symbols;
    }

    @Override
    public String toString() {
        return "Punctuation{" +
                "symbols='" + symbols + '\'' +
                '}';
    }
}