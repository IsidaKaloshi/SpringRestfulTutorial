package com.SpringBasicRest.BasicRest.User;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import com.SpringBasicRest.BasicRest.UserDaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;



@RestController
public class UserController {

    @Autowired
    private  UserDaoService service;

    // GET /users
    // retrieveAllUsers
    @GetMapping ("/users")
    public List <User> retrieveAllUsers (){

        return service.findAll();

    }

    // GET /user/{id}

    /*
     * HETEOAS = Hypermedia As The Engine Of Application State
     * enable us to create links so theclient can interact dinamically.
     * */

    @GetMapping ("/users/{id}")
    public Resource<User> retrieveUser (@PathVariable int id){
       User user = service.findOne(id);
        if (user==null)
            throw new UserNotFoundException("id-" + id);

        /*heteoas implementation,
         when  retrieve user is called I want to return a link with all users
         eg. when I call for "/users/1" I want to retrive the data for that user
         but also to provide a link for all other user as well

         I will do that by creating object structure and setting links
         */

        // "all-users", SERVER_PATH + "/users/"
        //retriveAllUsers

        Resource<User> resource = new Resource<User>(user);

        ControllerLinkBuilder linkTo =
                linkTo(methodOn(this.getClass()).retrieveAllUsers());

        resource.add(linkTo.withRel("all-users"));

        //HATEOAS

        return resource;

    }


    @DeleteMapping ("/users/{id}")
    public void deleteUser (@PathVariable int id){
        User user = service.deleteByID(id);
        if (user==null)
            throw new UserNotFoundException("id-" + id);

    }


    /*
      input - detail of user
      output - Created & Return the created URI
    */




    @PostMapping("/users")
    public ResponseEntity<Object> createUser( @Valid @RequestBody User user) {
        User savedUser = service.save(user);
        // CREATED
        // /user/{id}     savedUser.getId()

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri();

        return ResponseEntity.created(location).build();

    }
}
