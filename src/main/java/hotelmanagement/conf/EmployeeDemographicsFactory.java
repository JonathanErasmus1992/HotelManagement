package hotelmanagement.conf;

import hotelmanagement.domain.EmployeeDemographics;

/**
 * Created by student on 2015/05/05.
 */
public class EmployeeDemographicsFactory {
    public static EmployeeDemographics createEmployeeDemographics( String gender,
                                                                   String race,
                                                                   String home_language)
    {
        EmployeeDemographics employee_demographics = new EmployeeDemographics
                .Builder(race)
                .gender(gender)
                .home_language(home_language)
                .build();
        return employee_demographics;
    }
}
