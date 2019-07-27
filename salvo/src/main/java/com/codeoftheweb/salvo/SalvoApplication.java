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

  // Este codigo se ejecuta al inicio de la aplicacion
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
      game = new Game();
      game.setCreationDate(Date.from(game.getCreationDate().toInstant().plus(Duration.ofHours(3))));
      gRepository.save(game);
      game = new Game();
      game.setCreationDate(Date.from(game.getCreationDate().toInstant().plus(Duration.ofHours(4))));
      gRepository.save(game);
      game = new Game();
      game.setCreationDate(Date.from(game.getCreationDate().toInstant().plus(Duration.ofHours(5))));
      gRepository.save(game);
      game = new Game();
      game.setCreationDate(Date.from(game.getCreationDate().toInstant().plus(Duration.ofHours(6))));
      gRepository.save(game);
      game = new Game();
      game.setCreationDate(Date.from(game.getCreationDate().toInstant().plus(Duration.ofHours(7))));
      gRepository.save(game);

      // guardamos algunos gamePlayers
      gpRepository.save(new GamePlayer(gRepository.getOne(1L), pRepository.getOne(1L)));
      gpRepository.save(new GamePlayer(gRepository.getOne(1L), pRepository.getOne(2L)));
      gpRepository.save(new GamePlayer(gRepository.getOne(2L), pRepository.getOne(1L)));
      gpRepository.save(new GamePlayer(gRepository.getOne(2L), pRepository.getOne(2L)));
      gpRepository.save(new GamePlayer(gRepository.getOne(3L), pRepository.getOne(2L)));
      gpRepository.save(new GamePlayer(gRepository.getOne(3L), pRepository.getOne(4L)));
      gpRepository.save(new GamePlayer(gRepository.getOne(4L), pRepository.getOne(2L)));
      gpRepository.save(new GamePlayer(gRepository.getOne(4L), pRepository.getOne(1L)));
      gpRepository.save(new GamePlayer(gRepository.getOne(5L), pRepository.getOne(4L)));
      gpRepository.save(new GamePlayer(gRepository.getOne(5L), pRepository.getOne(1L)));
      gpRepository.save(new GamePlayer(gRepository.getOne(6L), pRepository.getOne(3L)));
      gpRepository.save(new GamePlayer(gRepository.getOne(7L), pRepository.getOne(4L)));
      gpRepository.save(new GamePlayer(gRepository.getOne(8L), pRepository.getOne(3L)));
      gpRepository.save(new GamePlayer(gRepository.getOne(8L), pRepository.getOne(4L)));
    };
  }
}
