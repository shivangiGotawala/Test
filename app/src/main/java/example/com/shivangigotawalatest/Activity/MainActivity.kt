package example.com.shivangigotawalatest.Activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.CardView
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

import com.google.gson.Gson
import com.google.gson.JsonParser

import org.json.JSONException
import org.json.JSONObject

import java.io.IOException

import example.com.shivangigotawalatest.Adapter.EducationAdapter
import example.com.shivangigotawalatest.Adapter.LanguageAdapter
import example.com.shivangigotawalatest.Adapter.WorkAdapter
import example.com.shivangigotawalatest.Model.Bio
import example.com.shivangigotawalatest.Model.Resume
import example.com.shivangigotawalatest.R
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {

    private var llContact: LinearLayout? = null
    private var cvContact: CardView? = null
    private var cvEducation: CardView? = null
    private var cvWork: CardView? = null
    private var cvLang: CardView? = null
    private var ivContactX: ImageView? = null
    private var ivX: ImageView? = null
    private var ivWorkX: ImageView? = null
    private var ivLangX: ImageView? = null
    private var rvEduDetails: RecyclerView? = null
    private var rvWorkDetails: RecyclerView? = null
    private var rvLangDetails: RecyclerView? = null
    private var btnServerData: Button? = null
    private var edu = false
    private var work = false
    private var lang = false
    private var contact = false
    private var resume: Resume? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ivX = findViewById(R.id.iv_x)
        ivContactX = findViewById(R.id.iv_contact_x)
        ivWorkX = findViewById(R.id.iv_work_x)
        ivLangX = findViewById(R.id.iv_lang_x)
        llContact = findViewById(R.id.ll_contact)
        cvContact = findViewById(R.id.cv_contact)
        cvEducation = findViewById(R.id.cv_education)
        cvWork = findViewById(R.id.cv_work)
        cvLang = findViewById(R.id.cv_language)
        rvEduDetails = findViewById(R.id.rv_edu_Details)
        rvWorkDetails = findViewById(R.id.rv_work_Details)
        rvLangDetails = findViewById(R.id.rv_language_Details)
        val tvName = findViewById<TextView>(R.id.tv_name)
        val tvSummary = findViewById<TextView>(R.id.tv_summary)
        val tvLinkedIn = findViewById<TextView>(R.id.tv_cont_linkedin_id)
        val tvSkype = findViewById<TextView>(R.id.tv_cont_skype_id)
        val tvEmail = findViewById<TextView>(R.id.tv_cont_email)
        val tvGithub = findViewById<TextView>(R.id.tv_cont_github)
        val tvCity = findViewById<TextView>(R.id.tv_cont_city)
        btnServerData = findViewById(R.id.btn_data)

        val parser = JsonParser()
        val mJson = parser.parse(loadJSONFromAsset()!!.toString())
        val gson = Gson()
        val bio = gson.fromJson<Bio>(mJson, Bio::class.java)
        resume = bio.resume
        tvName.text = resume!!.name
        tvSummary.text = resume!!.summary
        tvLinkedIn.text = resume!!.contacts!!.linked_in
        tvSkype.text = resume!!.contacts!!.skype_id
        tvEmail.text = resume!!.contacts!!.email
        tvGithub.text = resume!!.contacts!!.github
        tvCity.text = resume!!.contacts!!.city

        setAdapters()
        setClickEvent()
    }

    fun loadJSONFromAsset(): JSONObject? {
        val json: String
        var jObj: JSONObject? = null
        try {
            val `is` = resources.assets.open("resume.json")
            val size = `is`.available()
            val buffer = ByteArray(size)
            `is`.read(buffer)
            `is`.close()
            val charset: Charset = Charsets.UTF_8
            json = String(buffer, charset)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }

        try {
            jObj = JSONObject(json)

        } catch (e: JSONException) {
            e.printStackTrace()
        }

        return jObj
    }

    fun setAdapters() {
        var mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(applicationContext)
        rvEduDetails!!.layoutManager = mLayoutManager
        rvEduDetails!!.itemAnimator = DefaultItemAnimator()
        val educationAdapter = EducationAdapter(this@MainActivity, resume!!.educationList)
        rvEduDetails!!.adapter = educationAdapter

        mLayoutManager = LinearLayoutManager(applicationContext)
        rvWorkDetails!!.layoutManager = mLayoutManager
        rvWorkDetails!!.itemAnimator = DefaultItemAnimator()
        val workAdapter = WorkAdapter(this@MainActivity, resume!!.listWork)
        rvWorkDetails!!.adapter = workAdapter

        mLayoutManager = LinearLayoutManager(applicationContext)
        rvLangDetails!!.layoutManager = mLayoutManager
        rvLangDetails!!.itemAnimator = DefaultItemAnimator()
        val languageAdapter = LanguageAdapter(this@MainActivity, resume!!.languageList)
        rvLangDetails!!.adapter = languageAdapter
    }

    fun setClickEvent() {

        cvContact!!.setOnClickListener {
            if (!contact) {
                ivContactX!!.rotation = 90f
                llContact!!.visibility = View.VISIBLE
                contact = true
            } else {
                ivContactX!!.rotation = 45f
                llContact!!.visibility = View.GONE
                contact = false
            }
        }

        cvEducation!!.setOnClickListener {
            if (!edu) {
                ivX!!.rotation = 90f
                rvEduDetails!!.visibility = View.VISIBLE
                edu = true
            } else {
                ivX!!.rotation = 45f
                rvEduDetails!!.visibility = View.GONE
                edu = false
            }
        }

        cvWork!!.setOnClickListener {
            if (!work) {
                ivWorkX!!.rotation = 90f
                rvWorkDetails!!.visibility = View.VISIBLE
                work = true
            } else {
                ivWorkX!!.rotation = 45f
                rvWorkDetails!!.visibility = View.GONE
                work = false
            }
        }

        cvLang!!.setOnClickListener {
            if (!lang) {
                ivLangX!!.rotation = 90f
                rvLangDetails!!.visibility = View.VISIBLE
                lang = true
            } else {
                ivLangX!!.rotation = 45f
                rvLangDetails!!.visibility = View.GONE
                lang = false
            }
        }

        btnServerData!!.setOnClickListener {
            val intent = Intent(this@MainActivity, SeverDataActivity::class.java)
            startActivity(intent)
        }

    }
}
