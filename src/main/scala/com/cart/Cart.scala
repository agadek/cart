package com.cart


case class Cart(list: List[Product] = List()) {

  def add(product: Product): Cart = copy(list :+ product)

  def add(products: Iterable[Product]): Cart = copy(list ++ products)

  def checkout(): Double = list.foldLeft(0d)((sum, product) => sum + product.price)

  def size():Int = list.size
}
