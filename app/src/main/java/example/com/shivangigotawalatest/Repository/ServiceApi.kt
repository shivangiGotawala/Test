package example.com.shivangigotawalatest.Repository

import example.com.shivangigotawalatest.Model.Contacts
import example.com.shivangigotawalatest.Model.ServerData
import retrofit2.Call
import retrofit2.http.GET

interface ServiceApi {

    @get:GET("/contacts/")
    val contactInfo: Call<ServerData>
}
