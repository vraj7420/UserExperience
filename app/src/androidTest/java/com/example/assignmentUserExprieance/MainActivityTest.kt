package com.example.assignmentUserExprieance


import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.*
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun mainActivityTest() {
        val textInputEditText = onView(
            allOf(
                withId(R.id.tetFullName),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.titFullName),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText.perform(replaceText("vraj br"), closeSoftKeyboard())

        val textInputEditText2 = onView(
            allOf(
                withId(R.id.tetEmailAddress),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.titEmailAddress),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText2.perform(replaceText("vraj0722@outlook.com"), closeSoftKeyboard())

        val appCompatSpinner = onView(
            allOf(
                withId(R.id.spinnerCountry),
                childAtPosition(
                    allOf(
                        withId(R.id.SectionOne),
                        childAtPosition(
                            withId(R.id.linearLayout1),
                            0
                        )
                    ),
                    4
                )
            )
        )
        appCompatSpinner.perform(scrollTo(), click())

        var PopupBackgroundView = ""
        val appCompatCheckedTextView = onData(anything())
            .inAdapterView(
                childAtPosition(
                    withClassName(`is`("android.widget.PopupWindow$PopupBackgroundView")),
                    0
                )
            )
            .atPosition(2)
        appCompatCheckedTextView.perform(click())

        val textInputEditText3 = onView(
            allOf(
                withId(R.id.tetAddress),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.titAddress),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText3.perform(replaceText("barot faliyu sinjiwada "), closeSoftKeyboard())

        val textInputEditText4 = onView(
            allOf(
                withId(R.id.tetBirthDate),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.titBirthDate),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        textInputEditText4.perform(click())

        val textInputEditText5 = onView(
            allOf(
                withId(R.id.tetBirthDate),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.titBirthDate),
                        0
                    ),
                    1
                ),
                isDisplayed()
            )
        )
        textInputEditText5.perform(click())

        val materialButton = onView(
            allOf(
                withId(android.R.id.button1), withText("OK"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.ScrollView")),
                        0
                    ),
                    3
                )
            )
        )
        materialButton.perform(scrollTo(), click())

        val materialButton2 = onView(
            allOf(
                withId(android.R.id.button1), withText("OK"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.ScrollView")),
                        0
                    ),
                    3
                )
            )
        )
        materialButton2.perform(scrollTo(), click())

        val materialRadioButton = onView(
            allOf(
                withId(R.id.rbFemale),
                childAtPosition(
                    allOf(
                        withId(R.id.rgSex),
                        childAtPosition(
                            withId(R.id.SectionOne),
                            3
                        )
                    ),
                    1
                )
            )
        )
        materialRadioButton.perform(scrollTo(), click())

        val materialCheckBox = onView(
            allOf(
                withId(R.id.chbPlaying), withText("Playing"),
                childAtPosition(
                    allOf(
                        withId(R.id.SectionOne),
                        childAtPosition(
                            withId(R.id.linearLayout1),
                            0
                        )
                    ),
                    1
                )
            )
        )
        materialCheckBox.perform(scrollTo(), click())

        val appCompatSpinner2 = onView(
            allOf(
                withId(R.id.spinnerSscHsc),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.linearLayout1),
                        1
                    ),
                    3
                )
            )
        )
        appCompatSpinner2.perform(scrollTo(), click())

        val appCompatCheckedTextView2 = onData(anything())
            .inAdapterView(
                childAtPosition(
                    withClassName(`is`("android.widget.PopupWindow$PopupBackgroundView")),
                    0
                )
            )
            .atPosition(1)
        appCompatCheckedTextView2.perform(click())

        val appCompatSpinner3 = onView(
            allOf(
                withId(R.id.spinnerBComBCA),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.linearLayout1),
                        1
                    ),
                    2
                )
            )
        )
        appCompatSpinner3.perform(scrollTo(), click())

        val appCompatCheckedTextView3 = onData(anything())
            .inAdapterView(
                childAtPosition(
                    withClassName(`is`("android.widget.PopupWindow$PopupBackgroundView")),
                    0
                )
            )
            .atPosition(1)
        appCompatCheckedTextView3.perform(click())

        val materialButton3 = onView(
            allOf(
                withId(R.id.btnSignup), withText("SignUp"),
                childAtPosition(
                    allOf(
                        withId(R.id.linearLayout1),
                        childAtPosition(
                            withId(R.id.scrollViewOfActivity),
                            0
                        )
                    ),
                    2
                )
            )
        )
        materialButton3.perform(scrollTo(), click())

        pressBack()
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
