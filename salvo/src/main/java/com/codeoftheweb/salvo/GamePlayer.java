package com.codeoftheweb.salvo;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
public class GamePlayer {

  // ID automatico para la tabla "gamePlayers"
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
  @GenericGenerator(name = "native", strategy = "native")
  private long id;

  // Relacion con la tabla "games"
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "game_id")
  private Game game;

  // Relacion con la tabla "players"
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "player_id")
  private Player player;

  private Date joinDate;

  public GamePlayer() {
    joinDate = new Date();
  }

  public GamePlayer(Game game, Player player) {
    this.game = game;
    this.player = player;
    joinDate = new Date();
  }

  public long getId() {
    return id;
  }

  public Game getGame() {
    return game;
  }

  public void setGame(Game game) {
    this.game = game;
  }

  public Player getPlayer() {
    return player;
  }

  public void setPlayer(Player player) {
    this.player = player;
  }

  public Date getJoinDate() {
    return joinDate;
  }

  public void setJoinDate(Date joinDate) {
    this.joinDate = joinDate;
  }
}
