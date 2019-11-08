package example.com.shivangigotawalatest.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

import example.com.shivangigotawalatest.Model.Education
import example.com.shivangigotawalatest.R

class EducationAdapter(private val context: Context, private val educationListList: List<Education>?) : RecyclerView.Adapter<EducationAdapter.MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.main_info_ist_row, parent, false)

        return MyHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val education = educationListList?.get(position)
        holder.tvTitle.text = education!!.title
        holder.tvEduStartDate.text = education.startDate
        holder.tvEduEndDate.text = education.endDate
        holder.ttvEduName.text = education.name
        holder.tvEduCity.text = education.city
        holder.tvEduCountry.text = education.country
        if (educationListList!!.size - 1 > position) {
            holder.view.visibility = View.VISIBLE
        } else {
            holder.view.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int {
        return educationListList!!.size
    }

    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var llTitle: LinearLayout
        internal var llStartDate: LinearLayout
        internal var llEndDate: LinearLayout
        internal var llName: LinearLayout
        internal var llCity: LinearLayout
        internal var llCoutry: LinearLayout
        internal var tvTitle: TextView
        internal var tvEduStartDate: TextView
        internal var tvEduEndDate: TextView
        internal var ttvEduName: TextView
        internal var tvEduCity: TextView
        internal var tvEduCountry: TextView
        internal var view: View

        init {

            view = itemView.findViewById(R.id.view)
            llTitle = itemView.findViewById(R.id.ll_title)
            llStartDate = itemView.findViewById(R.id.ll_edu_start_dt)
            llEndDate = itemView.findViewById(R.id.ll_edu_end_date)
            llName = itemView.findViewById(R.id.ll_edu_name)
            llCity = itemView.findViewById(R.id.ll_edu_city)
            llCoutry = itemView.findViewById(R.id.ll_edu_country)
            tvTitle = itemView.findViewById(R.id.tv_edu_title)
            tvEduStartDate = itemView.findViewById(R.id.tv_edu_start_dt)
            tvEduEndDate = itemView.findViewById(R.id.tv_edu_end_dt)
            ttvEduName = itemView.findViewById(R.id.tv_edu_name)
            tvEduCity = itemView.findViewById(R.id.tv_edu_city)
            tvEduCountry = itemView.findViewById(R.id.tv_edu_country)
        }
    }
}

