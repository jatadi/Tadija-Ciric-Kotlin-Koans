import Answer.*

enum class Answer { a, b, c }

val answers = mapOf<Int, Answer?>(
        1 to Answer.c,  // td is a function invocation
        2 to Answer.b,  // color is an argument name
        3 to Answer.b,  // it's a function literal (lambda)
        4 to Answer.c   // this refers to the receiver parameter TR of the function literal
)
