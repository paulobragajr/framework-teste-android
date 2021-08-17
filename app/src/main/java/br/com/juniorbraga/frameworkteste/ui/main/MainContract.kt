package br.com.juniorbraga.frameworkteste.ui.main

import br.com.juniorbraga.frameworkteste.model.Album
import br.com.juniorbraga.frameworkteste.model.Post
import br.com.juniorbraga.frameworkteste.model.ToDo
import io.reactivex.Observable
import okhttp3.ResponseBody

/**
 *
 * @project Framework Teste
 * @author juniorbraga on 14/08/21.
 *
 **/
interface MainContract {

    interface Model {
        fun getPost(): Observable<List<Post>>
        fun getAlbum(): Observable<List<Album>>
        fun getToDo(): Observable<List<ToDo>>
    }

    interface View {
        fun showError(error: String)
    }

    interface Presenter {
        fun setView(view: View)
        fun getService()
    }
}