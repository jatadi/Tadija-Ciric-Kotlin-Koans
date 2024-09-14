class DateRange(val start: MyDate, val end: MyDate) : Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> {
        return object : Iterator<MyDate> {
            var currentDate = start

            override fun hasNext(): Boolean {
                return currentDate <= end
            }

            override fun next(): MyDate {
                val result = currentDate
                currentDate = currentDate.followingDate()  // Assuming MyDate.followingDate() is available
                return result
            }
        }
    }
}

fun iterateOverDateRange(firstDate: MyDate, secondDate: MyDate, handler: (MyDate) -> Unit) {
    for (date in DateRange(firstDate, secondDate)) {
        handler(date)
    }
}
