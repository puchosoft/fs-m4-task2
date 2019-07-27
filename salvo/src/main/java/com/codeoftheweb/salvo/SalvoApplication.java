package com.codeoftheweb.salvo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Duration;
import java.util.Date;

@SpringBootApplication
public class SalvoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SalvoApplication.class, args);
    }

    @Bean
    public CommandLineRunner initData(PlayerRepository pRepository,
                                      GameRepository gRepository,
                                      GamePlayerRepository gpRepository) {
        return (args) -> {

            Game game;

            // guardamos algunos players
            pRepository.save(new Player("j.bauer@ctu.gov"));
            pRepository.save(new Player("c.obrian@ctu.gov"));
            pRepository.save(new Player("kim_bauer@gmail.com"));
            pRepository.save(new Player("t.almeida@ctu.gov"));

            // guardamos algunos games
            gRepository.save(new Game());
            game = new Game();
            game.setCreationDate(Date.from(game.getCreationDate().toInstant().plus(Duration.ofHours(1))));
            gRepository.save(game);
            game = new Game();
            game.setCreationDate(Date.from(game.getCreationDate().toInstant().plus(Duration.ofHours(2))));
            gRepository.save(game);

            gpRepository.save(new GamePlayer(gRepository.getOne(1L),pRepository.getOne(1L)));
            gpRepository.save(new GamePlayer(gRepository.getOne(1L),pRepository.getOne(2L)));
            gpRepository.save(new GamePlayer(gRepository.getOne(2L),pRepository.getOne(1L)));
            gpRepository.save(new GamePlayer(gRepository.getOne(2L),pRepository.getOne(2L)));
            gpRepository.save(new GamePlayer(gRepository.getOne(3L),pRepository.getOne(2L)));
            gpRepository.save(new GamePlayer(gRepository.getOne(3L),pRepository.getOne(4L)));

        };
    }
}
