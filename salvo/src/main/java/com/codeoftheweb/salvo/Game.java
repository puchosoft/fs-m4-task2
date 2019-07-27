package com.codeoftheweb.salvo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toList;

@Entity
public class Game {

  // Relacion con la tabla "gamePlayers"
  @OneToMany(mappedBy = "game", fetch = FetchType.EAGER)
  Set<GamePlayer> gamePlayers;

  // ID automatico para la tabla "games"
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
  @GenericGenerator(name = "native", strategy = "native")
  private long id;

  private Date creationDate;

  public Game() {
    this.creationDate = new Date();
  }

  public Date getCreationDate() {
    return this.creationDate;
  }

  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }

  public long getId() {
    return this.id;
  }

  public void addGamePlayer(GamePlayer gamePlayer) {
    gamePlayer.setGame(this);
    gamePlayers.add(gamePlayer);
  }

  public List<Player> getPlayers() {
    return gamePlayers.stream().map(gp -> gp.getPlayer()).collect(toList());
  }
}
