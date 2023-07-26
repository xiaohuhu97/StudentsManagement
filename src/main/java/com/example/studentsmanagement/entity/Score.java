package com.example.studentsmanagement.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("score_info")
public class Score {
    public String id;
    public String course_id;
    public float score;
}
