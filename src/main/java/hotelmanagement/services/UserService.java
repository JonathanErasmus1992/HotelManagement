package hotelmanagement.services;

import hotelmanagement.domain.User;

import java.util.List;

/**
 * Created by student on 2015/09/12.
 */
public interface UserService {
    public List<User> getAllUsers();
    public String getUser(String username, String password);
    public boolean newUser(String emailAddress, String password, String recoveryQuestion, String recoveryAnswer);
    public boolean ForgottenPassword(String emailAddress);
    public String RecoveryQuestion(String emailAddress);
    public boolean RecoveryAnswer(String emailAddress, String recoveryAnswer);
    public boolean ChangePassword(String emailAddress, String password);
    public boolean UnregisterUserAccount(String emailAddress);
}
