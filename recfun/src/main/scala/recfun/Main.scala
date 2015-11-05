package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
    if(c < 0 || r < 0) {
      0
    }
    else if(c == r || c == 0 || r == 0) {
      1
    }
    else {
      pascal(c - 1, r - 1) + pascal(c, r - 1)
    }
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
    def findParens(chars: List[Char], rightParens: Int): Boolean = {
      if(chars.isEmpty) {
        rightParens == 0
      }
      else if(chars.head == '(') {
        findParens(chars.tail, rightParens + 1)
      }
      else if(chars.head == ')') {
        if(rightParens <= 0) {
          false
        }
        else {
          findParens(chars.tail, rightParens - 1)
        }
      }
      else {
        findParens(chars.tail, rightParens)
      }
    }
    findParens(chars, 0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if(coins.isEmpty || money < 0) {
      0
    }
    else if(money == 0) {
      1
    }
    else {
      countChange(money - coins.head, coins) + countChange(money, coins.tail)
    }
  }
}
