package com.example.bmsser.repository;

import com.example.bmsser.entity.Stu;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StuRepository {
    public List<Stu> selectAllStu();
}
