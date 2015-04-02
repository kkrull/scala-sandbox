package com.github.kkrull.scala.scalatraits

import java.awt.geom._

trait RectangleLike { this: Ellipse2D.Double =>
  def grow(x: Int, y: Int): Unit = {
    this.setFrame(this.getX, this.getY, this.getWidth + x, this.getHeight + y)
  }

  def translate(x: Int, y: Int): Unit = {
    this.setFrame(this.getX + x, this.getY + y, this.getWidth, this.getHeight)
  }
}