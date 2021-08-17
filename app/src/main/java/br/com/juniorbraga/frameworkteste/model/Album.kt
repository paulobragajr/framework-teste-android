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
@Entity(tableName = "album_table")
data class Album (
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "userId") val userId: Int,
    @ColumnInfo(name = "title") val title: String?,
)