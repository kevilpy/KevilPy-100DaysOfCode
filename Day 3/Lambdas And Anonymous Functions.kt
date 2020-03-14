// Anonymous functions
/** Anonymous function is function that don't have any name.
 * or in simple word a function without name is called anonymous function
 */

// Lambda Expression
/**
 * we can say that lambda expression is the anonymous function
 */
// so lets create lambda expression

val lambdaOne = {println("hey im lambda expression")} // its a lambda expression
// voila we have created our first lambda lets use it in main() function

// okay so now we know how to invoke lambda expression
// lets talk about its syntax
// { arguments  -> code body }
// uhmmm so as we know lambda expression is anonymous function and function  may take arguments
// and also may return and lambda expression can also take arguments and return

/**
 * all we need to know is these lambda syntax rules
 * On the left side of '->' operator we define arguments and every argument is separated by ','
 * and On the right side of the '->' operator we define our code.
 * and the last expression of your code body is treated as  return value
 * okay lets do this in practice
 */
val printInfo  = {name: String, age: Int -> println("Name is $name and Age is $age")}
// as you can see name and age are on left side of '->' and they will be treated as arguments
// we have t specify the type of the arguments as the compiler has no mean to infer the type of argument

//  lets write above lambda expression in different way
val printInfoTwo: (Int, String) -> Unit = {name, age -> println("$name and $age ")}
// its same as printInfo but here we omitted the type notion of arguments
// because now compiler can infer the information about its argument type from the type notation of lambda
// (Int, Int) - unit type notation or type of this lambda

// lets  break it down
// remember this pattern (input) -> output
// inside parenthesis ( we write the type of the arguments that we have used inside the lambda expression )
// and after '->' operator we define the return type

//example
val lambdaThree: (Int, Int) -> Unit = {numberOne, numberTwo -> println(numberOne + numberTwo) }
// so we have defined (Int, Int) the first and second argument is of Int type
// or if you like maths then (whispering: nobody do...) we can say
// (type of first argument,  type of second argument ,....., type of n Argument)
// on the right hand side of '->' operator we define return type .which is unit in our case
// mean it returns nothing its like void in other programing language

// lets create lambda which returns something
val fullName: (String, String ) -> String ={firstName, lastName ->
    println("this is lambda expression to return full name  ")
    "$firstName $lastName" // remember the last expression is used as return type
}

// In the above lambda expression the last expression of the code body is used as return type
// and one more thing  return keyword is not allowed in lambda expression
// so if you want to return something  put it in the last of the code body in lambda expression

// lambda expression can also be used as class extension or function extension
// i wish if there is a function or method in String Class that remove a particular character from it
// oh we there no such function we can create one using lambda expression

val removeChar : String.(Char) -> String ={removeChar ->
    val oldString : String = this // here this refers to the type on which we are extending this lambda
    var newString: String = ""
    for (char in oldString){
        if (char == removeChar ){
            continue
        }

        newString += char
    }

    newString
}

// i know time complexity is o(n) or linear
// but its just an example for illustrating lambda expression as class

// one more thing to know if you lambda expression has only single argument for eg.
val lambdaFour: (Int)-> String  = {number -> number.toString()}
// here number is the only argument in lambda expression
// so if we have only single argument to deal with we can omit the argument name
// and we will be  referring to this argument by implicit name 'it'

val lambdaFive: (Int)-> String = {it.toString()}
// here it refer to the  only single argument we have used in this lambda


// okay  so we have enough talked about lambda expression now lets talk about anonymous function
// Anonymous function
// anonymous function looks like the function but it does'nt have any name
// rest of the signature is same

val testSumOne = fun(numberOne: Int, numberTwo: Int): Int{
    return numberOne + numberTwo
}
//return type is inferred  if it is an expression (same as normal function)
val testSumTwo  = fun(numberOne: Int, numberTwo: Int) = numberOne + numberTwo //function as expression


// we can omit the type of the parameters if it can be inferred from the context
// but we have to define return type explicitly if function has body as code blocks({.....})
val testSumThree: (Int, Int) -> Int = fun(numberOne, numberTwo): Int { // here we have defined return type two time this is weird
    return numberOne + numberTwo
}

// anonymous sum function (best way)
val sum =  fun(numberOne: Int, numberTwo: Int) = numberOne + numberTwo
// umm that looks awesome


// so whats the difference between lambda and anonymous functions
// they both have same type so whats the difference
// the key difference is
// in anonymous function we can use return keyword
// and can return from any where from the body of function
// where as we can only return from enclosing function2 or the last value or expression will be returned
// in lambda expression
//so there is so many scenarios where we want to return not only from enclosing function or in the last of body
// but also from different part of the body

// and this is the main reason we have two different signature for lambdas and anonymous functions

fun main(){


    // okay so lets use our very dashing, shining newly created lambda
    lambdaOne() // yup that's one way to call your lambda

    //or we can use lambda method invoke() to call or execute whatever code is written inside lambda expression
    lambdaOne.invoke()


    //using lambda extension as class extension or function extension
    val fruit: String = "banana" //uhhh banana has multiple 'a' lets remove all of
    println(fruit.removeChar('a'))

    // see we have called removeChar() as it's a method of string type.
    // that's how lambda can be used as class extension

    // example of filter lambda which takes only single parameter
    val numberList: List<Int> = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println(numberList.filter{
        it > 3
    })

    // using anonymous function sum
    println(sum(1, 2))

}


