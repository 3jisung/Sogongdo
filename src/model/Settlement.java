package model;

import java.sql.Date;
import java.sql.Timestamp;

public class Settlement {
    public final Date settlement_date;
    public final String work_place;
    public final String admin;
    public final Timestamp processing_date;
    // processing_time aka settlement_time

    public Settlement(Date settlement_date, String work_place, String admin, Timestamp processing_date) {
        this.settlement_date = settlement_date;
        this.work_place = work_place;
        this.admin = admin;
        this.processing_date = processing_date;
    }
}
