package com.example.studentsmanagement.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.studentsmanagement.entity.Stu_Sco;
import com.example.studentsmanagement.entity.Student;
import com.example.studentsmanagement.entity.Tea_Sco;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentMapper extends BaseMapper<Student>
{
    @Select("select student_info.id,name,course_name,score from student_info,course_info,score_info where student_info.id=score_info.id and course_info.course_id=score_info.course_id  AND student_info.id = #{id} ORDER BY score DESC;" )
    List<Stu_Sco> selectStudentById(@Param("id") String id);

    @Select("select student_info.id,name,course_name,score from student_info,course_info,score_info where student_info.id=score_info.id and course_info.course_id=score_info.course_id  AND student_info.id = #{id} and course_info.course_name=#{course_name} ORDER BY score DESC;" )
    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.CHAR),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column="course_name", property="course_name", jdbcType= JdbcType.VARCHAR),
            @Result(column="score", property="score", jdbcType= JdbcType.FLOAT)
    })
    List<Stu_Sco> selectStudentByCourse(@Param("id") String id,@Param("course_name")String course_name);

    @Select("select teacher_name,course_name,AVG(score) from course_info,score_info where course_info.course_id=score_info.course_id AND teacher_name = #{teacher_name} group by teacher_name;" )
    @Results({
            @Result(column="teacher_name", property="teacher", jdbcType= JdbcType.VARCHAR),
            @Result(column="course_name", property="course_name", jdbcType= JdbcType.VARCHAR),
            @Result(column="AVG(score)", property="score", jdbcType= JdbcType.FLOAT)
    })
    List<Tea_Sco> selectTeacher(@Param("teacher_name")String teacher_name);
}
