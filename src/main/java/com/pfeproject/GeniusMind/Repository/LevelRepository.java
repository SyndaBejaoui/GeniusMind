package com.pfeproject.GeniusMind.Repository;

import com.pfeproject.GeniusMind.Entity.CoursEntity;
import com.pfeproject.GeniusMind.Entity.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LevelRepository extends JpaRepository<Level, Long> {


}
