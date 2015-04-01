package com.github.kkrull.scala.scalatraits

import org.scalatest._

class TraitSpec extends FunSpec with Matchers {
  describe("RayGun") {
    class DefaultRayGun extends RayGun {}
    val subject = new DefaultRayGun

    describe(".energize") {
      it("defaults to 'bang!'") {
        assertResult("bang!") { subject.energize }
      }
    }
  }

  describe("SpaceModulator") {
    val subject = new SpaceModulator
    
    describe(".energize") {
      it("discombobulates") {
        assertResult("discombobulate") { subject.energize }
      }
    }
  }
}
