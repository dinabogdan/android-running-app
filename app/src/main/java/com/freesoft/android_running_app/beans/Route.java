package com.freesoft.android_running_app.beans;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by c026dinab on 3/9/2018.
 */

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(tableName = "ROUTES")
public class Route implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ROUTE_ID")
    private Integer id;

    @ColumnInfo(name = "ROUTE_NAME")
    private String routeName;

    @ColumnInfo(name = "START_DATE")
    private String startDate;

    @ColumnInfo(name = "STOP_DATE")
    private String stopDate;

    @Ignore
    private List<Checkpoint> checkpointsList;

}
