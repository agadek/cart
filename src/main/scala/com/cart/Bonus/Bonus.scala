package com.cart.bonus

import com.cart.Cart

trait Bonus {
  def apply(promoStat: PromoStat, cart: Cart): Cart
}
