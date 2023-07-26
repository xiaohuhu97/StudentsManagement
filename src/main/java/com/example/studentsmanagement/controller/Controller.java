package com.example.studentsmanagement.controller;

import com.example.studentsmanagement.entity.*;
import com.example.studentsmanagement.mapper.CourseMapper;
import com.example.studentsmanagement.mapper.ScoreMapper;
import com.example.studentsmanagement.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class Controller {

    @Autowired
    StudentMapper studentMapper;
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    ScoreMapper scoreMapper;

    //显示所有学生
    @RequestMapping("/selectAll")
    public List<Student> selectAll()
    {
        return studentMapper.selectList(null);
    }

    //指定学生查询（学号）+指定科目
    @RequestMapping("/selectStudent")
    public List<Stu_Sco> selectStudent(String id, String course_name)
    {
        if(course_name=="")
            return studentMapper.selectStudentById(id);
        else
            return studentMapper.selectStudentByCourse(id, course_name);
    }
    //指定老师查询+指定科目

    @RequestMapping("/selectTeacher")
    public List<Tea_Sco> selectTeacher(String teacher_name)
    {
        return studentMapper.selectTeacher(teacher_name);
    }
    //新增学生信息
    @RequestMapping("/insertStudent")
    public String insertStudent(String id,String name,String phone)
    {
        return studentMapper.insert(new Student(id,name,phone))>0?"success":"fail";
    }

    //新增课程信息
    @RequestMapping("/insertCourse")
    public String insertCourse(String course_id,String course_name,String teacher_name)
    {
        return courseMapper.insert(new Course(course_id,course_name,teacher_name))>0?"success":"fail";
    }

    //新增成绩信息
    @RequestMapping("/insertScore")
    public String insertScore(String id,String course_id,float score)
    {
        return scoreMapper.insert(new Score(id,course_id,score))>0?"success":"fail";
    }
}
