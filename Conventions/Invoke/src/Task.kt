class Invokable {
    var numberOfInvocations: Int = 0
        private set

    // Implementing the invoke operator function
    operator fun invoke(): Invokable {
        numberOfInvocations++  // Increment the counter each time it's invoked
        return this            // Return the object itself for chaining
    }
}

fun invokeTwice(invokable: Invokable) = invokable()()
