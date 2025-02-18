package cn.shed4329.bookManager.SQL;

import cn.shed4329.bookManager.Mapper.BookMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.function.Consumer;

public class SqlUtil {
    static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> void doSqlWork(Consumer<T> consumer, Class<T> mapperClass) {
        try (SqlSession session = sqlSessionFactory.openSession(true)) {
            T mapper = session.getMapper(mapperClass);
            consumer.accept(mapper);
        }
    }

}
