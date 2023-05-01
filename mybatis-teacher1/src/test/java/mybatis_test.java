import Pojo.Teacher;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class mybatis_test {
    private String res="mybatis-config.xml";
    private InputStream inputStream;
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession session;

    @Before
    public void first()throws Exception{
        inputStream = Resources.getResourceAsStream(res);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();
    }
    @Test
    public void test()throws Exception{
        List<Teacher> teachers=session.selectList("TeacherMapper.selectALL");
        System.out.println(teachers);
    }
    @After
    public void last()throws Exception{
        session.close();
        inputStream.close();
    }
}
