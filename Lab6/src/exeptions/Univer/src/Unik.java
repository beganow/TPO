import java.util.*;
public class Unik {
    private String name;
    private List<Faculty> faculties;

    public Unik(String name) {
        this.name = name;
        this.faculties = new ArrayList<>();
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public double calculateAverageGradeForSubjectInUniversity(String subject) {
        if (faculties.isEmpty()) {
            throw new IllegalStateException("В университете должны быть факультеты");
        }
        int totalGrades = 0;
        int studentCount = 0;
        for (Faculty faculty : faculties) {
            for (Group group : faculty.getGroups()) {
                for (Student student : group.getStudents()) {
                    if (student.getSubjects().containsKey(subject)) {
                        totalGrades += student.getSubjects().get(subject);
                        studentCount++;
                    }
                }
            }
        }
        if (studentCount == 0) {
            throw new IllegalArgumentException("В университете нет студентов с предметом: " + subject);
        }
        return (double) totalGrades / studentCount;
    }
    public String getName() {
        return name;
    }
}
