package app.com.mobileassignment.helper;

import app.com.mobileassignment.R;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static app.com.mobileassignment.helper.CustomMatchers.withListAllElementsAreSortedAlphabetically;
import static app.com.mobileassignment.helper.CustomMatchers.withListAllElementsInTextViewContains;
import static app.com.mobileassignment.helper.CustomMatchers.withListSize;
import static app.com.mobileassignment.helper.CustomMatchers.withListTheElementInTextViewIsDisplayed;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.core.AllOf.allOf;

public class MainActivityRobot {

    public void inputCity(String city) {
        onView(withId(R.id.search)).perform(clearText())
                .perform(typeText(city), closeSoftKeyboard());
    }

    public MapActivityRobot selectFirstCity() {
        onData(anything()).inAdapterView(withId(R.id.citiesList)).atPosition(0).perform(click());
        return new MapActivityRobot();
    }

    public void searchFieldHasText(String text) {
        onView(withId(R.id.search)).check(matches(withText(text)));
    }

    public void inListTheCityIsDisplayed(String city) {
        onView(withId(R.id.citiesList)).check(matches(withListTheElementInTextViewIsDisplayed(R.id.cityName, city)));
    }

    public void inListThereAreNotItems() {
        onView(withId(R.id.citiesList)).check(matches(withListSize(0)));
    }

    public void inListAllItemsAreOrderedAlphabetically() {
        onView(withId(R.id.citiesList)).check(matches(withListAllElementsAreSortedAlphabetically()));
    }

    public void inListAllItemsCointainsTheText(String text) {
        onView(withId(R.id.citiesList)).check(matches(withListAllElementsInTextViewContains(R.id.cityName, text)));
    }

    public void inListElementOnPositionHasText(int position, String text) {
        onData(anything())
                .inAdapterView(withId(R.id.citiesList))
                .atPosition(position)
                .check(matches(hasDescendant(
                        allOf(withId(R.id.cityName), withText(containsString(text))))));
    }
}
