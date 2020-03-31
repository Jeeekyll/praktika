import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Lists;
import com.google.common.collect.Multiset;
import com.google.common.collect.Sets;

import java.util.*;


public class Student {
    String surname;
    Double weight;
    Double height;
    Integer group;

    static HashSet<Student> data = Sets.newHashSet(
            new Student("Ivanov", 120.66, 188.01, 208),
            new Student("Petrov", 85.67, 172.01, 209),
            new Student("Alekseev", 90.66, 150.01, 208),
            new Student("Zabelenkov", 100.16, 120.01, 208),
            new Student("Skrypnik", 85.66, 175.01, 209),
            new Student("Mokrivskiy", 99.11, 151.01, 208)
    );

    public Student() {}

    public Student(String surname, Double weight, Double height, Integer group) {
        this.surname = surname;
        this.weight = weight;
        this.height = height;
        this.group = group;
    }

    public ArrayList<Student> sortGroup(Comparator<Student> cStud, int groupCriteria) {
        ArrayList<Student> students = Lists.newArrayList();
        for (Student item : data) {
            if (item.group == groupCriteria) {
                students.add(item);
            }
        }
        students.sort(cStud);
        return students;
    }

    public void addStudent(String surname, Double weight, Double height, Integer group) {
        Preconditions.checkArgument(!(surname.equals("")), "Surname can't be empty!");
        Preconditions.checkArgument(!(weight < 0), "Weight can't be negative!");
        Preconditions.checkArgument(!(height < 0), "Height can't be negative!");
        Preconditions.checkNotNull(group, "Group can't be null");

        data.add(new Student(surname, weight, height, group));
    }

    public Integer inputGroup() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input group: ");
        this.group = scanner.nextInt();
        return group;
    }

    public void changeGroup(String surname, Integer group) {
        Preconditions.checkArgument(!(surname == null), "Surname cannot be empty!");
        for (Student item : data) {
            if (item.surname.equals(surname)) {
                System.out.println("Current group: " + item.group + "\nNew group: " + group);
                item.group = group;
            }
        }
    }

    public ArrayList<Student> findStudent(String surnameCriteria) {
        ArrayList<Student> students = new ArrayList<>();
        Preconditions.checkArgument(!(surnameCriteria.equals("")), "Surname cannot be empty!");
        for (Student item : data) {
            if (item.surname.equals(surnameCriteria)) {
                students.add(item);
            }
        }
        return students;
    }

    public String getSurname() {
        return surname;
    }

    public Double getWeight() {
        return weight;
    }

    public Double getHeight() {
        return height;
    }

    public Integer getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return  MoreObjects.toStringHelper(this)
                .add("surname", surname)
                .add("weight", weight)
                .add("height", height)
                .add("group", group)
                .toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Student other = (Student) obj;
        return Objects.equals(surname, other.surname)
                && Objects.equals(weight, other.weight)
                && Objects.equals(height, other.height)
                && Objects.equals(group, other.group);
    }

    @Override
    public int hashCode() {
       return Objects.hash(surname, weight, height, group);
    }
}






