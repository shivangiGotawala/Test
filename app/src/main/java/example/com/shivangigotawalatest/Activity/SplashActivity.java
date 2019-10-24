package example.com.shivangigotawalatest.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import example.com.shivangigotawalatest.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TextView tvName = findViewById(R.id.tv_name);
        Animation animBlink = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.blink);
        tvName.setVisibility(View.VISIBLE);
        tvName.startAnimation(animBlink);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        }, 5000);
    }
}
