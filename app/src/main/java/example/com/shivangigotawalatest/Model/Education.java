package example.com.shivangigotawalatest.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Education {
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
    private String title;
    @SerializedName("start-date")
    private String startDate;
    @SerializedName("end-date")
    private String endDate;
    @SerializedName("name")
    private String name;
    @SerializedName("city")
    private String city;
    @SerializedName("country")
    private String country;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }
}
