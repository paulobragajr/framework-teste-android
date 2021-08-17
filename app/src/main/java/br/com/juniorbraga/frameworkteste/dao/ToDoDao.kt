package br.com.juniorbraga.frameworkteste.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.juniorbraga.frameworkteste.model.ToDo
import org.jetbrains.annotations.NotNull

/**
 *
 * @project Framework Teste
 * @author juniorbraga on 16/08/21.
 *
 **/


@Dao
interface ToDoDao {

    @NotNull
    @Insert
    fun insertAll(vararg toDo: ToDo)

    @Query("SELECT * FROM to_do_table")
    fun getAll(): List<ToDo>

}
