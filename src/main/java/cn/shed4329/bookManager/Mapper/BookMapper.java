package cn.shed4329.bookManager.Mapper;

import cn.shed4329.bookManager.entity.Book;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BookMapper {
    @Insert("insert into book(title,`desc`,price) values (#{title},#{desc},#{price})")
    int addBook(Book book);

    @Select("select * from book where bid = #{bid}")
    Book getBookByBid(int bid);

    @Select("select * from book")
    List<Book> getBooks();
}
