package example.com.shivangigotawalatest.Adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import example.com.shivangigotawalatest.Model.Contacts
import example.com.shivangigotawalatest.R

class ServerDataContactsAdapter(private val context: Context, private val contactList: List<Contacts>) : RecyclerView.Adapter<ServerDataContactsAdapter.MyHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.contacts_list, parent, false)
        return MyHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val contacts = contactList[position]
        holder.tvName.text = contacts.name
        holder.tvEmail.text = contacts.email
        holder.tvGender.text = contacts.gender
        holder.tvMobile.text = contacts.phone!!.mobile
    }

    override fun getItemCount(): Int {
        return contactList.size
    }

    inner class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var tvName: TextView
        internal var tvEmail: TextView
        internal var tvGender: TextView
        internal var tvMobile: TextView

        init {

            tvName = itemView.findViewById(R.id.tv_name)
            tvEmail = itemView.findViewById(R.id.tv_email)
            tvGender = itemView.findViewById(R.id.tv_gender)
            tvMobile = itemView.findViewById(R.id.tv_mobile)
        }
    }
}
