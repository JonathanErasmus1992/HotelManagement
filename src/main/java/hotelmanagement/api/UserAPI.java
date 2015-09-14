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
    @RequestMapping(value = "/user/all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> userList = userService.getAllUsers();
        return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
    }
    //Return a successful log in
    @RequestMapping(value = "/user/login", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Boolean> getUser(/*@RequestParam*/)
    {
        return new ResponseEntity<Boolean>(true, HttpStatus.ACCEPTED);
    }
}
