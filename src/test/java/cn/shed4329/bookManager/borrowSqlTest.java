package cn.shed4329.bookManager;

import cn.shed4329.bookManager.Mapper.BorrowMapper;
import cn.shed4329.bookManager.Mapper.StudentMapper;
import cn.shed4329.bookManager.SQL.SqlUtil;
import org.junit.jupiter.api.Test;

public class borrowSqlTest {
    @Test
    public void studentQueryTest(){
        SqlUtil.doSqlWork((StudentMapper mapper)->{
            System.out.println(mapper.getStudentBySid(8));
        },StudentMapper.class);
    }
    @Test
    public void borrowSimpleTest(){
        SqlUtil.doSqlWork((BorrowMapper mapper)->{
            mapper.getBorrow().forEach(System.out::println);
        },BorrowMapper.class);
    }
    @Test
    public void addBorrowTest(){
        SqlUtil.doSqlWork((BorrowMapper mapper)->{
            mapper.addBorrow(9,6);
        }, BorrowMapper.class);
    }
}
