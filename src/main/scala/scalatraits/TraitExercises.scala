package com.github.kkrull.scala.scalatraits

import java.awt.geom._

trait RectangleLike {
  this: Ellipse2D.Double => 

    def translate(x: Int, y: Int): Unit = {
      this.setFrame(this.getX + x, this.getY + y, this.getWidth, this.getHeight )
    }
}
