package com.pfeproject.GeniusMind.Controller;

import com.pfeproject.GeniusMind.Entity.Level;
import com.pfeproject.GeniusMind.Services.LevelService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor
public class LevelController {
    @Autowired
    private LevelService levelService;

    @PostMapping("/addLevel/{idTheme}")
    public Level addLevel(@RequestBody Level level, @PathVariable("idTheme") Long idTheme) {
        return levelService.addLevel(level, idTheme);
    }

    @GetMapping("/getLevels/{idTheme}")
    public List<Level> getLevels(@PathVariable("idTheme") Long idTheme) {
        return levelService.getLevels(idTheme);
    }

    @GetMapping("/getLevel/{idTheme}")
    public Level getLevel(@PathVariable("idTheme") Long idTheme) {
        return levelService.getLevel(idTheme);
    }
}
