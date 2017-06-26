package billlugo.recyclerjsondemo.view.home;


import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.support.v7.widget.RecyclerView;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import billlugo.recyclerjsondemo.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class RecyclerViewTest {

    RecyclerView recyclerView;

    @Rule
    public ActivityTestRule<HomeActivity> mActivityTestRule = new ActivityTestRule<>(HomeActivity.class);



    @Before
    public void init(){
        recyclerView = (RecyclerView) mActivityTestRule.getActivity().findViewById(R.id.rv);
        mActivityTestRule.getActivity().presenter.getPhotos();
    }

    @Test
    public void testAll() {


        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i = 0; i < getRVcount(); i++) {
            if (getRVcount() > 0) {
                onView(withId(R.id.rv)).perform(RecyclerViewActions.actionOnItemAtPosition(i, click()));
                pressBack();

            }
        }

    }

    private int getRVcount(){

        return recyclerView.getAdapter().getItemCount();
    }

    @Test
    public void checkFourth(){
       if (getRVcount() > 0) {
                onView(withId(R.id.rv)).perform(RecyclerViewActions.actionOnItemAtPosition(3, click()));

            }

    }

}
