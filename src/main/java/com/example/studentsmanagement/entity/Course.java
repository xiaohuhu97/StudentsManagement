package com.example.studentsmanagement.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("course_info")
public class Course {

    public String course_id;
    public String course_name;
    public String teacher_name;
}
