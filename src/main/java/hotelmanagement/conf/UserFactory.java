package hotelmanagement.conf;

import hotelmanagement.domain.User;

/**
 * Created by student on 2015/05/05.
 */
public class UserFactory
{
    public static User createUser( String emailAddress,
                                   String pass,
                                   String recoveryQuestion,
                                   String recoveryAnswer)
    {
        User user = new User
                .Builder( emailAddress )
                .password( pass )
                .recoveryQuestion(recoveryQuestion)
                .recoveryAnswer(recoveryAnswer)
                .build();

        return user;
    }

}
