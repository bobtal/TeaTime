/*
* Copyright (C) 2017 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*  	http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.android.teatime;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.android.teatime.model.Tea;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

/**
 * This test demos a user clicking on a GridView item in MenuActivity which opens up the
 * corresponding OrderActivity.
 *
 * This test does not utilize Idling Resources yet. If idling is set in the MenuActivity,
 * then this test will fail. See the IdlingResourcesTest for an identical test that
 * takes into account Idling Resources.
 */


// COMPLETED (1) Add annotation to specify AndroidJUnitRunner class as the default test runner
@RunWith(AndroidJUnit4.class)
public class MenuActivityScreenTest {

    // COMPLETED (2) Add the rule that provides functional testing of a single activity
    @Rule
    public ActivityTestRule<MenuActivity> activityTestRule = new ActivityTestRule<>(MenuActivity.class);

    // COMPLETED (3) Finish writing this test which will click on a gridView Tea item and verify that
    // the OrderActivity opens up with the correct tea name displayed.

    @Test
    public void clickGridViewItem_OpensOrderActivity() {
        // Click on the gridView Chamomile tea item
        onData(anything()).inAdapterView(withId(R.id.tea_grid_view)).atPosition(5).perform(click());

        // Check if the OrderActivity is opened with Chamomile Tea as tea name in tea_name_text_view
        onView(withId(R.id.tea_name_text_view)).check(matches(withText("Chamomile Tea")));
    }


}