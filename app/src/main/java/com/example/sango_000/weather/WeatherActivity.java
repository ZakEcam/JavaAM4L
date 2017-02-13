package com.example.sango_000.weather;

import android.content.Context;
import android.os.AsyncTask;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;

public class WeatherActivity extends AppCompatActivity {

    private TextView mDisplay ;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);

        mDisplay = (TextView) findViewById(R.id.user_input );
    }



    public class QueryTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            String searchUrl = params[0];
            //String json = null;
            String queryResults = null;

            try {

                String json = NetworkUtils.getResponseFromHttpUrl(searchUrl);
                //Student.parse(json);
                //queryResults = Student.getNames();
                //details.parse(json);
                //queryResults = details.getCods();

                queryResults=json;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return queryResults;
            //return buffer.toString();
        }

        @Override
        protected void onPostExecute(String queryResults) {
            super.onPostExecute(queryResults);
            if (queryResults != null) {
                //itemAdapter.setData(queryResults);
                mDisplay.setText(queryResults);


            }

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.weather_list, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemThatWasClickedId = item.getItemId();
        if (itemThatWasClickedId == R.id.action) {
            Context context = this;
            String textToShow = "Action initiated";
            Toast.makeText(context, textToShow, Toast.LENGTH_SHORT).show();
            new QueryTask().execute("http://andfun-weather.udacity.com/weather");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
