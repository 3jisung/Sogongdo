package model;

import java.sql.Date;
import java.sql.Timestamp;

public class Settlement {
    public final Date settlement_date;
    public final String workplace;
    public final String admin_id;
    public final Timestamp processed_time;
    // processing_time aka settlement_time

    public Settlement(Date settlement_date, String workplace, String admin_id, Timestamp processed_time) {
        this.settlement_date = settlement_date;
        this.workplace = workplace;
        this.admin_id = admin_id;
        this.processed_time = processed_time;
    }
}
