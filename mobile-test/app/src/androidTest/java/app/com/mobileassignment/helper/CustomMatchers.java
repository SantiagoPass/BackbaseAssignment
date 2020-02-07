package app.com.mobileassignment.helper;

import android.support.test.espresso.core.deps.guava.collect.Ordering;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import java.util.ArrayList;
import java.util.List;

import app.com.mobileassignment.model.City;
import app.com.mobileassignment.views.adapters.CityAdapter;


public class CustomMatchers {

    public static Matcher<View> withListSize(final int size) {
        return new TypeSafeMatcher<View>() {
            int length;

            @Override
            public boolean matchesSafely(final View view) {
                length = ((AdapterView) view).getAdapter().getCount();
                return length == size;
            }

            @Override
            public void describeTo(final Description description) {
                description.appendText("ListView should have " + size + " items, the actual size is " + length);
            }
        };
    }

    public static Matcher<View> withListIsNotEmpty() {
        return new TypeSafeMatcher<View>() {
            int length;

            @Override
            public boolean matchesSafely(final View view) {
                length = ((AdapterView) view).getAdapter().getCount();
                return length != 0;
            }

            @Override
            public void describeTo(final Description description) {
                description.appendText("ListView doesn't have elements");
            }
        };
    }

    public static Matcher<View> withListAllElementsInTextViewContains(final int id, final String text) {
        return new TypeSafeMatcher<View>() {
            int length;
            String item;

            @Override
            public boolean matchesSafely(final View view) {
                length = ((AdapterView) view).getAdapter().getCount();
                ListView itemLV = ((ListView) view);
                for (int i = 0; i < length; i++) {
                    TextView itemTV = (TextView) itemLV.getChildAt(i).findViewById(id);
                    item = itemTV.getText().toString();
                    if (!item.contains(text))
                        return false;
                }
                return true;
            }

            @Override
            public void describeTo(final Description description) {
                description.appendText("The item " + item + " doesn't contains " + text);
            }
        };
    }

    public static Matcher<View> withListAllElementsAreSortedAlphabetically() {
        return new TypeSafeMatcher<View>() {

            private final List<String> cityNames = new ArrayList<>();

            @Override
            protected boolean matchesSafely(View item) {
                ListView listView = (ListView) item;
                CityAdapter cityAdapter = (CityAdapter) listView.getAdapter();
                cityNames.clear();
                cityNames.addAll(extractCitiesNames(cityAdapter.getCityList()));
                return Ordering.natural().isOrdered(cityNames);
            }

            private List<String> extractCitiesNames(List<City> cities) {
                List<String> citiesName = new ArrayList<>();
                for (City city : cities) {
                    citiesName.add(city.getName() + ", " + city.getCountry());
                }
                return citiesName;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("The list is not sorted alphabetically");
            }
        };
    }

    public static Matcher<View> withListTheElementInTextViewIsDisplayed(final int id, final String text) {
        return new TypeSafeMatcher<View>() {
            int length;
            String item;

            @Override
            public boolean matchesSafely(final View view) {
                length = ((AdapterView) view).getAdapter().getCount();
                ListView itemLV = ((ListView) view);
                for (int i = 0; i < length; i++) {
                    TextView itemTV = (TextView) itemLV.getChildAt(i).findViewById(id);
                    item = itemTV.getText().toString();
                    if (item.equals(text))
                        return true;
                }
                return false;

            }

            @Override
            public void describeTo(final Description description) {
                description.appendText("The item " + item + " doesn't contains " + text);
            }
        }

                ;
    }


}
