// creating a box that can store Int type values
class IntBox(integer : Int){
    val value = integer
}

 /** What if we want a class  or data structure that can store or work not just Int type objects or instances
  * but can work with  any type of objects and instances
  * That's where generics came to the picture */

// Creating a generic class that can work with any Type of objects or instances
 class Box<T>(value: T) {
     val mValue = value

 }

fun main(){

    // creating object of the generic box class
    // To create a instance or object of the generic class we need to provide the type argument <Int>, <String>

    val boxOne: Box<String> = Box("im a string ")
    // or
    val boxTwo = Box<String>("im another string")

    // but but but we can omit this type argument if the type is inferred from the constructor arguments or by some other means
    val boxThree = Box(10.0)

    // creating a list of type string and int to test the printAllItemInList function
    val fruits: List<String> = listOf("apple", "mango", "banana", "grapes")
    val numbers: List<Int> = listOf(1, 2, 3, 4, 5, 6, 7, 9, 0)

    //passing the list (fruits) of string type  to the function printAllItemsInList
    printAllItemsInList(fruits)
    //passing the list (numbers) of int type to the function printAllItemsInList
    printAllItemsInList(numbers)

    // Testing generics extension function
    val number = 1
    val thought = "kotlin is Awesome "
    val modifiedString = thought.addString(number)
    println(modifiedString)

    // Testing search function which is also generics and has Comparable<T> upper bond constraint
    search(1) // 1 is Int and it is subtype of comparable class
    //search(boxOne) // as the boxOne is instance of Box class and Box Class is not subtype of comparable class thus won't compile



}

// function can also be generics or we can say that functions can also have type parameter <T>
// Type parameters in functions are placed before the function name
fun <T> printAllItemsInList(list: List<T>) { // now it can accept any type of list weather its a integer list  List<Int> or any other list
    for (item in list){
        print("$item ")
    }
    println()
}

// also we can create generic extension function
fun <T> String.addString(t: T): String {
    return "$this ${t.toString()}" // just adding the to toString representation of any type of object with current string
}

// so we can take any type of object or instance as argument and can work with it
// but what if we  want to restrict some types and make it more specific to limited types

    // Generics Constraints
    // the most common type of constraints is Upper Bound

fun <T: Comparable<T>> search(value: T){ } // Now in this case we can only pass the subtype of Comparable class
// eg Int is subtype of Comparable class, String is a subtype of comparable Class

