
@SuppressWarnings("WeakerAccess")

public class EducInst {
    private String name;
    private int students;
    private String city;
    private String teachers;
    private String foundation;

    public EducInst(String name, int students, String city, String teachers, String foundation) {
        this.name = name;
        this.students = students;
        this.city = city;
        this.teachers= teachers;
        this.foundation = foundation;
    }

    //@Override
    public String toString() {
        return "name: " + name + "\t\t" +
                " students: " + students+ "\t\t" +
                " city: " + city + "\t\t" +
                " teachers: " + teachers + "\t\t" +
                " foundation: " + foundation;
    }

    public String getName() {
        return name;
    }

    public int getStudents() {
        return students;
    }

    public String getCity() {
        return city;
    }

    public String getTeachers() {
        return teachers;
    }

    public String getFoundation() {
        return foundation;
    }

}