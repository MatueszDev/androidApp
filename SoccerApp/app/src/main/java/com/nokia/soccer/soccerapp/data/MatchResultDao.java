package com.nokia.soccer.soccerapp.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface MatchResultDao {
    @Query("SELECT * FROM 'match'")
    public List<Match> getAllMatches();

    @Insert
    public void insert(Match match);
}
