import scala.io.StdIn.readLine

object Inventory {
  
  var inventories : List[String]= List()

  
  def getProductList(): Unit = {
    var product = ""
    println("Enter the Product name:")
    
    while (product != "done") {
      product = readLine()
      if (product != "done") {
        inventories = inventories :+ product
      }
    }
  }

  def printProductList(list: List[String]): Unit = {
    for ((product, index) <- list.zipWithIndex) {
      println(s"${index + 1}. $product")
    }
  }

  def getTotalProducts(list: List[String]): Int = list.length

  def main(args: Array[String]): Unit = {
    getProductList()
    println("\nProduct List:")
    printProductList(inventories)
    println(s"\nTotal number of products: ${getTotalProducts(inventories)}")
  }
}
