package br.com.juniorbraga.frameworkteste.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 *
 * @project Framework Teste
 * @author juniorbraga on 15/08/21.
 *
 **/

@Entity(tableName = "to_do_table")
data class ToDo (
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "userId") val userId: Int,
    @ColumnInfo(name = "title") val title: String?,
    @ColumnInfo(name = "body") val body: String?,
    @ColumnInfo(name = "completed") val completed: Boolean?
)