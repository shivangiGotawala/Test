package example.com.shivangigotawalatest.Model

import com.google.gson.annotations.SerializedName

class ServerData {
    @SerializedName("contacts")
    var contacts: List<Contacts>? = null
}
