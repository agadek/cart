package com.cart.bonus

import com.cart.products.{Apple, Orange}


object PriceSumHelper {

  def apply(apples: Int, oranges: Int) = (Apple().price * apples) + (Orange().price * oranges)
}
