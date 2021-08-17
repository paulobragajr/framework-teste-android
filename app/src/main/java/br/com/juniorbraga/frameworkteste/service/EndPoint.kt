package br.com.juniorbraga.frameworkteste.service

import br.com.juniorbraga.frameworkteste.model.Album
import br.com.juniorbraga.frameworkteste.model.Post
import br.com.juniorbraga.frameworkteste.model.ToDo
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 *
 * @project Framework Teste
 * @author juniorbraga on 14/08/21.
 *
 **/
interface EndPoint {

    @GET("albums")
    fun getAlbuns(): Observable<List<Album>>

    @GET("todos")
    fun getToDos(): Observable<List<ToDo>>

    @GET("posts")
    fun getPost(): Observable<List<Post>>
}