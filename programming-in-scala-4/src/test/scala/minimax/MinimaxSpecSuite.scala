package minimax

import org.scalatest._
import org.scalatest.matchers.should._
import funspec._

abstract class GameDouble(availableMoves: Map[String, GameDouble], isOver: Boolean, winner: Option[Player]) extends GameState {
  def availableMoves() = availableMoves.keySet.toList
  def findWinner() = winner
  def isOver() = isOver
  def nextState(move: String): GameState = availableMoves.get(move).get
}

case class Tie() extends GameDouble(Map(), true, None)
case class UndecidedGame(moves: Map[String, GameDouble]) extends GameDouble(moves, false, None)
case class Victory(winner: Player) extends GameDouble(Map(), true, Some(winner))

class MinimaxSpecSuite extends AnyFunSpec with Matchers {
  describe("Minimax") {
    describe("scoreGame") {
      val max = new Player("Max")
      val min = new Player("Min")
      val subject = new Minimax(max, min)

      it("scores a game won by the maximizer as +1") {
        val game = Victory(max)
        subject.scoreGame(game, max) shouldEqual(+1)
      }

      it("scores a game won by the minimizer as -1") {
        val game = Victory(min)
        subject.scoreGame(game, max) shouldEqual(-1)
      }

      it("scores a tie game as 0") {
        val game = Tie()
        subject.scoreGame(game, max) shouldEqual(0)
      }

      describe("given a game that will end in 1 more move") {
        val game = UndecidedGame(
          Map(
            "MaxWins" -> Victory(max),
            "MinWins" -> Victory(min)
          )
        )

        it("the maximizing player picks the move leading to the highest score") {
          subject.scoreGame(game, max) shouldEqual(+1)
        }

        it("the minimizing player picks the move leading to the lowest score") {
          subject.scoreGame(game, min) shouldEqual(-1)
        }
      }
    }
  }
}
