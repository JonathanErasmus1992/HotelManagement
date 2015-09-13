package hotelmanagement.services.Impl;

import hotelmanagement.conf.UserFactory;
import hotelmanagement.domain.User;
import hotelmanagement.repository.UserRepo;
import hotelmanagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/12.
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo repositoryUser;

    @Override
    public List<User> getAllUsers() {
        List<User> allUsers = new ArrayList<User>();

        Iterable<User> users = repositoryUser.findAll();
        for (User user : users) {
            allUsers.add(user);
        }
        return allUsers;
    }

    @Override
    public String getUser(String username, String password) {
        String strUserLogIn = "";
        String strUser = "";
        String strPass = "";
        int countUser = 0;
        int countPass = 0;

        Iterable<User> users = repositoryUser.findAll();
        for (User user : users) {
            if (user.getEmailAddress().equals(username) & (user.getPassword().equals(password)))
            {
                countUser = countUser + 1;
                countPass = countPass + 1;
            }
            else if (user.getEmailAddress().equals(username))
            {
                countUser = countUser + 1;
            }
            else if (user.getPassword().equals(password))
            {
                countPass = countPass + 1;
            }
        }
        if (countUser != 0)
        {
            strUser = "Username: Found";
        }
        else
        {
            strUser = "Username: Not Found";
        }
        if (countPass != 0)
        {
            strPass = "Password: Found";
        }
        else
        {
            strPass = "Password: Not Found";
        }

        strUserLogIn = strUser + "\n" + strPass;

        return strUserLogIn;
    }

    @Override
    public boolean newUser(String emailAddress, String password, String recoveryQuestion, String recoveryAnswer) {

        int count = 0;
        boolean blnCreateUser;
        Iterable<User> users = repositoryUser.findAll();
        for (User user : users) {
            if (user.getEmailAddress().equalsIgnoreCase(emailAddress))
            {
                count = count + 1;
            }
        }

        if (count == 0)
        {
            User user = UserFactory.createUser(emailAddress, password, recoveryQuestion, recoveryAnswer);
            repositoryUser.save(user);
            blnCreateUser = true;
        }
        else
        {
            blnCreateUser = false;
        }


        return blnCreateUser;
    }

    @Override
    public Long ForgottenPassword(String emailAddress) {

        Long userID = 0L;
        int count = 0;
        boolean blnUserFound;
        Iterable<User> users = repositoryUser.findAll();
        for (User user : users) {
            if (user.getEmailAddress().equalsIgnoreCase(emailAddress))
            {
                user.getID();
            }
        }

        return userID;
    }

    @Override
    public String RecoveryQuestion(Long ID)
    {
        User user = repositoryUser.findOne(ID);
        return user.getRecoveryQuestion();
    }

    //This function is called after the recoveryQuestion function returns a true value
    @Override
    public boolean RecoveryAnswer(String recoveryAnswer, Long ID)
    {
        boolean blnCorrectAnswer;
        User user = repositoryUser.findOne(ID);
        if (user.getRecoveryAnswer().equalsIgnoreCase(recoveryAnswer))
        {
            blnCorrectAnswer = true;
        }
        else
        {
            blnCorrectAnswer = false;
        }
        return blnCorrectAnswer;
    }

    @Override
    public boolean ChangePassword(String password, Long ID)
    {
        boolean blnPasswordChange = true;
        User user = repositoryUser.findOne(ID);
        User newUser = new User.Builder(user.getEmailAddress())
                .ID(ID)
                .password(password)
                .recoveryQuestion(user.getRecoveryQuestion())
                .recoveryAnswer(user.getRecoveryAnswer())
                .build();
        repositoryUser.save(newUser);

        return blnPasswordChange;
    }
}
