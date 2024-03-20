package com.pfeproject.GeniusMind.Controller;

import com.pfeproject.GeniusMind.Entity.CompteEntity;
import com.pfeproject.GeniusMind.Repository.CompteRepository;
import com.pfeproject.GeniusMind.Services.CompteService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*")
@RequestMapping("comptes")
@RestController
@Slf4j
public class CompteController {

    @Autowired
    CompteService compteService;
    @Autowired
    CompteRepository compteRepository;


    @PostMapping("log")
    public ResponseEntity<String> login(@RequestBody CompteEntity authRequest, HttpSession session) {
        String username = authRequest.getUserName();
        String password = authRequest.getPassword();
        CompteEntity compte = compteRepository.findByUserNameAndPassword(username, password);
        if (compte != null) {
            val isAdmin = compte.getIsAdmin();
            session.setAttribute("userRole", isAdmin); // Vous pouvez stocker n'importe quel objet lié à l'utilisateur ici
            session.setAttribute("username", compte.getUserName());
            return ResponseEntity.ok().body("{\"status\": \"ok\"}");
        } else {
            return ResponseEntity.ok().body("{\"status\": \"error\"}");
        }
    }
    @PostMapping("/inscription")
    public CompteEntity inscription(@RequestBody CompteEntity c) {
        log.info(c.getUserName());
       return compteService.createCompte(c);
    }

}

