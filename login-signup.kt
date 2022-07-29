class User(val name:String, val email:String, val address:String? = null, val password:String){
    
}

val users = listOf(
    User(
        name="Ibrahim",
        email="i@ib.com",
        password="Sample1234"
    ),
    User(
        name="Yusuf",
        email="yusluv@ib.com",
        password="JustOneHere"
    )
)

fun main(args: Array<String>){

    // val users = listOf(
    //     User(
    //         name="Ibrahim",
    //         email="i@ib.com",
    //         password="Sample1234"
    //     ),
    //     User(
    //         name="Yusuf",
    //         email="yusluv@ib.com",
    //         password="JustOneHere"
    //     )
    // )

    println("Login or Signup (L/S)")
    val res = readLine()!!

    println(res)

    if(res == "L"){
        login()
    }else{
        signup()
    }
}

fun login(){
    println("Enter your email: ")
    val email = readLine()!!

    var res = FindUserByEmail(email)

    println("Enter your password")
    val password = readLine()!!


}


fun signup(){
    println("Signup")
}

fun FindUserByEmail(email:String): User?{
    var result:User? = null
    users.forEach{
        user -> 
        if(user.email == email)
            result = user
        else
            result = null
    }
    return result
}



