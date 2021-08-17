package br.com.juniorbraga.frameworkteste.ui.main

import br.com.juniorbraga.frameworkteste.model.Album
import br.com.juniorbraga.frameworkteste.model.Post
import br.com.juniorbraga.frameworkteste.model.ToDo
import br.com.juniorbraga.frameworkteste.service.EndPoint
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 *
 * @project Framework Teste
 * @author juniorbraga on 15/08/21.
 *
 **/
class MainModel(private val service: EndPoint): MainContract.Model {

    override fun getPost(): Observable<List<Post>> {
        return service.getPost()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }

    override fun getAlbum(): Observable<List<Album>> {
        return service.getAlbuns()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }

    override fun getToDo(): Observable<List<ToDo>> {
        return service.getToDos()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }
}