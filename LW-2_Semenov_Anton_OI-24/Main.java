package Student;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Створення масиву об'єктів студентів
        List<Student> students = new ArrayList<>();

        // Додавання студентів до масиву
        students.add(new Student(1, "Semenov", "Anton", "Denisovich", LocalDate.of(2005, 1, 25), "Kherson, Kamenskaya steet", "555-1234", "Computer Science", 2, "CS204"));
        students.add(new Student(2, "Topoliv", "Mykhailo", "Adnriyovich", LocalDate.of(2003, 8, 11), "Kiyv, Druzhba Narodiv street", "552-5158", "Computer Engineer", 4, "CE401"));
        students.add(new Student(3, "Redko", "Mykhailo", "Mikhaylovich", LocalDate.of(2004, 4, 27), "Bila Cerkva, Topilska street", "555-5678", "Computer Science", 3, "CS304"));
        students.add(new Student(4, "Andriychenko", "Ivan", "Mykolayovich", LocalDate.of(2006, 2, 22), "Kiyv, Maidan Nezalezhnosti street", "232-2143", "Computer Engineer", 1, "CE101"));

        // Виведення студентів певного факультету
        String desiredFaculty1 = "Computer Science";
        List<Student> studentsInFaculty1 = filterStudentsByFaculty(students, desiredFaculty1);
        System.out.println("\nStudents in the " + desiredFaculty1 + " faculty:");
        for (Student student : studentsInFaculty1) {
            System.out.println(student);
        }

        String desiredFaculty2 = "Computer Engineer";
        List<Student> studentsInFaculty2 = filterStudentsByFaculty(students, desiredFaculty2);
        System.out.println("\nStudents in the " + desiredFaculty2 + " faculty:");
        for (Student student : studentsInFaculty2) {
            System.out.println(student);
        }
    }

    // Метод для фільтрації студентів за факультетом
    private static List<Student> filterStudentsByFaculty(List<Student> students, String faculty) {
        List<Student> filteredStudents = new ArrayList<>();
        
        for (int i = 0; i<students.size(); i++) {
            if (students.get(i).getFaculty().equals(faculty)) {
                filteredStudents.add(students.get(i));
            }
        }
        return filteredStudents;
    }
}