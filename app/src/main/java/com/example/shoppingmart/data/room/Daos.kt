package com.example.shoppingmart.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Embedded
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.shoppingmart.data.room.models.ShoppingList
import com.example.shoppingmart.data.room.models.Store
import com.example.shoppingmart.data.room.models.Item
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: Item)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(item: Item)

    @Delete
    suspend fun delete(item:Item)

    @Query("select * from items")
    fun getAllItems(): Flow<List<Item>>

    @Query("select * from items where item_id=:itemId")
    fun getItem(itemId: Int): Flow<Item>
}

@Dao
interface StoreDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(store: Store)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(store: Store)

    @Delete
    suspend fun delete(store: Store)

    @Query("select * from stores")
    fun getAllStores(): Flow<List<Store>>

    @Query("select * from stores where store_id=:storeId")
    fun getItem(storeId: Int): Flow<Store>
}

@Dao
interface ListDao{
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertShoppingList(shoppingList: ShoppingList)

    @Query(
        """
        Select * from items as I inner join shopping_list as S
        on I.listId = S.list_id inner join stores as ST 
        on I.storeIdFk = ST.store_id
    """
    )
    fun getItemsWithStoreAndList(): Flow<List<ItemsWithStoreAndList>>

    @Query(
        """
        Select * from items as I inner join shopping_list as S
        on I.listId = S.list_id inner join stores as ST 
        on I.storeIdFk = ST.store_id where S.list_id = :listId
    """
    )
    fun getItemsWithStoreAndListFilteredById(listId: Int): Flow<List<ItemsWithStoreAndList>>

    @Query(
        """
        Select * from items as I inner join shopping_list as S
        on I.listId = S.list_id inner join stores as ST 
        on I.storeIdFk = ST.store_id where I.item_id = :itemId
    """
    )
    fun getItemWithStoreAndListFilteredById(itemId: Int): Flow<ItemsWithStoreAndList>
}

data class ItemsWithStoreAndList(
    @Embedded val item: Item,
    @Embedded val shoppingList: ShoppingList,
    @Embedded val store: Store
)