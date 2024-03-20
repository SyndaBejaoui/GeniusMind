package com.pfeproject.GeniusMind.Repository;
import com.pfeproject.GeniusMind.Entity.CompteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompteRepository extends JpaRepository<CompteEntity, Integer> {

 public CompteEntity findByUserNameAndPassword(String userName, String password);
}
