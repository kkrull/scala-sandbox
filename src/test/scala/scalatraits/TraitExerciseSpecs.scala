package com.github.kkrull.scala.scalatraits

import org.scalatest._
import java.awt.geom._

class TraitExerciseSpecs extends FunSpec 
  with Matchers
  with BeforeAndAfter {

  describe("RectangleLike") {
    val subject = new Ellipse2D.Double(5, 10, 20, 30) with RectangleLike
    
    describe(".translate") {
      before { subject.translate(10, -10) }
      it("moves the object by the specified number of pixels in each dimension") { 
        assertResult(15d) { subject.getX }
        assertResult(0d) { subject.getY }
      }
      it("maintains the same size") {
        assertResult(20d) { subject.getWidth }
        assertResult(30d) { subject.getHeight }
      }
    }
  }
}
