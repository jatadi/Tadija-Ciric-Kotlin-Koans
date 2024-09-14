class LazyProperty(initializer: () -> Int) {

    private var _lazy: Int? = null
    private val initializer = initializer

    val lazy: Int
        get() {
            if (_lazy == null) {
                _lazy = initializer()
            }
            return _lazy!!
        }
}
