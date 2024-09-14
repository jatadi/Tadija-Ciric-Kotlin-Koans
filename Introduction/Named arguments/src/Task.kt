fun joinOptions(options: Collection<String>): String {
        return "[${options.joinToString(separator = ", ",
                prefix= "",
                postfix = "",)}]"
}
