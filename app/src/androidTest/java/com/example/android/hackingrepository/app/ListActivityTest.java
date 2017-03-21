package com.example.android.hackingrepository.app;

/**
 * Description Please
 *
 * @author pranit
 * @version 1.0
 * @since 22/3/17
 */

import android.app.ListActivity;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.intent.Intents;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.filters.LargeTest;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.intent.matcher.ComponentNameMatchers.hasShortClassName;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.core.AllOf.allOf;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ListActivityTest extends BaseTest {
    public static final String TAG = ListActivityTest.class.getSimpleName();
    @Rule
    public IntentsTestRule<ListActivity> mActivityTestRule
            = new IntentsTestRule<>(ListActivity.class);

    @Test
    public void checkProgressBarVisibility(){
        onView(withId(R.id.pbLoader)).check(ViewAssertions.matches(isDisplayed()));
        Log.i(TAG,"ListActivity "+hasComponent(hasShortClassName(".ListActivity")));

        Intents.intended(allOf(toPackage(PACKAGE_NAME)));
    }
}

