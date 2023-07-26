package com.example.studentsmanagement.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("student_info")
public class Student {

   public String id;
   public String name;
   public String phone;

}
