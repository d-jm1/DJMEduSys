
import com.Mapper.TeacherMapper;
import com.Pojo.Teacher;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeacherTest {
    private String res = "com/mybatis-config.xml";
    private InputStream inputStream;
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    private TeacherMapper teacherMapper;

    @Before
    public void firstDo() throws IOException {
        res = "com/mybatis-config.xml";
        inputStream = Resources.getResourceAsStream(res);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        teacherMapper = sqlSession.getMapper(TeacherMapper.class);
    }

    @Test
    public void testSelectAll() {
        List<Teacher> teachers = teacherMapper.selectAll();
        System.out.println(teachers);
    }

    @Test
    public void testSelectTeacherByTopSalaryDJM() throws IOException {
        Teacher teacher = teacherMapper.selectTeacherByTopSalaryDJM();
        System.out.println(teacher);
    }

    @Test
    public void testSelectTeacherByAgeDJM() throws IOException {
        List<Teacher> teachers = teacherMapper.selectTeacherByAgeDJM(30);
        System.out.println(teachers);
    }

    @Test
    public void testSelectTeacherByAgeAndSalary() throws IOException {
        List<Teacher> teachers = teacherMapper.selectTeacherByAgeAndSalary(30, 5000);
        System.out.println(teachers);
    }

    @Test
    public void testSelectTeacherByCondition() {
        int age = 30;
        int salary = 1;
        String graduate = "大学";
        graduate = "'%" + graduate + "%'";
        Map map = new HashMap();
        map.put("age", age);
        map.put("salary", salary);
        map.put("graduate",graduate);
        List<Teacher> teachers = teacherMapper.selectTeacherByCondition(map);
        System.out.println(teachers);
    }

    @After
    public void lastDo() throws IOException {
        sqlSession.close();
        inputStream.close();
    }
}
