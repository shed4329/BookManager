package cn.shed4329.bookManager.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class Student {
    int sid;
    String name;
    String sex;
    int grade;

    public Student(String name, String sex, int grade) {
        this.name = name;
        this.sex = sex;
        this.grade = grade;
    }
}
