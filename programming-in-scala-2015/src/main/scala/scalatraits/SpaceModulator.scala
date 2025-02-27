package com.github.kkrull.scala.scalatraits

class SpaceModulator extends RayGun {
  override def energize: String = "discombobulate"
}

trait RayGun {
  def energize: String = "bang!"
}
