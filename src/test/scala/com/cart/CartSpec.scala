package com.cart

import org.scalatest.{FunSpec, Matchers}


class CartSpec extends FunSpec with Matchers {


  describe("Cart") {
    it("add products and submit total amount") {
      val cart = Cart()
      val apple1 = Apple()
      val twoOranges = Seq(Orange(), Orange())

      cart.checkout shouldBe 0

      val cart1 = cart.add(apple1)

      cart1.checkout() shouldBe apple1.price

      val cart2 = cart1.add(twoOranges)

      cart2.checkout() shouldBe (apple1.price + (Orange().price * 2))
    }
  }
}
