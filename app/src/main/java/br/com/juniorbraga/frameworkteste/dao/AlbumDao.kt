package br.com.juniorbraga.frameworkteste.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import br.com.juniorbraga.frameworkteste.model.Album
import org.jetbrains.annotations.NotNull

/**
 *
 * @project Framework Teste
 * @author juniorbraga on 16/08/21.
 *
 **/

@Dao
interface AlbumDao {

    @NotNull
    @Insert
    fun insertAll(vararg album: Album)

    @Query("SELECT * FROM album_table")
    fun getAll(): List<Album>

}
