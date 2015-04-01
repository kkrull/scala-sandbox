package com.github.kkrull.scala.scalatraits

class SpaceModulator extends RayGun {
  def energize: String = "discombobulate"
}

trait RayGun {
  def energize: String
}
