package cn.shed4329.bookManager.Mapper;

import cn.shed4329.bookManager.entity.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface StudentMapper {
    @Insert("insert into student(name,sex,grade) values (#{name},#{sex},#{grade})")
    int addStudent(Student student);

    @Results({
            @Result(column = "sid",property = "sid",id = true),
            @Result(column = "name",property = "name"),
            @Result(column = "sex",property = "sex",javaType = String.class,jdbcType = JdbcType.VARCHAR),
            @Result(column = "grade",property = "grade")
    })
    @Select("select * from student where sid = #{sid}")
    Student getStudentBySid(int sid);

    @Select("select * from student")
    List<Student> getStudents();
}
