package com.cart.bonus

import com.cart.Cart
import com.cart.products._
import org.scalatest.{FunSpec, Matchers}


class ThreeOrangeBonusSpec extends FunSpec with Matchers {


  describe("ThreeOrangeBonus") {
    it("add bonus item if cart contains three oranges ") {
      val products: List[Product] = List(Orange(), Orange(), Orange(), Apple(), Apple())

      val cart = Cart().add(products)
      val promoStat = new PromoStat(cart.list)

      val newCart = ThreeOrangesBonus(promoStat, cart)

      newCart.list.contains(ThreeOrangesInPriceOfTwo()) shouldBe true
    }
    it("add bonus item if cart contains nine oranges ") {
      val products: List[Product] = List(Orange(), Orange(), Orange(), Orange(), Orange(), Orange(), Orange(), Orange(), Orange())

      val cart = Cart().add(products)
      val promoStat = new PromoStat(cart.list)

      val newCart = ThreeOrangesBonus(promoStat, cart)

      newCart.list.count {
        case e: ThreeOrangesInPriceOfTwo => true
        case _ => false
      } shouldBe 3
    }
  }
}
