package br.com.juniorbraga.frameworkteste.ui.main.fragment.todo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.juniorbraga.frameworkteste.aplication.App
import br.com.juniorbraga.frameworkteste.model.ToDo

class ToDoViewModel : ViewModel() {

    private val _toDoList = MutableLiveData<List<ToDo>>().apply {
        value = App.database?.toDoDao()?.getAll()
    }

    val toDoList: LiveData<List<ToDo>> = _toDoList
}