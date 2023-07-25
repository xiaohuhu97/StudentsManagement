package com.example.studentsmanagement.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.studentsmanagement.entity.Stu_Sco;
import com.example.studentsmanagement.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentMapper extends BaseMapper<Student>
{
    @Select("select student_info.id,student_info.name,course_info.course_name,score from student_info,course_info,score_info where student_info.id=score_info.id and course_info.course_id=score_info.course_id  AND student_info.id = #{id};" )
    List<Stu_Sco> selectStudent(@Param("id") String id);
    @Select("select *  from student_info where id like '100%';")
    List<Student> select1();
}
