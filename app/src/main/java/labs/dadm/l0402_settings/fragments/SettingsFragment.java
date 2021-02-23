/*
 * Copyright (c) 2021. David de Andrés and Juan Carlos Ruiz, DISCA - UPV, Development of apps for mobile devices.
 */

package labs.dadm.l0402_settings.fragments;

import android.os.Bundle;

import androidx.preference.PreferenceFragmentCompat;

import labs.dadm.l0402_settings.R;

/*
  Displays the application Settings to the user through a PreferenceFragment.
 */
public class SettingsFragment extends PreferenceFragmentCompat {
    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        // Creates the View to be shown from a Preference resource
        setPreferencesFromResource(R.xml.preferences, rootKey);
    }
}
