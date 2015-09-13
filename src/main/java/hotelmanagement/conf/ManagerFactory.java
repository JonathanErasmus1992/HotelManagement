package hotelmanagement.conf;

import hotelmanagement.domain.Manager;

/**
 * Created by student on 2015/05/05.
 */
public class ManagerFactory
{
    public static Manager createManager( String man_id,
                                         String man_title )
    {
        Manager manager = new Manager
                .Builder( man_id )
                .manager_title( man_title )
                .build();

        return manager;
    }
}