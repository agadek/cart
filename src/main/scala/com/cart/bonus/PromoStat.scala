package com.cart.bonus

import com.cart.products

class PromoStat(list: List[products.Product]) {

  val stat = list.foldLeft(Map[products.Product, Int]()) {
    (acc, product) =>
      acc + (product -> (acc.getOrElse(product, 0) + 1))
  }

  def get(product: products.Product) = stat.getOrElse(product, 0)
}
