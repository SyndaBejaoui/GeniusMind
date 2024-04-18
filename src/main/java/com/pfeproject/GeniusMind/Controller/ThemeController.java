package com.pfeproject.GeniusMind.Controller;

import com.pfeproject.GeniusMind.Entity.Theme;
import com.pfeproject.GeniusMind.Services.ThemeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class ThemeController {

    @Autowired
    private ThemeService themeService;

    @PostMapping("/addTheme")
    public Theme addTheme(@RequestBody Theme theme) {
        return themeService.addTheme(theme);
    }

    @GetMapping("/getThemes")
    public List<Theme> getThemes() {
        return themeService.getThemes();
    }

    @GetMapping("/getTheme/{idTheme}")
    public Theme getTheme(@PathVariable("idTheme") Long idTheme) {
        return themeService.getTheme(idTheme);

    }
}
