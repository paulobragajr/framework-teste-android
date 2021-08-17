package br.com.juniorbraga.frameworkteste.ui.main.fragment.todo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.juniorbraga.frameworkteste.databinding.FragmentToDoBinding
import br.com.juniorbraga.frameworkteste.model.ToDo
import kotlinx.android.synthetic.main.fragment_to_do.*

class ToDoFragment : Fragment() {

    private lateinit var toDoViewModel: ToDoViewModel
    private var _binding: FragmentToDoBinding? = null

    private val binding get() = _binding!!

    var toDoAdapter: ToDoAdapter? = null
    val toDoListUpdateObserver: Observer<List<ToDo>> =
        Observer<List<ToDo>> { toDoArrayList ->
            toDoAdapter = ToDoAdapter(toDoArrayList,this.context)
            rvToDo.setLayoutManager(LinearLayoutManager(this.context))
            rvToDo.setAdapter(this.toDoAdapter) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        toDoViewModel = ViewModelProvider(this).get(ToDoViewModel::class.java)
        _binding = FragmentToDoBinding.inflate(inflater, container, false)
        val root: View = binding.root

        this.toDoViewModel.toDoList?.observe(this.viewLifecycleOwner, this.toDoListUpdateObserver);
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}