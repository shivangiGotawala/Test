package example.com.shivangigotawalatest.Model

import com.google.gson.annotations.SerializedName

class Contact {
    @SerializedName("linked_in")
    var linked_in: String? = null
    @SerializedName("skype_id")
    var skype_id: String? = null
    @SerializedName("email")
    var email: String? = null
    @SerializedName("github")
    var github: String? = null
    @SerializedName("city")
    var city: String? = null
}
