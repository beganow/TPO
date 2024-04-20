import java.util.*;
public class Group {
    private String name;
    private List<Student> students;

    public Group(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }
    public List<Student> getStudents() {
        return students;
    }


    public double calculateAverageGradeForSubject(String subject) {
        if (students.isEmpty()) {
            throw new IllegalStateException("В группе должны быть студенты");
        }
        int totalGrades = 0;
        int studentCount = 0;
        for (Student student : students) {
            if (student.getSubjects().containsKey(subject)) {
                totalGrades += student.getSubjects().get(subject);
                studentCount++;
            }
        }
        if (studentCount == 0) {
            throw new IllegalArgumentException("В группе нет студентов с предметом: " + subject);
        }
        return (double) totalGrades / studentCount;
    }
    public String getName() {
        return name;
    }
}
