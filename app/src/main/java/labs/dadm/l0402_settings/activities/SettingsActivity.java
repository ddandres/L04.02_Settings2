/*
 * Copyright (c) 2021. David de Andrés and Juan Carlos Ruiz, DISCA - UPV, Development of apps for mobile devices.
 */

package labs.dadm.l0402_settings.activities;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import labs.dadm.l0402_settings.R;
import labs.dadm.l0402_settings.fragments.SettingsFragment;

/*
  Displays the application Settings using the Preference mechanism.
  Because of deprecated APIs, the recommended procedure is using a PreferenceFragmentCompat
  activity to display the settings.
  As this will be explained in Lecture 05, just use this code as it is and we will get back to it later.
 */
public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        // Launch a new transaction to replace the View of fcvSettings frame with the SettingsFragment
        getSupportFragmentManager()
                .beginTransaction()
                .setReorderingAllowed(true)
                .replace(R.id.fcvSettings, SettingsFragment.class, null)
                .commit();

        // Get a reference to the Actionbar
        final ActionBar actionBar = getSupportActionBar();
        // If the application has an ActionBar then enable the up navigation
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

}
