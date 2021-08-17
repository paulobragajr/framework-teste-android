package br.com.juniorbraga.frameworkteste.ui.main.fragment.post

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.juniorbraga.frameworkteste.aplication.App
import br.com.juniorbraga.frameworkteste.model.Post

class PostViewModel : ViewModel() {
    private val _postList = MutableLiveData<List<Post>>().apply {
        value = App.database?.postDao()?.getAll()
    }
    val postList: LiveData<List<Post>> = _postList
}