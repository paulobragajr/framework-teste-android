package br.com.juniorbraga.frameworkteste.ui.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.generic_item.view.*

/**
 *
 * @project Framework Teste
 * @author juniorbraga on 17/08/21.
 *
 **/
class GenericViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val card = itemView.card
    val title = itemView.title
    val body = itemView.body
}
