package com.freesoft.android_running_app.beans;

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
public class Route implements Serializable {

    private String routeName;
    private Date startDate;
    private Date stopDate;
    private List<Checkpoint> checkpointsList;

}
