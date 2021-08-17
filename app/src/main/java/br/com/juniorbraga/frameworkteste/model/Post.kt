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

@Entity(tableName = "post_table")
data class Post (
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "Int") val userId: Int,
    @ColumnInfo(name = "title") val title: String?,
    @ColumnInfo(name = "body") val body: String?
)