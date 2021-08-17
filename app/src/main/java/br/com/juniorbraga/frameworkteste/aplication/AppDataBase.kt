package br.com.juniorbraga.frameworkteste.aplication

import androidx.room.Database
import androidx.room.RoomDatabase
import br.com.juniorbraga.frameworkteste.dao.AlbumDao
import br.com.juniorbraga.frameworkteste.dao.PostDao
import br.com.juniorbraga.frameworkteste.dao.ToDoDao
import br.com.juniorbraga.frameworkteste.model.Album
import br.com.juniorbraga.frameworkteste.model.Post
import br.com.juniorbraga.frameworkteste.model.ToDo

/**
 *
 * @project Framework Teste
 * @author juniorbraga on 16/08/21.
 *
 **/

@Database(version = 1, entities = arrayOf(Post::class,Album::class,ToDo::class))
abstract class AppDataBase : RoomDatabase() {
    abstract fun postDao(): PostDao
    abstract fun albumDao(): AlbumDao
    abstract fun toDoDao(): ToDoDao

}