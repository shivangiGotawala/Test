package example.com.shivangigotawalatest.Model;

import android.support.v4.app.ServiceCompat;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Work {
//    @SerializedName("item-work")
//    private List<ItemWork> itemWorkList;
//
//    public void setItemWorkList(List<ItemWork> itemWorkList) {
//        this.itemWorkList = itemWorkList;
//    }
//
//    public List<ItemWork> getItemWorkList() {
//        return itemWorkList;
//    }

    @SerializedName("start-date")
    private String startDate;
    @SerializedName("end-date")
    private String endDate;
    @SerializedName("position")
    private String position;
    @SerializedName("name")
    private String name;
    @SerializedName("city")
    private String city;
    @SerializedName("country")
    private String country;
    @SerializedName("description")
    private String description;
    @SerializedName("technologies")
    List<String> technologiesList;

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

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setTechnologiesList(List<String> technologiesList) {
        this.technologiesList = technologiesList;
    }

    public List<String> getTechnologiesList() {
        return technologiesList;
    }
}
