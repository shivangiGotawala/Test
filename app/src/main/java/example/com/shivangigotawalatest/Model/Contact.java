package example.com.shivangigotawalatest.Model;

import com.google.gson.annotations.SerializedName;

public class Contact {
    @SerializedName("linked_in")
    private String linked_in;
    @SerializedName("skype_id")
    private String skype_id;
    @SerializedName("email")
    private String email;
    @SerializedName("github")
    private String github;
    @SerializedName("city")
    private String city;

    public void setLinked_in(String linked_in) {
        this.linked_in = linked_in;
    }

    public String getLinked_in() {
        return linked_in;
    }

    public void setSkype_id(String skype_id) {
        this.skype_id = skype_id;
    }

    public String getSkype_id() {
        return skype_id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public String getGithub() {
        return github;
    }
}
