package com.cart.bonus

import com.cart.Cart
import com.cart.products.{Apple, OneAppleSecondFree}

case object SecondAppleBonus extends Bonus {
  def apply(promoStat: PromoStat, cart: Cart): Cart =
    if (promoStat.get(Apple()) == 2) cart.add(OneAppleSecondFree())
    else cart
}
