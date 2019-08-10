$(function(){

  function showGameList(gameList){
    var li="";
    gameList.forEach(g => {
      var date = new Date(g.created).toLocaleString();
      var players = g.gamePlayers.map(gp => gp.player.username).join(', ');
      li+='<li>'+ date + ', ' + players + '</li>';
    });
    $('#listGames').html(li);
  }

  function loadData(){
      $.getJSON("/api/games")
      .done(function(data) {
          showGameList(data);
      });
  }

  loadData();
});
