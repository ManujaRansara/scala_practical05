object Fibonacci{
     

        def fibonacci(n: Int):Int ={
            n match {
            case 0 => 0
            case 1 => 1
            case _ => fibonacci(n - 1) + fibonacci(n - 2)
            }
        }
        def Sequence(n:Int): Unit = {
                if(n==0){
                    
                }else{
                    println(s"${fibonacci(n)}") 
                    Sequence(n-1)
                }
        }

        def main(args:Array[String]):Unit = {
                println("Enter the number of Fibonacci numbers to print: ")
                val n = scala.io.StdIn.readInt()
                println(s"The first $n Fibonacci numbers are:")
                Sequence(n)
        }


}