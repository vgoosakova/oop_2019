package Lab5;

public class Text {
    private Sentence[] sentences;
    private String s;

    Text(String s) {
        this.s = s;
        String[] split = s.split("(?<=[?!.])");
        sentences = new Sentence[split.length];
        for (int i = 0; i < split.length; i++) {
            sentences[i] = new Sentence(split[i]);
        }
    }

    void getMaxPalindromeFromSentences() {
//        int v = 0;
//        int needz = 0;
//        int z = 0;
        String a = Sentence.getMaxPalindromeFromSentences(sentences);
//        char start = a.charAt(1);
//        char end = a.charAt(a.length() - 2);
//        String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyzабвгдэежзыи" +
//                "йклмнопрстуфхцчшщюьъїяАБВГДЭЕЖЗЫИЙКЛМНОПРСТУФХЦЧШЩЮЬЪЇЯ";
//        for (char i : a.toCharArray()) {
//            if (alphabets.contains(i + "")) {
//                needz++;
//            }
//        }
//
//        for (char as : s.toCharArray()) {
//            if (as == start && v == 0) {
//                v++;
//            }
//            if (v > 0) {
//                System.out.print(as);
//                if (alphabets.contains(as + "")) {
//                    z++;
//                }
//            }
//            if (as == end && needz == z) {
//                v--;
//            }
//        }
    }
}
