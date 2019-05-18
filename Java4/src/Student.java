public class Student {
    private static int _graduatesCount = 0;
    private String _name;

    public Student(String name) {
        this._name = name;
    }

    public void studentGraduated() {
        _graduatesCount++;
    }

    public void printInfo() {
        System.out.println(this._name + ", " + _graduatesCount);
    }

    public static void main(String[] args) {
        Student s1 = new Student("Rom");
        Student s2 = new Student("Jack");

        s1.studentGraduated();
        s2.studentGraduated();

        s1.printInfo();
        s2.printInfo();
    }
}

