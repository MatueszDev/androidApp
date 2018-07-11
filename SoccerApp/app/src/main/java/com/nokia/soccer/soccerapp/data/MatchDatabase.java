package com.nokia.soccer.soccerapp.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Match.class}, version = 1)
public abstract class MatchDatabase extends RoomDatabase {
    public abstract MatchResultDao matchResultDao();
}
