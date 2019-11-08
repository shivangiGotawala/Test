package example.com.shivangigotawalatest.Model

import com.google.gson.annotations.SerializedName

class Education {
    //    @SerializedName("item-education")
    //    private List<ItemEducation> itemEducationList;
    //
    //    public void setItemEducationList(List<ItemEducation> itemEducationList) {
    //        this.itemEducationList = itemEducationList;
    //    }
    //
    //    public List<ItemEducation> getItemEducationList() {
    //        return itemEducationList;
    //    }

    @SerializedName("title")
    var title: String? = null
    @SerializedName("start-date")
    var startDate: String? = null
    @SerializedName("end-date")
    var endDate: String? = null
    @SerializedName("name")
    var name: String? = null
    @SerializedName("city")
    var city: String? = null
    @SerializedName("country")
    var country: String? = null
}
