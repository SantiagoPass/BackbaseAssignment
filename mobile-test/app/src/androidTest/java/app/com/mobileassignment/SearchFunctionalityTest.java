package app.com.mobileassignment;

import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import app.com.mobileassignment.helper.MainActivityRobot;
import app.com.mobileassignment.helper.MapActivityRobot;
import app.com.mobileassignment.views.MainActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static app.com.mobileassignment.helper.CustomMatchers.withListIsNotEmpty;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class SearchFunctionalityTest {

    @Before
    public void preconditionSetup() {
        onView(withId(R.id.citiesList)).check(matches(withListIsNotEmpty()));
    }

    @Rule
    public ActivityTestRule<MainActivity> activityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void verifyThatTheUserIsAbleToSearchAPartialCityNameInTheList() {
        MainActivityRobot mainActivityRobot = new MainActivityRobot();
        mainActivityRobot.inputCity("Cordoba");
        mainActivityRobot.inListTheCityIsDisplayed("Cordoba, AR");
        mainActivityRobot.inListTheCityIsDisplayed("Cordoba, CO");
        mainActivityRobot.inListTheCityIsDisplayed("Cordoba, ES");
        mainActivityRobot.inListTheCityIsDisplayed("Cordoba, MX");
    }

    @Test
    public void verifyThatTheUserIsAbleToSearchAFullyCityNameInTheList() {
        MainActivityRobot mainActivityRobot = new MainActivityRobot();
        mainActivityRobot.inputCity("Cordoba, AR");
        mainActivityRobot.inListTheCityIsDisplayed("Cordoba, AR");
    }

    @Test
    public void verifyResultsWhenTheUserSearchAnUnknownCityInTheList() {
        MainActivityRobot mainActivityRobot = new MainActivityRobot();
        mainActivityRobot.inputCity("Unknown city");
        mainActivityRobot.inListThereAreNotItems();
    }

    @Test
    public void verifyThatTheDefaultCitiesAreListedInAscendingAlphabeticalOrder() {
        MainActivityRobot mainActivityRobot = new MainActivityRobot();
        mainActivityRobot.inListAllItemsAreOrderedAlphabetically();
    }

    @Test
    public void verifyThatTheSearchedCitiesAreListedInAscendingAlphabeticalOrder() {
        MainActivityRobot mainActivityRobot = new MainActivityRobot();
        mainActivityRobot.inputCity("Cordoba");
        mainActivityRobot.inListAllItemsCointainsTheText("Cordoba");
        mainActivityRobot.inListAllItemsAreOrderedAlphabetically();
    }

    @Test
    public void verifyThatTheUserIsAbleToScrollUpAndScrollDownTheListOfCities() {
        MainActivityRobot mainActivityRobot = new MainActivityRobot();
        mainActivityRobot.inListElementOnPositionHasText(29, "Aalborg, DK");
        mainActivityRobot.inListElementOnPositionHasText(0, "'t Hoeksken, BE");
    }

    @Test
    public void verifyThatTheUserIsRedirectedToTheMapActivityWhenACityIsSelectedFromTheDefaultList() {
        MainActivityRobot mainActivityRobot = new MainActivityRobot();
        MapActivityRobot mapActivityRobot = mainActivityRobot.selectFirstCity();
        mapActivityRobot.isMapViewDisplayed();
    }

    @Test
    public void verifyThatTheUserIsRedirectedToTheMapActivityWhenASearchedCityIsSelected() {
        MainActivityRobot mainActivityRobot = new MainActivityRobot();
        mainActivityRobot.inputCity("Buenos Aires");
        mainActivityRobot.inListAllItemsCointainsTheText("Buenos Aires");
        MapActivityRobot mapActivityRobot = mainActivityRobot.selectFirstCity();
        mapActivityRobot.isMapViewDisplayed();
    }

    @Test
    public void verifyThatTheUserIsAbleToRepeatTheSearchProcess() {
        String city = "Buenos Aires";
        MainActivityRobot mainActivityRobot = new MainActivityRobot();
        mainActivityRobot.inputCity(city);
        mainActivityRobot.searchFieldHasText(city);
        mainActivityRobot.inListAllItemsCointainsTheText(city);
        MapActivityRobot mapActivityRobot = mainActivityRobot.selectFirstCity();
        mapActivityRobot.isMapViewDisplayed();
        Espresso.pressBack();
        mainActivityRobot.searchFieldHasText(city);
        mainActivityRobot.inListAllItemsCointainsTheText(city);

        city = "Cordoba";
        mainActivityRobot.inputCity(city);
        mainActivityRobot.searchFieldHasText(city);
        mainActivityRobot.inListAllItemsCointainsTheText(city);
        mapActivityRobot = mainActivityRobot.selectFirstCity();
        mapActivityRobot.isMapViewDisplayed();
        Espresso.pressBack();
        mainActivityRobot.searchFieldHasText(city);
        mainActivityRobot.inListAllItemsCointainsTheText(city);

    }

}
