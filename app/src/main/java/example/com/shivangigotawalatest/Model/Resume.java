package example.com.shivangigotawalatest.Model;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Type;
import java.util.List;

public class Resume {

    @SerializedName("name")
    private String name;
    @SerializedName("summary")
    private String summary;
    @SerializedName("contact")
    private Contact contacts;
    @SerializedName("education")
    private List<Education> educationList;
    @SerializedName("work")
    private List<Work> listWork;
    @SerializedName("languages")
    private List<String> languageList;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getSummary() {
        return summary;
    }

    public void setContacts(Contact contacts) {
        this.contacts = contacts;
    }

    public Contact getContacts() {
        return contacts;
    }

    public void setEducationList(List<Education> educationList) {
        this.educationList = educationList;
    }

    public List<Education> getEducationList() {
        return educationList;
    }

    public void setListWork(List<Work> listWork) {
        this.listWork = listWork;
    }

    public List<Work> getListWork() {
        return listWork;
    }

    public void setLanguageList(List<String> languageList) {
        this.languageList = languageList;
    }

    public List<String> getLanguageList() {
        return languageList;
    }

    public static class ResumeDeserializer implements JsonDeserializer<Resume> {

        @Override
        public Resume deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            JsonObject jsonObject = json.getAsJsonObject();
            Gson gson = new Gson();
            Resume resume = gson.fromJson(json, Resume.class);
            Contact contact;
            if(jsonObject.get("contact") == null){
                contact = null;
            }else {
                contact = gson.fromJson(jsonObject.get("contact"), Contact.class);
            }
            resume.setContacts(contact);
            return resume;
        }
    }
}


