package com.github.kkrull.scala.scalatraits

import org.scalatest._
import java.awt.geom.Ellipse2D
import java.io.ByteArrayInputStream
import java.io.InputStream

class RectangleLikeSpec extends FunSpec with Matchers {
  describe(".translate") {
    trait Fixture {
      val subject = new Ellipse2D.Double(1, 2, 4, 8) with RectangleLike
      info("Translating")
      subject.translate(16, -32)
    }

    it("moves the object by the specified number of pixels in each dimension") {
      new Fixture {
        subject.getX shouldEqual 17d
        subject.getY shouldEqual -30d
      }
    }
    it("maintains the same size") {
      new Fixture {
        subject.getWidth shouldEqual 4d
        subject.getHeight shouldEqual 8d
      }
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

class BufferedInputSpec extends FunSpec with Matchers {
  describe(".read") {
    describe("when the buffer is empty") {
      class InputStreamSpy extends InputStream {
        private var _numReads: Int = 0
        def numReads = _numReads

        def read: Int = {
          _numReads = _numReads + 1
          4
        }
      }

      val subject = new InputStreamSpy with BufferedInput       

      it("calls InputStream.read enough times to fill the buffer") {
        subject.read
        subject.numReads should equal(2)
      }
    }

    describe("when the stream has more data") {
      it("returns the next byte in the stream") {
        val subject = new ByteArrayInputStream(Array[Byte](42, 43)) with BufferedInput
        subject.read should equal(42)
        subject.read should equal(43)
      }
    }

    describe("when the stream is exhausted") {
      it("returns -1") {
        val subject = new ByteArrayInputStream(Array[Byte]()) with BufferedInput
        subject.read should equal(-1) 
      }
    }
  }
}
