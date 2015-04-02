package com.github.kkrull.scala.scalatraits

import org.scalatest._
import java.awt.geom._

class TraitExerciseSpecs extends FunSpec 
  with Matchers
  with BeforeAndAfter {

  describe("RectangleLike") {
    describe(".translate") {
      val subject = new Ellipse2D.Double(1, 2, 4, 8) with RectangleLike
      subject.translate(16, -32)
      
      it("moves the object by the specified number of pixels in each dimension") { 
        assertResult(17d) { subject.getX }
        assertResult(-30d) { subject.getY }
      }
      it("maintains the same size") {
        assertResult(4d) { subject.getWidth }
        assertResult(8d) { subject.getHeight }
      }
    }

    describe(".grow") {
      val subject = new Ellipse2D.Double(1, 2, 4, 8) with RectangleLike
      subject.grow(16, 32)

      it("does not move the object") {
        assertResult(1) { subject.getX }
        assertResult(2) { subject.getY }
      }
      it("changes the side by the amount specified for each dimension") {
        assertResult(20) { subject.getWidth }
        assertResult(40) { subject.getHeight }
      }
    }
  }
}
