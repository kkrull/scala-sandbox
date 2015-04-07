package com.github.kkrull.scala.scalatraits

import java.awt.geom.Ellipse2D
import java.io.InputStream

trait RectangleLike { this: Ellipse2D.Double =>
  def grow(x: Int, y: Int): Unit = {
    this.setFrame(this.getX, this.getY, this.getWidth + x, this.getHeight + y)
  }

  def translate(x: Int, y: Int): Unit = {
    this.setFrame(this.getX + x, this.getY + y, this.getWidth, this.getHeight)
  }
}

trait BufferedInput extends InputStream { 
  private var buffer = Array[Int](-1, -1) 
  private var bufferIndex = buffer.length

  def bufferedRead: Int = {
    if(bufferIndex == buffer.length) {
      buffer(0) = read
      buffer(1) = read
      bufferIndex = 0
    }

    buffer(bufferIndex) //TODO KDK: Shouldn't this cause the second read to fail?  The index is not being incremented
  }
}
