package com.cart.bonus

import com.cart.Cart
import com.cart.products.{Apple, OneAppleSecondFree, Orange, Product}
import org.scalatest.{FunSpec, Matchers}


class SecondAppleBonusSpec extends FunSpec with Matchers {


  describe("SecondAppleBonus") {
    it("add bonus item if cart contains two apples") {
      val products: List[Product] = List(Orange(), Orange(), Orange(), Apple(), Apple())

      val cart = Cart().add(products)
      val promoStat = new PromoStat(cart.list)

      val newCart = SecondAppleBonus(promoStat, cart)

      newCart.list.contains(OneAppleSecondFree()) shouldBe true
    }
  }
}
