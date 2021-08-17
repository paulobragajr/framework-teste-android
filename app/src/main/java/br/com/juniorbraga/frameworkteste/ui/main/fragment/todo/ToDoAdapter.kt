package br.com.juniorbraga.frameworkteste.ui.main.fragment.todo

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.juniorbraga.frameworkteste.R
import br.com.juniorbraga.frameworkteste.model.ToDo
import kotlinx.android.synthetic.main.to_do_item.view.*

/**
 *
 * @project Framework Teste
 * @author juniorbraga on 17/08/21.
 *
 **/
class ToDoAdapter (private var toDoList: List<ToDo>,
                   private val context: Context?
) : RecyclerView.Adapter<ToDoAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivCheck = itemView.ivCheck
        val title = itemView.title
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).
        inflate(R.layout.to_do_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val toDo = toDoList[position]
        holder.title.text = toDo.title

        if(toDo.completed!!){
            holder.title.setTextColor(Color.LTGRAY)
            holder.ivCheck.visibility = View.VISIBLE
        } else {
            holder.title.setTextColor(Color.BLACK)
            holder.ivCheck.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int {
        return toDoList.size
    }
}

