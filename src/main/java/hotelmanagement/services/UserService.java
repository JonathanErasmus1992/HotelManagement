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
    public Long ForgottenPassword(String emailAddress);
    public String RecoveryQuestion(Long ID);
    public boolean RecoveryAnswer(String recoveryAnswer, Long ID);
    public boolean ChangePassword(String password, Long ID);
}
