package com.freesoft.android_running_app.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.freesoft.android_running_app.beans.Checkpoint;
import com.freesoft.android_running_app.beans.Route;
import com.freesoft.android_running_app.dao.RouteService;

/**
 * Created by c026dinab on 3/21/2018.
 */

@Database(entities = {Route.class, Checkpoint.class}, version = 1)
public abstract class DataBase extends RoomDatabase {



    private static final String DB_NAME = "routes.db";
    private static volatile DataBase instance;

    public static synchronized DataBase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                    context,
                    DataBase.class,
                    DB_NAME).
                    allowMainThreadQueries().
                    fallbackToDestructiveMigration().
                    build();
        }
        return instance;
    }

    public abstract RouteService getRouteService();

}
