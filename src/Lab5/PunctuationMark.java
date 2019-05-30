package Lab5;
class PunctuationMark extends SentenceMember {
    private String symbols;

    public PunctuationMark(String symbols) {
        this.symbols = symbols;
    }

    @Override
    public String toString() {
        return this.symbols;
    }
}
