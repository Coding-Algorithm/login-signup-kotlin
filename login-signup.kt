class User(
        val name: String,
        val email: String,
        val address: String? = null,
        val password: String
) {}

val users =
        mutableListOf(
                User(name = "Ibrahim", email = "i@ib.com", password = "Sample1234"),
                User(name = "Yusuf", email = "yusluv@ib.com", password = "JustOneHere")
        )

fun main(args: Array<String>) {
    // val variable = 'f'
    // // println(variable.value.first().code)
    // println(variable.toInt())

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

    if (res == "L") {
        login()
    } else {
        signup()
    }
}

fun login() {
    println("Enter your email: ")
    val email = readLine()!!

    var res = FindUserByEmail(email)
    println("Enter your password")
    val password = readLine()!!

    if (password == res?.password) {
        println("Login Successfull")
        HomeScreen()
        return
    }

    println("Invalid Credentials")
    login()
}

fun signup() {
    var name = readLine()!!
    var email = readLine()!!
    var password = readLine()!!
    var address = readLine()!!

    // Authenticate
    while (name.length < 4) {
        println("Name can not be less than 4 characters long. \n Enter your name again")
        name = readLine()!!
    }

    while (email.length < 4) {
        println("Name can not be less than 4 characters long. \n Enter your name again: ")
        email = readLine()!!
    }

    while (FindUserByEmail(email) != null) {
        println("Email has been used. Kindly enter another email: ")
        email = readLine()!!
    }

    while (password.length < 8 || isPasswordValid(password) == false) {
        println("Invalid password. \n Kindly enter a geniune password")
        password = readLine()!!
    }

    users.add(User(name = name, email = email, password = password, address = address))

    print("Account Created. \n Login")
    login()
}

fun FindUserByEmail(email: String): User? {
    var result: User? = null
    users.forEach { user ->
        if (user.email == email) {
            result = user
            return result
        } else {
            result = null
        }
    }
    print(result)
    return result
}

fun isPasswordValid(password: String): Boolean {

    var result: Boolean
    var capitalCount: Int = 0
    var smallCount: Int = 0

    password.forEach { char ->
        when (char.toInt()) {
            in 65..90 -> capitalCount++
            in 97..122 -> smallCount++
        }
    }

    if (capitalCount == 0 || smallCount == 0) {
        result = false
    } else {
        result = true
    }

    return result
}

fun HomeScreen() {
    println("This is the home screen")
}
