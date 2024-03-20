package com.pfeproject.GeniusMind.Services;

import com.pfeproject.GeniusMind.Repository.CompteRepository;
import com.pfeproject.GeniusMind.Entity.CompteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class CompteService {

    @Autowired
    CompteRepository compteRepository;

    public CompteEntity createCompte(CompteEntity compte) {
        return compteRepository.save(compte);
    }

    public CompteEntity login(String userName, String password) {
        return compteRepository.findByUserNameAndPassword(userName, password);

}
}

