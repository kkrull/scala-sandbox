package com.github.kkrull.scala.scalatraits

import java.awt.geom.Ellipse2D
import java.io.InputStream
import java.awt.Point

trait RectangleLike { this: Ellipse2D.Double =>
  def grow(x: Int, y: Int): Unit = {
    this.setFrame(this.getX, this.getY, this.getWidth + x, this.getHeight + y)
  }

  def translate(x: Int, y: Int): Unit = {
    this.setFrame(this.getX + x, this.getY + y, this.getWidth, this.getHeight)
  }

  def center: Unit = {
    this.setFrame(0, 0, this.getWidth, this.getHeight)
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

class OrderedPoint(x: Int, y: Int) extends Point(x, y) with Ordered[Point] {
  def compare(that: Point): Int = {
    def compareDouble(one: Double, other: Double) = {
      if(one < other) -1
      else if(one > other) 1
      else 0
    }

    val xComparison = compareDouble(getX, that.getX)
    if(xComparison != 0)
      xComparison
    else
      compareDouble(getY, that.getY)
  } 
}

//object Go extends App {
//  val base = new OrderedPoint(1, 2)
//  val array = Array(base)
//  scala.util.Sorting.quickSort(array)
//}
