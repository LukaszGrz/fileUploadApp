package com.example.springbootfileuploadmysql.repository;

import com.example.springbootfileuploadmysql.model.DBfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DBFileRepository extends JpaRepository<DBfile, String>{
}
