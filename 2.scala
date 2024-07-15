import scala.io.StdIn.readLine

case class Book(title: String, author: String, isbn: String)

object LibraryManagementSystem {


  var library: Set[Book] = Set(
    Book("Egypt call", "Dr.watson", "563"),
    Book("2001", "Author c.clerk", "456"),
    Book("Seeing ceylon", "Broheer", "512")
  )

  
  def addBook(book: Book): Unit = {
    library += book
    println(s"Added book: ${book.title}")
  }

  def removeBook(isbn: String): Unit = {
    library.find(_.isbn == isbn) match {
      case Some(book) =>
        library -= book
        println(s"Removed book: ${book.title}")
      case None =>
        println(s"No book found with ISBN: $isbn")
    }
  }

  def isBookInLibrary(isbn: String): Boolean = {
    library.exists(_.isbn == isbn)
  }

  def displayLibrary(): Unit = {
    if (library.isEmpty) {
      println("The library is empty.")
    } else {
      println("Current Library Collection:")
      library.foreach { book =>
        println(s"Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}")
      }
    }
  }


  def searchBookByTitle(title: String): Unit = {
    library.find(_.title.equalsIgnoreCase(title)) match {
      case Some(book) =>
        println(s"Book found: Title: ${book.title}, Author: ${book.author}, ISBN: ${book.isbn}")
      case None =>
        println(s"No book found with title: $title")
    }
  }


  def displayBooksByAuthor(author: String): Unit = {
    val booksByAuthor = library.filter(_.author.equalsIgnoreCase(author))
    if (booksByAuthor.isEmpty) {
      println(s"No books found by author: $author")
    } else {
      println(s"Books by $author:")
      booksByAuthor.foreach { book =>
        println(s"Title: ${book.title}, ISBN: ${book.isbn}")
      }
    }
  }

  def main(args: Array[String]): Unit = {
    var continue = true
    while (continue) {
      println("\nLibrary Management System")
      println("1. Display library collection")
      println("2. Add a new book")
      println("3. Remove a book by ISBN")
      println("4. Check if a book is in the library by ISBN")
      println("5. Search for a book by title")
      println("6. Display all books by an author")
      println("7. Exit")
      print("Enter your choice: ")

      readLine() match {
        case "1" =>
          displayLibrary()
        case "2" =>
          print("Enter book title: ")
          val title = readLine()
          print("Enter book author: ")
          val author = readLine()
          print("Enter book ISBN: ")
          val isbn = readLine()
          addBook(Book(title, author, isbn))
        case "3" =>
          print("Enter book ISBN to remove: ")
          val isbn = readLine()
          removeBook(isbn)
        case "4" =>
          print("Enter book ISBN to check: ")
          val isbn = readLine()
          if (isBookInLibrary(isbn)) {
            println(s"Book with ISBN $isbn is in the library.")
          } else {
            println(s"Book with ISBN $isbn is not in the library.")
          }
        case "5" =>
          print("Enter book title to search: ")
          val title = readLine()
          searchBookByTitle(title)
        case "6" =>
          print("Enter author name to display books: ")
          val author = readLine()
          displayBooksByAuthor(author)
        case "7" =>
          continue = false
          println("Exiting the system. Goodbye!")
        case _ =>
          println("Invalid choice. Please try again.")
      }
    }
  }
}
