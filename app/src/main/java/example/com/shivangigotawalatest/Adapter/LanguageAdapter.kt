package example.com.shivangigotawalatest.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import example.com.shivangigotawalatest.Adapter.LanguageAdapter.MyHolder

import example.com.shivangigotawalatest.R


class LanguageAdapter(private val context: Context, private val languageList: List<String>?) : RecyclerView.Adapter<MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.lang_info_ist_row, parent, false)
        return MyHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val tech = StringBuffer(10)
        tech.append(languageList?.get(position))
        tech.append("\n")
        holder.tvLang!!.text = tech.toString()
    }

    override fun getItemCount(): Int {
        return languageList!!.size
    }

    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var tvLang: TextView? = null

        init {
            tvLang = itemView.findViewById(R.id.tv_lang)
        }
    }
}
