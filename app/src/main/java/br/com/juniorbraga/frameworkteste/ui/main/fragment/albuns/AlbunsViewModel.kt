package br.com.juniorbraga.frameworkteste.ui.main.fragment.albuns

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.juniorbraga.frameworkteste.aplication.App
import br.com.juniorbraga.frameworkteste.model.Album
import br.com.juniorbraga.frameworkteste.model.Post

class AlbunsViewModel : ViewModel() {

    private val _albunsList = MutableLiveData<List<Album>>().apply {
        value = App.database?.albumDao()?.getAll()
    }
    val albunsList: LiveData<List<Album>> = _albunsList
}