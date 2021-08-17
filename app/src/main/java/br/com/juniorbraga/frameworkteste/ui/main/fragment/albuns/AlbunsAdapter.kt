package br.com.juniorbraga.frameworkteste.ui.main.fragment.albuns

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.juniorbraga.frameworkteste.R
import br.com.juniorbraga.frameworkteste.model.Album
import br.com.juniorbraga.frameworkteste.ui.viewholder.GenericViewHolder

/**
 *
 * @project Framework Teste
 * @author juniorbraga on 17/08/21.
 *
 **/
class AlbunsAdapter(private var albumList: List<Album>,
                    private val context: Context?
) : RecyclerView.Adapter<GenericViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenericViewHolder {
        return GenericViewHolder(
            LayoutInflater.from(context).
        inflate(R.layout.generic_item, parent, false))
    }

    override fun onBindViewHolder(holder: GenericViewHolder, position: Int) {
        val album = albumList[position]
        holder.title.text = album.title
        holder.body.visibility = View.GONE
    }

    override fun getItemCount(): Int {
        return albumList.size
    }
}