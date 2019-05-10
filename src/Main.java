import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {

        EducInst[] educinstArr = new EducInst[7];
        educinstArr[0] = new EducInst("School №8 ", 345, "Kyiv     ", 24, 1996);
        educinstArr[1] = new EducInst("School №256  ", 256, "Alchevsk ", 31, 2001);
        educinstArr[2] = new EducInst("Lyceum №1  ", 560, "Brovary  ", 43, 1895);
        educinstArr[3] = new EducInst("Gymnasium №45", 280, "Kharkiv  ", 39, 1992);
        educinstArr[4] = new EducInst("Lyceum №19  ", 489, "Zhytomyr ", 47, 1900);
        educinstArr[5] = new EducInst("Gymnasium №67", 634, "Odessa   ", 52, 1999);
        educinstArr[6] = new EducInst("School №226  ", 567, "Chernigov", 35, 1965);

        System.out.println("Sorted by city for an increase:");
        System.out.print("\n");
        Arrays.sort(educinstArr, Comparator.comparing(EducInst::getCity));
        for (EducInst s : educinstArr) {
            System.out.println(s);
        }
        System.out.print("\n");


        System.out.println("Sorted by students for a decrease:");
        System.out.print("\n");
        Arrays.sort(educinstArr, Comparator.comparing(EducInst::getStudents).reversed());
        for (EducInst s : educinstArr) {
            System.out.println(s);
        }
        System.out.print("\n");

    }

}