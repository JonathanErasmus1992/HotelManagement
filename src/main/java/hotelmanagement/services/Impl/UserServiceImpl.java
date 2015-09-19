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
    public boolean ForgottenPassword(String emailAddress) {

        int count = 0;
        boolean blnUserFound = false;
        Iterable<User> users = repositoryUser.findAll();
        for (User user : users) {
            if (user.getEmailAddress().equalsIgnoreCase(emailAddress))
            {
                blnUserFound = true;
            }
        }

        return blnUserFound;
    }

    @Override
    public String RecoveryQuestion(String emailAddress)
    {
        String recoveryA = "";
        Iterable<User> users = repositoryUser.findAll();
        for (User user : users) {
            if (user.getEmailAddress().equalsIgnoreCase(emailAddress))
            {
                recoveryA = user.getRecoveryQuestion();
            }
        }

        return recoveryA;
    }

    //This function is called after the recoveryQuestion function returns a true value
    @Override
    public boolean RecoveryAnswer(String emailAddress, String recoveryAnswer)
    {
        boolean blnCorrectAnswer = false;

        Iterable<User> users = repositoryUser.findAll();
        for (User user : users) {
            if (user.getEmailAddress().equalsIgnoreCase(emailAddress))
            {
                if(user.getRecoveryAnswer().equalsIgnoreCase(recoveryAnswer)){
                    blnCorrectAnswer = true;
                }
            }
        }

        return blnCorrectAnswer;
    }

    @Override
    public boolean ChangePassword(String emailAddress, String password)
    {
        boolean blnPasswordChange = false;

        Iterable<User> users = repositoryUser.findAll();
        for (User user : users) {
            if (user.getEmailAddress().equalsIgnoreCase(emailAddress))
            {
                User newUser = new User.Builder(user.getEmailAddress())
                        .ID(user.getID())
                        .password(password)
                        .recoveryQuestion(user.getRecoveryQuestion())
                        .recoveryAnswer(user.getRecoveryAnswer())
                        .build();
                repositoryUser.save(newUser);
                blnPasswordChange = true;
            }
        }
        return blnPasswordChange;
    }

    @Override
    public boolean UnregisterUserAccount(String emailAddress)
    {
        boolean blnUserUnregistered = false;
        Long userID = 0L;

        Iterable<User> users = repositoryUser.findAll();
        for (User user : users) {
            if (user.getEmailAddress().equalsIgnoreCase(emailAddress)) {
                blnUserUnregistered = true;
                userID = user.getID();
            }
        }

        if (blnUserUnregistered == true){
            repositoryUser.delete(userID);
        }

        return blnUserUnregistered;
    }
}
