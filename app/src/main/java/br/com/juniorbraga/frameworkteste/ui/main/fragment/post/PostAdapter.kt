package br.com.juniorbraga.frameworkteste.ui.main.fragment.post

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.juniorbraga.frameworkteste.R
import br.com.juniorbraga.frameworkteste.model.Post
import br.com.juniorbraga.frameworkteste.ui.viewholder.GenericViewHolder

/**
 *
 * @project Framework Teste
 * @author juniorbraga on 16/08/21.
 *
 **/

class PostAdapter(private var postList: List<Post>,
                  private val context: Context?
) : RecyclerView.Adapter<GenericViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder {
        return GenericViewHolder(LayoutInflater.from(context).
        inflate(R.layout.generic_item, parent, false))
    }

    override fun onBindViewHolder(holder: GenericViewHolder, position: Int) {
        val post = postList[position]
        holder.title.text = post.title
        holder.body.text = post.body
    }

    override fun getItemCount(): Int {
        return postList.size
    }
}

