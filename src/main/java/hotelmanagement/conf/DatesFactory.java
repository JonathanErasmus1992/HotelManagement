package hotelmanagement.conf;

import hotelmanagement.domain.Dates;

import java.util.Date;

/**
 * Created by student on 2015/05/05.
 */
public class DatesFactory {
    public static Dates createDates(Date made_date,
                                    Date arrival_date,
                                    Date departure_date)
    {
        Dates dates = new Dates
                .Builder(made_date)
                .booking_arrival_date(arrival_date)
                .booking_departure_date(departure_date)
                .build();

        return dates;

    }
}
