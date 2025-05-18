package com.nathan.camistry.ui.hamburger

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import com.nathan.camistry.R
import com.nathan.camistry.model.MenuItem

class MenuAdapter(
    private val items: List<MenuItem>,
    private val onItemClick: (MenuItem) -> Unit
) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {
    inner class MenuViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val title: TextView = view.findViewById(R.id.tv_title)

        fun bind(item: MenuItem) {
            val iconSize = itemView.context.resources.getDimensionPixelSize(
                R.dimen.hamburger_menu_icon_size
            )
            val drawable = AppCompatResources.getDrawable(title.context, item.iconResId)
            drawable?.setBounds(0, 0, iconSize, iconSize)
            title.setCompoundDrawablesRelative(drawable, null, null, null)
            title.text = item.title
            title.contentDescription = item.title
            itemView.setOnClickListener { onItemClick(item) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.menu_item, parent, false)
        return MenuViewHolder(view)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}