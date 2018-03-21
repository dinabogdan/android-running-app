package com.freesoft.android_running_app.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.freesoft.android_running_app.beans.Route;

import java.util.List;

/**
 * Created by stud on 3/21/2018.
 */

@Dao
public interface RouteService {

    @Insert
    public void save(Route route);

    @Query("Select * from ROUTES")
    public List<Route> getRoutes();
}
