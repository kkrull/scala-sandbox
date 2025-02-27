package com.github.kkrull.scala.scalatraits

import org.scalatest._

class RayGunSpec extends FunSpec with Matchers {
  class DefaultRayGun extends RayGun {}
  val subject = new DefaultRayGun

  describe(".energize") {
    it("defaults to 'bang!'") {
      assertResult("bang!") { subject.energize }
    }
  }
}

class SpaceModulatorSpec extends FunSpec with Matchers {
  val subject = new SpaceModulator

  describe(".energize") {
    it("discombobulates") {
      assertResult("discombobulate") { subject.energize }
    }
  }
}
