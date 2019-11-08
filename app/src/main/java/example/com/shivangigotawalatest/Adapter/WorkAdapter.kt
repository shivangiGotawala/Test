package example.com.shivangigotawalatest.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import example.com.shivangigotawalatest.Adapter.WorkAdapter.MyHolder

import example.com.shivangigotawalatest.Model.Work
import example.com.shivangigotawalatest.R

class WorkAdapter(private val context: Context, private val workList: List<Work>?) : RecyclerView.Adapter<MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.work_info_ist_row, parent, false)
        return MyHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val work = workList?.get(position)
        holder.tvposition.text = work!!.position
        holder.tvWorkName.text = work.name
        holder.tvWorkStartDate.text = work.startDate
        holder.tvWorkEndDate.text = work.endDate
        holder.tvWorkCity.text = work.city
        holder.tvWorkCountry.text = work.country
        holder.tvWorkDesc.text = work.description
        val tech = StringBuffer(10)
        for (i in 0 until work.technologiesList!!.size) {
            tech.append(work.technologiesList?.get(i))
            tech.append("\n")
        }
        holder.tvWorkTech.text = tech.toString()

        if (workList!!.size - 1 > position) {
            holder.view.visibility = View.VISIBLE
        } else {
            holder.view.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int {
        return workList!!.size
    }

    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var tvposition: TextView
        internal var tvWorkName: TextView
        internal var tvWorkStartDate: TextView
        internal var tvWorkEndDate: TextView
        internal var tvWorkCity: TextView
        internal var tvWorkCountry: TextView
        internal var tvWorkDesc: TextView
        internal var tvWorkTech: TextView
        internal var view: View

        init {

            view = itemView.findViewById(R.id.view)
            tvposition = itemView.findViewById(R.id.tv_work_position)
            tvWorkName = itemView.findViewById(R.id.tv_work_name)
            tvWorkStartDate = itemView.findViewById(R.id.tv_work_start_dt)
            tvWorkEndDate = itemView.findViewById(R.id.tv_work_end_dt)
            tvWorkCity = itemView.findViewById(R.id.tv_work_city)
            tvWorkCountry = itemView.findViewById(R.id.tv_work_country)
            tvWorkDesc = itemView.findViewById(R.id.tv_work_description)
            tvWorkTech = itemView.findViewById(R.id.tv_work_tech)
        }
    }
}
