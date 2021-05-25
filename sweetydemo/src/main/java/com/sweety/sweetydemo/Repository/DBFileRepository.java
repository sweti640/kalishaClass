package com.sweety.sweetydemo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sweety.sweetydemo.bo.DBFile;

@Repository
public interface DBFileRepository extends JpaRepository<DBFile, Long>{

}
