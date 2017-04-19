package com.cart.bonus

import com.cart.Cart
import com.cart.products.{Orange, ThreeOrangesInPriceOfTwo}


case object ThreeOrangesBonus extends Bonus {
  def apply(promoStat: PromoStat, cart: Cart): Cart = {
    val xTimes = promoStat.get(Orange()) / 3
    cart.add(List.fill(xTimes)(ThreeOrangesInPriceOfTwo()))
  }
}
