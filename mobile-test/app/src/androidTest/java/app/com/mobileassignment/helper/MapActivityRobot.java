package app.com.mobileassignment.helper;

import app.com.mobileassignment.R;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

public class MapActivityRobot {

    public void isMapViewDisplayed(){
        onView(withId(R.id.insert_point)).check(matches(isDisplayed()));
    }

}
