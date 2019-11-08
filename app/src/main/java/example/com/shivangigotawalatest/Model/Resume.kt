package example.com.shivangigotawalatest.Model

import com.google.gson.Gson
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.JsonParseException
import com.google.gson.annotations.SerializedName

import java.lang.reflect.Type

class Resume {

    @SerializedName("name")
    var name: String? = null
    @SerializedName("summary")
    var summary: String? = null
    @SerializedName("contact")
    var contacts: Contact? = null
    @SerializedName("education")
    var educationList: List<Education>? = null
    @SerializedName("work")
    var listWork: List<Work>? = null
    @SerializedName("languages")
    var languageList: List<String>? = null

    class ResumeDeserializer : JsonDeserializer<Resume> {

        @Throws(JsonParseException::class)
        override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): Resume {
            val jsonObject = json.asJsonObject
            val gson = Gson()
            val resume = gson.fromJson(json, Resume::class.java)
            val contact: Contact?
            if (jsonObject.get("contact") == null) {
                contact = null
            } else {
                contact = gson.fromJson(jsonObject.get("contact"), Contact::class.java)
            }
            resume.contacts = contact
            return resume
        }
    }
}


