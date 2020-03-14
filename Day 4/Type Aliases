
// we can provide alternative name for a particular type eby using type aliases

typealias mList<T>  = MutableList<T>
// its even helpful to give a name that make more sense then original type name to your particular use
val numberList: mList<Int> = mutableListOf(1, 10, 2, 3, 4, 5, 6, 8)

// we can provide different aliases for function types

typealias FullName = (String , String ) -> String

val username : FullName  = {firstName, lastName -> firstName + lastName }

// Type aliases do not introduce new type, they are equivalent to underlying types
// in above example we we can  use FullName as type in our program but compiler always expands
// it to the (String, String) -> String 

fun main(){

    numberList.forEach{
        println(it)
    }

    val user = username("kotlin",".kt")
    println(user)

}
