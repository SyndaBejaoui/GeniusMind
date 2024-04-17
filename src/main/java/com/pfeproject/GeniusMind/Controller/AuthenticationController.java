package com.pfeproject.GeniusMind.Controller;
import com.pfeproject.GeniusMind.Exceptions.NotFoundException;
import com.pfeproject.GeniusMind.Services.AuthenticationService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    public void register(@RequestBody RegisterRequest request) throws Exception {
         service.register(request);
    }

    @PostMapping("/authenticate")
    @ResponseStatus(HttpStatus.OK)
    public AuthenticationResponse authenticate(@RequestBody AuthenticationRequest request) {
        System.out.println(request.getEmail());
        return service.authenticate(request);
    }

}
