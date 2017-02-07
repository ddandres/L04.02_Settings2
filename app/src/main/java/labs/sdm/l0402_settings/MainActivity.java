/*
 * Copyright (c) 2017. David de Andrés and Juan Carlos Ruiz, DISCA - UPV, Development of apps for mobile devices.
 */

package labs.sdm.l0402_settings;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Hold references to View objects
    TextView tvUserName;
    ImageView ivIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Keep a reference to:
        //  the TextView displaying the text on the screen
        //  the ImageView display the app icon
        tvUserName = (TextView) findViewById(R.id.tvUserName);
        ivIcon = (ImageView) findViewById(R.id.ivIcon);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Get access to SharedPreferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        // Display a greetings message that includes the user's name (get it from SharedPreferences)
        tvUserName.setText(String.format(getResources().getString(R.string.user_name), prefs.getString("username", "Anonymous user")));
        // Set the color of the text to that selected by the user (get it from SharedPreferences)
        tvUserName.setTextColor(Color.parseColor(prefs.getString("textcolor", "#000000")));

        // Display/Hide the icon as selected by the user (get it from SharedPreferences)
        ivIcon.setVisibility(prefs.getBoolean("iconvisible", true)?View.VISIBLE:View.INVISIBLE);
    }

    /*
        This method is executed when the activity is created to populate the ActionBar with actions
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Generate the Menu object from the XML resource file
        getMenuInflater().inflate(R.menu.main_menu, menu);

        return true;
    }

    /*
        This method is executed when any action from the ActionBar is selected
    */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Determine the action to take place according to the Id of the action selected
        switch(item.getItemId()) {

            // Display settings activity
            case R.id.miSettings:
                Intent intent = new Intent(this, SettingsActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
