package com.pfeproject.GeniusMind.Repository;

import com.pfeproject.GeniusMind.Entity.CoursEntity;
import com.pfeproject.GeniusMind.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursRepository extends JpaRepository<CoursEntity, Long> {


}
