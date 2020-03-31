import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Student testStudent = new Student();
        Comparator<Student> weightComparator = new WeightComparator();
        Comparator<Student> heightComparator = new HeightComparator();
        Comparator<Student> surnameComparator = new SurnameComparator();
        ArrayList<Student> sorted;
        sorted = testStudent.sortGroup(heightComparator, 208);
        for(Student item : sorted){
            System.out.println(item);
        }

        System.out.println("------------------------------");
        for(Student item : Student.data){
            System.out.println(item);
        }
    }
}
