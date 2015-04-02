package com.github.kkrull.scala.scalatraits

import org.scalatest._
import java.awt.geom.Ellipse2D

class RectangleLikeSpec extends FunSpec with Matchers {
  describe(".translate") {
    val subject = new Ellipse2D.Double(1, 2, 4, 8) with RectangleLike
    subject.translate(16, -32)

    it("moves the object by the specified number of pixels in each dimension") {
      subject.getX shouldEqual 17d
      subject.getY shouldEqual -30d
    }
    it("maintains the same size") {
      subject.getWidth shouldEqual 4d
      subject.getHeight shouldEqual 8d
    }
  }

  describe(".grow") {
    val subject = new Ellipse2D.Double(1, 2, 4, 8) with RectangleLike
    subject.grow(16, 32)

    it("does not move the object") {
      subject.getX shouldEqual 1
      subject.getY shouldEqual 2
    }
    it("changes the side by the amount specified for each dimension") {
      subject.getWidth shouldEqual 20
      subject.getHeight shouldEqual 40
    }
  }
}
