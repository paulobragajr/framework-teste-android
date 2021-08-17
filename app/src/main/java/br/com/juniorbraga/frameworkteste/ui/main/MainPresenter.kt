package br.com.juniorbraga.frameworkteste.ui.main

import android.util.Log
import br.com.juniorbraga.frameworkteste.aplication.App
import io.reactivex.disposables.CompositeDisposable

/**
 *
 * @project Framework Teste
 * @author juniorbraga on 15/08/21.
 *
 **/
class MainPresenter(private var model: MainContract.Model) : MainContract.Presenter {
    private lateinit var view: MainContract.View
    private val disposables = CompositeDisposable()

    override fun setView(view: MainContract.View) {
        this.view = view
    }

    override fun getService() {
        try{
            if(App.database?.postDao()?.getAll() == null ||
                App.database?.postDao()?.getAll()?.size!! == 0){
                this.getPost()
            }
            if(App.database?.albumDao()?.getAll() == null ||
                App.database?.albumDao()?.getAll()?.size!! == 0 ){
                this.getAlbum()
            }
            if(App.database?.toDoDao()?.getAll() == null ||
                App.database?.toDoDao()?.getAll()?.size!! == 0){
                this.getToDo()
            }
        }catch (e:Exception){
            Log.i("Error Data Base ", e.message.toString())
        }
    }

    fun getPost(){
        disposables.add(
            model.getPost()
                .subscribe(
                    { it ->
                        it.forEach {
                            App.database?.postDao()?.insertAll(it)
                        }
                    },
                    { it -> view.showError(it.message!!) }
                )
        )
    }

    fun getAlbum(){
        disposables.add(
            model.getAlbum()
                .subscribe(
                    { it ->
                        it.forEach {
                            App.database?.albumDao()?.insertAll(it)
                        }
                    },
                    { it -> view.showError(it.message!!) }
                )
        )
    }

    fun getToDo(){
        disposables.add(
            model.getToDo()
                .subscribe(
                    { it ->
                        it.forEach {
                            App.database?.toDoDao()?.insertAll(it)
                        }
                    },
                    { it -> view.showError(it.message!!) }
                )
        )
    }
}