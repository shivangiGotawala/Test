package example.com.shivangigotawalatest;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import example.com.shivangigotawalatest.Activity.MainActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    /**
     * for splash activity
     */
    @Test
    public void testSplashFlow() {
        startIntent();
        onView(withId(R.id.tv_name)).check(matches(isDisplayed()));
    }

    /**
     * for Main activity clicks
     */
    @Test
    public void testClicks() {
        onView(withId(R.id.cv_contact)).perform(click());
        onView(withId(R.id.cv_work)).perform(click());
        onView(withId(R.id.cv_education)).perform(click());
        onView(withId(R.id.cv_language)).perform(click());
        onView(withId(R.id.iv_x)).perform(click());
        onView(withId(R.id.iv_contact_x)).perform(click());
        onView(withId(R.id.iv_work_x)).perform(click());
        onView(withId(R.id.iv_lang_x)).perform(click());
    }

    /**
     * for Main activity cardviews
     */

    @Test
    public void testCards() {
        onView(withId(R.id.tv_cont_linkedin_id)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_cont_skype_id)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_cont_email)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_cont_github)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_cont_city)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_work_Details)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_edu_Details)).check(matches(isDisplayed()));
        onView(withId(R.id.rv_language_Details)).check(matches(isDisplayed()));
    }


    /**
     * test Intent
     */
    private void startIntent() {
        mActivityRule.launchActivity(intent);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {

        }
    }
}
