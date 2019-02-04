/*
 * Copyright (c) 2019. David de Andrés and Juan Carlos Ruiz, DISCA - UPV, Development of apps for mobile devices.
 */

package labs.dadm.l0402_settings;


import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;

public class SettingsActivity extends AppCompatPreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // This method is deprecated in favour of the modern Fragment-based activities,
        // but it is perfectly safe to use it
        addPreferencesFromResource(R.xml.preferences);
        // Include the ActionBar for up navigation
        setupActionBar();
    }

    /*
        This method displays the up navigation arrow if an ActionBar is available
     */
    private void setupActionBar() {
        // Get a reference to the ActionBar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            // Show the Up button in the action bar.
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    /*
        This method is executed when any action from the ActionBar is selected
    */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Determine the action to take place according to the Id of the action selected
        int id = item.getItemId();
        /*
            Up navigation
            NOTE: This is not required usually, but due to the particular implementation of
            AppCompatPreferenceActivity class, it is necessary to explicitly state the action
            to take when the up navigation option is selected
        */
        if (id == android.R.id.home) {
            // Navigate from this activity to its parent (they must be located in the same task)
            NavUtils.navigateUpFromSameTask(this);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
