package minimax

class Minimax(maximizer: Player, minimizer: Player) {
  def scoreGame(game: GameState, forWhom: Player): Int = {
    game.findWinner match {
      case Some(winner) if winner == this.maximizer =>
        +1
      case Some(winner) if winner == this.minimizer =>
        -1
      case None if game.isOver =>
        0
      case _ =>
        if(forWhom == this.maximizer) {
          var maxScore = -100
          for(move <- game.availableMoves) {
            val nextGame = game.nextState(move)
            val nextScore = scoreGame(nextGame, new Player("Unknown"))
            if(nextScore > maxScore) {
              maxScore = nextScore
            }
          }

          maxScore
        } else if(forWhom == this.minimizer) {
          var minScore = +100
          for(move <- game.availableMoves) {
            val nextGame = game.nextState(move)
            val nextScore = scoreGame(nextGame, new Player("Unknown"))
            if(nextScore < minScore) {
              minScore = nextScore
            }
          }

          minScore
        } else {
          9999
        }

    }
  }
}

class Player(val name: String) extends AnyVal {
  override def toString() = s"$name"
}

trait GameState {
  def availableMoves(): Seq[String]
  def findWinner(): Option[Player]
  def isOver(): Boolean
  def nextState(move: String): GameState
}
