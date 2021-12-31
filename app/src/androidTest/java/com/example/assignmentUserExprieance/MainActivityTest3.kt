package com.example.assignmentUserExprieance


import android.os.Parcel
import android.os.Parcelable
import android.view.View
import android.view.ViewGroup
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@LargeTest
@RunWith(AndroidJUnit4::class)
class MainActivityTest3() : Parcelable {

    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(MainActivity::class.java)

    constructor(parcel: Parcel) : this() {

    }

    @Test
    fun mainActivityTest3() {
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
        textInputEditText.perform(replaceText("vraj"), closeSoftKeyboard())

        val textInputEditText2 = onView(
            allOf(
                withId(R.id.tetPhoneNumber),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.titPhoneNumber),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText2.perform(replaceText("8320204478"), closeSoftKeyboard())

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

        val textInputEditText3 = onView(
            allOf(
                withId(R.id.tetEmailAddress), withText("vbrahmbhatt7420@gmail.com"),
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
        textInputEditText3.perform(click())

        val textInputEditText4 = onView(
            allOf(
                withId(R.id.tetEmailAddress), withText("vbrahmbhatt7420@gmail.com"),
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
        textInputEditText4.perform(click())

        val appCompatSpinner2 = onView(
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
        appCompatSpinner2.perform(scrollTo(), click())

        val textInputEditText5 = onView(
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
        textInputEditText5.perform(replaceText("baro"), closeSoftKeyboard())

        pressBack()

        val textInputEditText6 = onView(
            allOf(
                withId(R.id.tetAddress), withText("baro"),
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
        textInputEditText6.perform(replaceText("barot faliyu "))

        val textInputEditText7 = onView(
            allOf(
                withId(R.id.tetAddress), withText("barot faliyu "),
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
        textInputEditText7.perform(closeSoftKeyboard())

        val textInputEditText8 = onView(
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
        textInputEditText8.perform(click())

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

        val materialButton2 = onView(
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
        materialButton2.perform(scrollTo(), click())
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

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainActivityTest3> {
        override fun createFromParcel(parcel: Parcel): MainActivityTest3 {
            return MainActivityTest3(parcel)
        }

        override fun newArray(size: Int): Array<MainActivityTest3?> {
            return arrayOfNulls(size)
        }
    }
}
