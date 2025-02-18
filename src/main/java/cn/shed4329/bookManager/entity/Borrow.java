package cn.shed4329.bookManager.entity;

import lombok.Data;

@Data
public class Borrow {
    int id;
    Student student;
    Book book;
    public int getBid(){
        return book.getBid();
    }
    public String getBookName(){
        return book.getTitle();
    }

    public int getSid(){
        return student.getSid();
    }
    public String getStudentName(){
        return student.getName();
    }
}
