package example.com.shivangigotawalatest.Model

import com.google.gson.annotations.SerializedName

class Contacts {
    @SerializedName("name")
    var name: String? = null
    @SerializedName("email")
    var email: String? = null
    @SerializedName("gender")
    var gender: String? = null
    @SerializedName("phone")
    var phone: Phone? = null
}
