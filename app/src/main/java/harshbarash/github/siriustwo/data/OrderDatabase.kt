package harshbarash.github.siriustwo.data

import android.content.Context
import android.os.strictmode.InstanceCountViolation
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Order::class], version = 1, exportSchema = false)
abstract class OrderDatabase: RoomDatabase() {

    abstract fun orderDao(): OrderDao

    companion object{
        @Volatile
        private var INSTANCE: OrderDatabase? =  null

        fun getDatabase(context: Context): OrderDatabase{
            val tempInstance = INSTANCE
            if (tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    OrderDatabase::class.java,
                    "order_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}