package com.cart

import com.cart.bonus.{PriceSumHelper, SecondAppleBonus, ThreeOrangesBonus}
import com.cart.products.{Apple, Orange, Product}
import org.scalatest.{FunSpec, Matchers}


class CheckoutWithPromoSpec extends FunSpec with Matchers {

  val applesPromos = Seq(SecondAppleBonus)
  val orangesPromos = Seq(ThreeOrangesBonus)
  val allPromos = Seq(SecondAppleBonus,ThreeOrangesBonus)

  describe("SecondApple") {
    it("add bonus item if cart contains two apples") {
      val products: List[Product] = List(Orange(), Orange(), Orange(), Apple(), Apple())
      val cart = Cart().add(products)
      cart.checkout().toFloat shouldBe PriceSumHelper(apples = 2, oranges = 3).toFloat
      cart.checkoutWithPromo(applesPromos) shouldBe PriceSumHelper(apples = 1, oranges = 3)
    }
    it("not add bonus item if cart contains less then two apples") {
      val products: List[Product] = List(Orange(), Orange(), Orange(), Apple())
      val cart = Cart().add(products)
      cart.checkout() shouldBe PriceSumHelper(apples = 1, oranges = 3)
      cart.checkoutWithPromo(applesPromos) shouldBe PriceSumHelper(apples = 1, oranges = 3)
    }

    it("not add bonus item if cart contains more then two apples") {
      val products: List[Product] = List(Orange(), Orange(), Orange(), Apple(), Apple(), Apple())
      val cart = Cart().add(products)
      cart.checkout().toFloat shouldBe PriceSumHelper(apples = 3, oranges = 3).toFloat
      cart.checkoutWithPromo(applesPromos).toFloat shouldBe PriceSumHelper(apples = 3, oranges = 3).toFloat
    }

    it("add Three Orange bonus if cart contains three oranges") {
      val products: List[Product] = List(Orange(), Orange(), Orange())
      val cart = Cart().add(products)
      cart.checkout() shouldBe PriceSumHelper(apples = 0, oranges = 3)
      cart.checkoutWithPromo(orangesPromos).toFloat shouldBe PriceSumHelper(apples = 0, oranges = 2)
    }

    it("add Three Orange bonus twice if cart contains six oranges") {
      val products: List[Product] = List(Orange(), Orange(), Orange(), Orange(), Orange(), Orange())
      val cart = Cart().add(products)
      cart.checkout() shouldBe PriceSumHelper(apples = 0, oranges = 6)
      cart.checkoutWithPromo(orangesPromos).toFloat shouldBe PriceSumHelper(apples = 0, oranges = 4)
    }

    it("add both bonuses if conditions apply") {
      val products: List[Product] = List(Orange(), Orange(), Orange(), Apple(), Apple())
      val cart = Cart().add(products)
      cart.checkout().toFloat shouldBe PriceSumHelper(apples = 2, oranges = 3).toFloat
      cart.checkoutWithPromo(allPromos).toFloat shouldBe PriceSumHelper(apples = 1, oranges = 2).toFloat
    }


  }
}
