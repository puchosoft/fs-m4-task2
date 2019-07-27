package com.codeoftheweb.salvo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api")
public class SalvoController {

    @Autowired
    private GameRepository gRepository;

    @RequestMapping("/games")
    public List<Object> getGameInfo(){
        return gRepository.findAll().stream().map(g -> makeGameDTO(g)).collect(toList());
    }

    private Map<String, Object> makeGameDTO(Game game){
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
        dto.put("id",game.getId());
        dto.put("created", game.getCreationDate());
        return dto;
    }
}
