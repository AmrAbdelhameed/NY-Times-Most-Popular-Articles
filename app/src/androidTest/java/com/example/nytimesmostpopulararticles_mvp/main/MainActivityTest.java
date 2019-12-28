package com.example.nytimesmostpopulararticles_mvp.main;

import android.support.test.InstrumentationRegistry;

import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.nytimesmostpopulararticles_mvp.R;
import com.example.nytimesmostpopulararticles_mvp.TestComponentRule;
import com.example.nytimesmostpopulararticles_mvp.ui.main.MainActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.RuleChain;
import org.junit.rules.TestRule;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    public final TestComponentRule component =
            new TestComponentRule(InstrumentationRegistry.getTargetContext());

    public final IntentsTestRule<MainActivity> main =
            new IntentsTestRule<>(MainActivity.class, false, false);

    @Rule
    public TestRule chain = RuleChain.outerRule(component).around(main);

    @Before
    public void setup() {

    }

    @Test
    public void checkViewsDisplay() {
        main.launchActivity(MainActivity.getStartIntent(component.getContext()));

        onView(withId(R.id.nav_host_fragment))
                .check(matches(isDisplayed()));
    }
}