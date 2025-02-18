package cn.shed4329.bookManager.Mapper;

import cn.shed4329.bookManager.entity.Borrow;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BorrowMapper {
    @Results({
            @Result(column = "orderID",property = "id",id = true),
            @Result(column = "sid",property = "student",one=@One(select = "cn.shed4329.bookManager.Mapper.StudentMapper.getStudentBySid")),
            @Result(column = "bid",property = "book",one=@One(select = "cn.shed4329.bookManager.Mapper.BookMapper.getBookByBid"))
    })
    @Select("select * from borrow")
    List<Borrow> getBorrow();

    @Insert("insert into borrow(bid,sid) values(#{bid},#{sid})")
    int addBorrow(@Param("bid") int bid,@Param("sid") int sid);
}
