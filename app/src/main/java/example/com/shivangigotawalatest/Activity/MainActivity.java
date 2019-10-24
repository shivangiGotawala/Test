package example.com.shivangigotawalatest.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

import example.com.shivangigotawalatest.Adapter.EducationAdapter;
import example.com.shivangigotawalatest.Adapter.LanguageAdapter;
import example.com.shivangigotawalatest.Adapter.WorkAdapter;
import example.com.shivangigotawalatest.Model.Bio;
import example.com.shivangigotawalatest.Model.Resume;
import example.com.shivangigotawalatest.R;

public class MainActivity extends AppCompatActivity {

    private LinearLayout llContact;
    private CardView cvContact, cvEducation, cvWork, cvLang;
    private ImageView ivContactX, ivX, ivWorkX, ivLangX;
    private RecyclerView rvEduDetails, rvWorkDetails, rvLangDetails;
    private boolean edu = false;
    private boolean work = false;
    private boolean lang = false;
    private boolean contact = false;
    private Resume resume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivX = findViewById(R.id.iv_x);
        ivContactX = findViewById(R.id.iv_contact_x);
        ivWorkX = findViewById(R.id.iv_work_x);
        ivLangX = findViewById(R.id.iv_lang_x);
        llContact = findViewById(R.id.ll_contact);
        cvContact = findViewById(R.id.cv_contact);
        cvEducation = findViewById(R.id.cv_education);
        cvWork = findViewById(R.id.cv_work);
        cvLang = findViewById(R.id.cv_language);
        rvEduDetails = findViewById(R.id.rv_edu_Details);
        rvWorkDetails = findViewById(R.id.rv_work_Details);
        rvLangDetails = findViewById(R.id.rv_language_Details);
        TextView tvName = findViewById(R.id.tv_name);
        TextView tvSummary = findViewById(R.id.tv_summary);
        TextView tvLinkedIn = findViewById(R.id.tv_cont_linkedin_id);
        TextView tvSkype = findViewById(R.id.tv_cont_skype_id);
        TextView tvEmail = findViewById(R.id.tv_cont_email);
        TextView tvGithub = findViewById(R.id.tv_cont_github);
        TextView tvCity = findViewById(R.id.tv_cont_city);

        JsonParser parser = new JsonParser();
        JsonElement mJson = parser.parse(loadJSONFromAsset().toString());
        Gson gson = new Gson();
        Bio bio = gson.fromJson(mJson, Bio.class);
        resume = bio.getResume();
        tvName.setText(resume.getName());
        tvSummary.setText(resume.getSummary());
        tvLinkedIn.setText(resume.getContacts().getLinked_in());
        tvSkype.setText(resume.getContacts().getSkype_id());
        tvEmail.setText(resume.getContacts().getEmail());
        tvGithub.setText(resume.getContacts().getGithub());
        tvCity.setText(resume.getContacts().getCity());

        setAdapters();
        setClickEvent();

    }

    public JSONObject loadJSONFromAsset() {
        String json = null;
        JSONObject jObj = null;
        try {
            InputStream is = getResources().getAssets().open("resume.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        try {
            jObj = new JSONObject(json);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jObj;
    }

    public void setAdapters() {
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rvEduDetails.setLayoutManager(mLayoutManager);
        rvEduDetails.setItemAnimator(new DefaultItemAnimator());
        EducationAdapter educationAdapter = new EducationAdapter(MainActivity.this, resume.getEducationList());
        rvEduDetails.setAdapter(educationAdapter);

        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rvWorkDetails.setLayoutManager(mLayoutManager);
        rvWorkDetails.setItemAnimator(new DefaultItemAnimator());
        WorkAdapter workAdapter = new WorkAdapter(MainActivity.this, resume.getListWork());
        rvWorkDetails.setAdapter(workAdapter);

        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rvLangDetails.setLayoutManager(mLayoutManager);
        rvLangDetails.setItemAnimator(new DefaultItemAnimator());
        LanguageAdapter languageAdapter = new LanguageAdapter(MainActivity.this, resume.getLanguageList());
        rvLangDetails.setAdapter(languageAdapter);
    }

    public void setClickEvent() {

        cvContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!contact) {
                    ivContactX.setRotation(90);
                    llContact.setVisibility(View.VISIBLE);
                    contact = true;
                } else {
                    ivContactX.setRotation(45);
                    llContact.setVisibility(View.GONE);
                    contact = false;
                }
            }
        });

        cvEducation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!edu) {
                    ivX.setRotation(90);
                    rvEduDetails.setVisibility(View.VISIBLE);
                    edu = true;
                } else {
                    ivX.setRotation(45);
                    rvEduDetails.setVisibility(View.GONE);
                    edu = false;
                }
            }
        });

        cvWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!work) {
                    ivWorkX.setRotation(90);
                    rvWorkDetails.setVisibility(View.VISIBLE);
                    work = true;
                } else {
                    ivWorkX.setRotation(45);
                    rvWorkDetails.setVisibility(View.GONE);
                    work = false;
                }
            }
        });

        cvLang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!lang) {
                    ivLangX.setRotation(90);
                    rvLangDetails.setVisibility(View.VISIBLE);
                    lang = true;
                } else {
                    ivLangX.setRotation(45);
                    rvLangDetails.setVisibility(View.GONE);
                    lang = false;
                }
            }
        });

    }
}
