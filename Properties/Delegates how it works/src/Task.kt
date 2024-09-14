import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty
import java.util.Calendar

class D {
    var date: MyDate by EffectiveDate()
}

class EffectiveDate<R> : ReadWriteProperty<R, MyDate> {

    private var timeInMillis: Long? = null

    override fun getValue(thisRef: R, property: KProperty<*>): MyDate {
        val calendar = Calendar.getInstance()
        timeInMillis?.let {
            calendar.timeInMillis = it
            return MyDate(
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            )
        } ?: throw IllegalStateException("Date has not been initialized")
    }

    override fun setValue(thisRef: R, property: KProperty<*>, value: MyDate) {
        val calendar = Calendar.getInstance()
        calendar.set(value.year, value.month, value.dayOfMonth)
        timeInMillis = calendar.timeInMillis
    }
}
