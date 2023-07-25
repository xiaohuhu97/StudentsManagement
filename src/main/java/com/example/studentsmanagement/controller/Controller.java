package com.example.studentsmanagement.controller;

import com.example.studentsmanagement.entity.Course;
import com.example.studentsmanagement.entity.Score;
import com.example.studentsmanagement.entity.Stu_Sco;
import com.example.studentsmanagement.entity.Student;
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


    @RequestMapping("/selectAll")
    public List<Student> selectAll()
    {
        return studentMapper.selectList(null);
        //return studentMapper.select1();
    }
    //显示学生
    //指定查询
    //指定学生查询（姓名，学号）+指定科目
    @RequestMapping("/selectStudent")
    public List<Stu_Sco> selectStudent(String id, String name)
    {

        //System.out.println("can i see it?"+"    id:"+id+"    name:"+name);
//        List<Stu_Sco> stu_scos=studentMapper.selectStudent(id);
//        for (Stu_Sco item : stu_scos) {
//            System.out.println(item.id+"   "+item.name+"   "+item.course_name+"   "+item.score);
//        }
        return studentMapper.selectStudent(id);
    }
    //指定老师查询+指定科目

    //新增学生信息
    @RequestMapping("/insertStudent")
    public String insertStudent(String id,String name,String phone)
    {
        return studentMapper.insert(new Student(id,name,phone))>0?"success":"fail";
    }

    //新增课程信息
    @RequestMapping("/insertCourse")
    public String insertCourse(String id,String name,String teacher)
    {
        return courseMapper.insert(new Course(id,name,teacher))>0?"success":"fail";
    }

    //新增成绩信息
    @RequestMapping("/insertScore")
    public String insertScore(String id,String course_id,float score)
    {
        return scoreMapper.insert(new Score(id,course_id,score))>0?"success":"fail";
    }
}
