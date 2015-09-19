package hotelmanagement.api;

/**
 * Created by student on 2015/09/13.
 */
import hotelmanagement.domain.User;
import hotelmanagement.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value="/user/**")
public class UserAPI {
    @Autowired
    private UserService userService;

    //Get All Users
    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> userList = userService.getAllUsers();
        return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
    }
    //Return a successful log in
    @RequestMapping(value = "/login", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getUser(@RequestParam String emailAddress,
                                          @RequestParam String password)
    {
        String logInMessage = "";

        logInMessage = userService.getUser(emailAddress, password);

        return new ResponseEntity<String>(logInMessage, HttpStatus.OK);
    }

    //Create a new user
    @RequestMapping(value = "/add", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> newUser(@RequestParam String emailAddress,
                                           @RequestParam String password,
                                           @RequestParam String recoveryQ,
                                           @RequestParam String recoveryA)
    {
        boolean blnCreateUser = false;

        blnCreateUser = userService.newUser(emailAddress, password, recoveryQ, recoveryA);

        return new ResponseEntity<Boolean>(blnCreateUser, HttpStatus.OK);

    }

    //Return forgotten password id
    @RequestMapping(value = "/forgotpassword", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> forgotPassword(@RequestParam String emailAddress)
    {
        boolean blnUserFound = false;

        blnUserFound = userService.ForgottenPassword(emailAddress);

        return new ResponseEntity<Boolean>(blnUserFound, HttpStatus.OK);
    }

    @RequestMapping(value = "/recoveryquestion", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> recoveryQuestion(@RequestParam String emailAddress)
    {
        String strRecoveryQ = "";

        strRecoveryQ = userService.RecoveryQuestion(emailAddress);

        return new ResponseEntity<String>(strRecoveryQ, HttpStatus.OK);
    }

    @RequestMapping(value = "/recoveryanswer", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> recoveryAnswer(@RequestParam String emailAddress,
                                                  @RequestParam String recoveryAnswer)
    {
        boolean blnCorrectAnswer = false;

        blnCorrectAnswer = userService.RecoveryAnswer(emailAddress, recoveryAnswer);

        return new ResponseEntity<Boolean>(blnCorrectAnswer, HttpStatus.OK);
    }

    @RequestMapping(value = "/changepassword", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> changePassword(@RequestParam String emailAddress,
                                                  @RequestParam String password)
    {
        boolean blnChangePassword = false;

        blnChangePassword = userService.ChangePassword(emailAddress, password);

        return new ResponseEntity<Boolean>(blnChangePassword, HttpStatus.OK);
    }

    @RequestMapping(value = "/unregister", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> unregisterUser(@RequestParam String emailAddress)
    {
        boolean blnUserUnregistered = false;

        blnUserUnregistered = userService.UnregisterUserAccount(emailAddress);

        return new ResponseEntity<Boolean>(blnUserUnregistered, HttpStatus.OK);
    }
}
