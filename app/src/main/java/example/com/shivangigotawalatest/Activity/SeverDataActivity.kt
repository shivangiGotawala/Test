package example.com.shivangigotawalatest.Activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.Toast

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken

import org.json.JSONException
import org.json.JSONObject

import java.lang.reflect.Type
import java.util.ArrayList
import java.util.Arrays

import example.com.shivangigotawalatest.Adapter.ServerDataContactsAdapter
import example.com.shivangigotawalatest.Model.Contact
import example.com.shivangigotawalatest.Model.Contacts
import example.com.shivangigotawalatest.Model.ServerData
import example.com.shivangigotawalatest.R
import example.com.shivangigotawalatest.Repository.ApiClient
import example.com.shivangigotawalatest.Repository.ServiceApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SeverDataActivity : AppCompatActivity() {

    private var serviceApi: ServiceApi? = null
    private var rvContacts: RecyclerView? = null
    private var rvProgressBar: RelativeLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sever_data)

        rvContacts = findViewById(R.id.rv_contacts)
        rvProgressBar = findViewById(R.id.rv_progress)
        getContacts()

    }

    fun getContacts() {
        rvProgressBar!!.visibility = View.VISIBLE
        serviceApi = ApiClient.client.create(ServiceApi::class.java)
        val call = serviceApi!!.contactInfo
        call.enqueue(object : Callback<ServerData> {
            override fun onResponse(call: Call<ServerData>, response: Response<ServerData>) {
                rvProgressBar!!.visibility = View.GONE
                val serverData = response.body()
                val serverDataContactsAdapter = serverData!!.contacts?.let { ServerDataContactsAdapter(this@SeverDataActivity, it) }
                val mLayoutManager = LinearLayoutManager(applicationContext)
                rvContacts!!.layoutManager = mLayoutManager
                rvContacts!!.adapter = serverDataContactsAdapter
            }

            override fun onFailure(call: Call<ServerData>, t: Throwable) {
                Toast.makeText(this@SeverDataActivity, "Something went wrong", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
