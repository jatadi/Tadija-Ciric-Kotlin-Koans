import TimeInterval.*

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int)

// Supported intervals that might be added to dates:
enum class TimeInterval { DAY, WEEK, YEAR }

// Class to represent a time interval with a multiplier
class RepeatedTimeInterval(val timeInterval: TimeInterval, val times: Int)

// Extension function to handle adding a single TimeInterval
operator fun MyDate.plus(timeInterval: TimeInterval): MyDate {
    return this.addTimeIntervals(timeInterval, 1)  // Add 1 unit of the interval
}

// Extension function to handle adding a RepeatedTimeInterval
operator fun MyDate.plus(repeatedTimeInterval: RepeatedTimeInterval): MyDate {
    return this.addTimeIntervals(repeatedTimeInterval.timeInterval, repeatedTimeInterval.times)
}

// Operator function to support multiplying a TimeInterval by an integer
operator fun TimeInterval.times(times: Int): RepeatedTimeInterval {
    return RepeatedTimeInterval(this, times)
}

// Test cases
fun task1(today: MyDate): MyDate {
    return today + YEAR + WEEK
}

fun task2(today: MyDate): MyDate {
    return today + YEAR * 2 + WEEK * 3 + DAY * 5
}
