package com.cart.bonus

import com.cart.products.{Apple, Orange, Product}
import org.scalatest.{FunSpec, Matchers}


class PromoStatSpec extends FunSpec with Matchers {


  describe("Promo") {
    it("count cart stat") {
      val products: List[Product] = List(Orange(), Orange(), Orange(), Apple(), Apple())

      val promo = new PromoStat(products)

      promo.stat shouldBe Map(Orange() -> 3, Apple() -> 2)
    }
  }
}
