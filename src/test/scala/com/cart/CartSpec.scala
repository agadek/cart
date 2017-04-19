package com.cart

import com.cart.bonus.PriceSumHelper
import com.cart.products.{Apple, Orange}
import org.scalatest.{FunSpec, Matchers}

class CartSpec extends FunSpec with Matchers {

  describe("Cart") {
    it("add products and submit total amount") {
      val cart = Cart()
      val apple1 = Apple()
      val twoOranges = Seq(Orange(), Orange())

      cart.checkout shouldBe PriceSumHelper(apples = 0, oranges = 0)

      val cart1 = cart.add(apple1)

      cart1.checkout() shouldBe PriceSumHelper(apples = 1, oranges = 0)

      val cart2 = cart1.add(twoOranges)

      cart2.checkout() shouldBe PriceSumHelper(apples = 1, oranges = 2)
    }
  }
}
