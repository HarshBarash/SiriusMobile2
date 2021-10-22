package harshbarash.github.siriustwo.data

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

interface OrderDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addOrder (order: Order)

    @Query("SELECT * FROM order_table ORDER BY ID asc")
    fun readAllData(): LiveData<List<Order>>
}