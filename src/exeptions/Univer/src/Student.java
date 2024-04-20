import java.util.*;
public class Student {
    private String name;
    private Map<String, Integer> subjects;

    public Student(String name) {
        this.name = name;
        this.subjects = new HashMap<>();
    }

    public void addGrade(String subject, int grade) {
        if (grade < 0 || grade > 10) {
            throw new IllegalArgumentException("Оценка должна быть между 0 и 10");
        }
        subjects.put(subject, grade);
    }
    public Map<String, Integer> getSubjects() {
        return subjects;
    }
    public String getName() {
        return name;
    }


    public double calculateAverageGrade() {
        if (subjects.isEmpty()) {
            throw new IllegalStateException("Студент должен иметь хотя бы один предмет");
        }
        int totalGrades = subjects.values().stream().mapToInt(Integer::intValue).sum();
        return (double) totalGrades / subjects.size();
    }
}
