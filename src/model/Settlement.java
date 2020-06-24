package model;

public class Settlement {
    public final String settlement_date;
    public final String work_place;
    public final String admin;
    public final String processing_date;
    // processing_time aka settlement_time

    public Settlement(String settlement_date, String work_place, String admin, String processing_date) {
        this.settlement_date = settlement_date;
        this.work_place = work_place;
        this.admin = admin;
        this.processing_date = processing_date;
    }
}
