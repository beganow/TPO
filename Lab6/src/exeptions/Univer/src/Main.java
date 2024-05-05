//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Создание университета
        Unik university = new Unik("Мой университет");

        // Создание факультета
        Faculty faculty = new Faculty("Факультет информационных технологий");

        // Создание группы
        Group group = new Group("Группа ИТ-1");

        // Создание студентов
        Student student1 = new Student("Иванов");
        Student student2 = new Student("Петров");

        // Добавление предметов и оценок студентам
        student1.addGrade("Математика", 2);
        student1.addGrade("Физика", 7);
        student2.addGrade("Математика", 9);
        student2.addGrade("Физика", 8);

        // Добавление студентов в группу
        group.addStudent(student1);
        group.addStudent(student2);

        // Добавление группы в факультет
        faculty.addGroup(group);

        // Добавление факультета в университет
        university.addFaculty(faculty);

        // Вычисление среднего балла по всем предметам студента
        double averageGrade = student1.calculateAverageGrade();
        System.out.println("Средний балл студента " + student1.getName() + ": " + averageGrade);

        // Вычисление среднего балла по предмету в группе на факультете
        double subjectAverageGrade = faculty.calculateAverageGradeForSubjectInGroup("Математика", group);
        System.out.println("Средний балл по предмету Математика в группе " + group.getName() + ": " + subjectAverageGrade);

        // Вычисление среднего балла по предмету в университете
        double universitySubjectAverageGrade = university.calculateAverageGradeForSubjectInUniversity("Физика");
        System.out.println("Средний балл по предмету Физика в университете " + university.getName() + ": " + universitySubjectAverageGrade);
    }
}