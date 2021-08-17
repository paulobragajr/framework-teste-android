package br.com.juniorbraga.frameworkteste.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import br.com.juniorbraga.frameworkteste.model.Post
import org.jetbrains.annotations.NotNull

/**
 *
 * @project Framework Teste
 * @author juniorbraga on 15/08/21.
 *
 **/

@Dao
interface PostDao {

    @NotNull
    @Insert
    fun insertAll(vararg post: Post)

    @Query("SELECT * FROM post_table")
    fun getAll(): List<Post>

}
