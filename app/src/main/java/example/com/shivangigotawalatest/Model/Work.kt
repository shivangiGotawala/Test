package example.com.shivangigotawalatest.Model

import android.support.v4.app.ServiceCompat

import com.google.gson.annotations.SerializedName

class Work {
    @SerializedName("start-date")
    var startDate: String? = null
    @SerializedName("end-date")
    var endDate: String? = null
    @SerializedName("position")
    var position: String? = null
    @SerializedName("name")
    var name: String? = null
    @SerializedName("city")
    var city: String? = null
    @SerializedName("country")
    var country: String? = null
    @SerializedName("description")
    var description: String? = null
    @SerializedName("technologies")
    var technologiesList: List<String>? = null
}
