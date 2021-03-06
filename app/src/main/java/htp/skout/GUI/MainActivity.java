package htp.skout.GUI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.util.Calendar;

import htp.skout.MapResources.MapRunner.MapActivity;
import htp.skout.Objects.Global;
import htp.skout.R;
import htp.skout.Tuple;
import htp.skout.frameworks.GPSThread;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Global.context = this;
        if(Global.gpsThread==null)
            Global.gpsThread = new GPSThread();

        startActivity(new Intent(MainActivity.this, MapActivity.class));
        //button = (Button) findViewById(R.id.button);

        //time
        Calendar cal = Calendar.getInstance();
        Global.startTime = new Tuple<>(cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
