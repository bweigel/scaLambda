package test

import org.scalatest.FlatSpec


class test_handler extends FlatSpec {

  "A test" should "say Test" in {
    val stack = "Test"
    assert(stack === "Test")
  }

}