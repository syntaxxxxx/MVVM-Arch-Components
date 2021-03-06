
package com.syntax.android.maps.ui.droplist

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.syntax.android.maps.R
import com.syntax.android.maps.app.inflate
import com.syntax.android.maps.model.Drop
import kotlinx.android.synthetic.main.list_item_drop.view.*


class DropListAdapter(private val drops: MutableList<Drop>, private val listener: DropListAdapterListener)
    : RecyclerView.Adapter<DropListAdapter.ViewHolder>(), ItemTouchHelperListener {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.list_item_drop))
    }

    override fun getItemCount() = drops.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(drops[position])
    }

    fun updateDrops(drops: List<Drop>) {
        this.drops.clear()
        this.drops.addAll(drops)
        notifyDataSetChanged()
    }

    fun removeDropAtPosition(position: Int) {
        drops.removeAt(position)
        notifyItemRemoved(position)
    }

    override fun onItemDismiss(viewHolder: RecyclerView.ViewHolder, position: Int) {
        listener.deleteDropAtPosition(drops[position], position)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private lateinit var drop: Drop

        fun bind(drop: Drop) {
            this.drop = drop
            itemView.message.text = drop.dropMessage
            itemView.latlng.text = drop.latLngString
        }
    }

    interface DropListAdapterListener {
        fun deleteDropAtPosition(drop: Drop, position: Int)
    }
}
