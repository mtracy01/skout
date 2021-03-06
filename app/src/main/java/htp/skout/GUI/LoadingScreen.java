package htp.skout.GUI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseGeoPoint;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import htp.skout.Objects.Global;
import htp.skout.Objects.User;
import htp.skout.R;


/**
 * Created by Jeroen Goossens for Hack The Planet 2015
 */


public class LoadingScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_screen);

        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);

        Parse.initialize(this, "kjKkRqlBXS9vtkmiSPCqbLQSrDVvGBkyLKcazXTf", "j8WcWT3Wed570ddWBO3rfcbjT8wwGMP8fLeuzGOM");

        //start next activity depending on whether the user is logged in or not...

        if (ParseUser.getCurrentUser() == null) {
            //no user logged in, going to login screen
            Intent intent = new Intent(LoadingScreen.this, Login.class);
            startActivity(intent);
            finish();

        } else {
            //user is logged in, going to main menu
            Global.user  = new User(ParseUser.getCurrentUser().getUsername());

                    Intent intent = new Intent(LoadingScreen.this, MainActivity.class);
                    startActivity(intent);
                    finish();

        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_loading_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
