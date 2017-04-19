package com.cart

import com.cart.bonus.{Bonus, PromoStat}
import products._

case class Cart(list: List[Product] = List()) {

  def add(product: products.Product): Cart = copy(list :+ product)

  def add(products: Iterable[Product]): Cart = copy(list ++ products)

  def checkoutWithPromo(promo: Iterable[Bonus]): Double = {
    val promoStat = new PromoStat(list)

    promo.foldLeft(this)((cart, bonus) => bonus.apply(promoStat, cart)).checkout()
  }

  def checkout(): Double = list.foldLeft(0d)((sum, product) => sum + product.price)

  def size(): Int = list.size
}



