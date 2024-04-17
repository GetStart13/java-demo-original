package 数据库操作.entity;

import java.util.StringJoiner;

public class Student {
    private String name;
    private String course;
    private int grade;
    private String isPassed;

    public Student() {
    }

    public Student(String name, String course, int grade, String isPassed) {
        this.name = name;
        this.course = course;
        this.grade = grade;
        this.isPassed = isPassed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getIsPassed() {
        return isPassed;
    }

    public void setIsPassed(String isPassed) {
        this.isPassed = isPassed;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Student.class.getSimpleName() + "[", "]")
            .add("name='" + name + "'")
            .add("course='" + course + "'")
            .add("grade=" + grade)
            .add("isPassed='" + isPassed + "'")
            .toString();
    }
}
