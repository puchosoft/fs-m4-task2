package com.codeoftheweb.salvo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api")
public class SalvoController {

    @Autowired
    private GameRepository gRepository;

    @RequestMapping("/games")
    public List<Object> getGameIDs(){
        return gRepository.findAll().stream().map(g -> g.getId()).collect(toList());
    }
}
