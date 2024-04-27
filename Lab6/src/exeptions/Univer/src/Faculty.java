import java.util.*;
public class Faculty {
    private String name;
    private List<Group> groups;

    public Faculty(String name) {
        this.name = name;
        this.groups = new ArrayList<>();
    }
    public List<Group> getGroups() {
        return groups;
    }
    public void addGroup(Group group) {
        groups.add(group);
    }

    public double calculateAverageGradeForSubjectInGroup(String subject, Group group) {
        if (!groups.contains(group)) {
            throw new IllegalArgumentException("Группа не принадлежит факультету");
        }
        return group.calculateAverageGradeForSubject(subject);
    }
}
