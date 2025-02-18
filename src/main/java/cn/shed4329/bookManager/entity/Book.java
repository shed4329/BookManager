package cn.shed4329.bookManager.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
public class Book {
    int bid;
    String title;
    String desc;
    double price;

    public Book(String title, String desc, double price) {
        this.title = title;
        this.desc = desc;
        this.price = price;
    }
}
