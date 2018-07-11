package com.nokia.soccer.soccerapp;

import android.app.Activity;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.os.AsyncTask;
import android.widget.Toast;
import com.nokia.soccer.soccerapp.data.Match;
import com.nokia.soccer.soccerapp.data.MatchDatabase;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class DownloadTask extends AsyncTask<Void, Void, String> {

    private final Activity activity;

    @Override
    protected String doInBackground(Void... voids) {
        try {
            String s = NetworkHelper.downloadWebpage();
            writeToDatabase(s);
            return s;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Toast.makeText(activity, "Downloaded: " + s, Toast.LENGTH_SHORT).show();
    }

    private void writeToDatabase(String s) {
        MatchDatabase matchDatabase = Room.databaseBuilder(activity.getApplicationContext(),
                MatchDatabase.class, "matchDatabase").build();
        Match match = new Match();
        try {
            JSONObject jsonObject = new JSONObject(s);
            match.setHomeTeamName(jsonObject.keys().next());
            match.setAwayTeamName(jsonObject.keys().next());
            matchDatabase.matchResultDao().insert(match);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public DownloadTask(Activity activity) {
        this.activity = activity;
    }
}
