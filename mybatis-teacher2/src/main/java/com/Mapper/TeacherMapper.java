package com.Mapper;

import com.Pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TeacherMapper {
    List<Teacher> selectAll();

    Teacher selectTeacherByTopSalaryDJM();

    List<Teacher> selectTeacherByAgeDJM(int age);

    List<Teacher> selectTeacherByAgeLess(int age);

//    参数
    List<Teacher> selectTeacherByAgeAndSalary(@Param("age")int age, @Param("salary")int salary);
//    实体类
//      List<Teacher> select(Teacher teacher);
//  map集合
    List<Teacher> selectTeacherByCondition(Map map);
}
