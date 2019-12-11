/*
 * Copyright (c) 2019. David de Andrés and Juan Carlos Ruiz, DISCA - UPV, Development of apps for mobile devices.
 */

package labs.dadm.l0402_settings;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;

/*
  Displays the application Settings using the Preference mechanism.
  Because of deprecated APIs, the recommended procedure is using a PreferenceFragmentCompat
  activity to display the settings.
  As this will be explained in Lecture 06, just use this code as it is and we will get back later to it.
 */
public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        // Launch a new transaction to replace the View of frSettings frame with the SettingsFragment
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frSettings, new SettingsFragment())
                .commit();

        // Get a reference to the Actionbar
        final ActionBar actionBar = getSupportActionBar();
        // If the application has an ActionBar the enable the up navigation
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    /*
      Displays the application Settings to the user through a PreferenceFragment.
     */
    public static class SettingsFragment extends PreferenceFragmentCompat {

        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            // Creates the View to be shown from a Preference resource
            setPreferencesFromResource(R.xml.preferences, rootKey);
        }
    }

}
