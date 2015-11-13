package tr.bel.pendik.aquilamonitor.controller.settings;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tr.bel.pendik.aquilamonitor.data.UserEntity;
import tr.bel.pendik.aquilamonitor.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository repository;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    ResponseEntity<List<UserEntity>> listAll() {
        List<UserEntity> list = new ArrayList<UserEntity>();
        list = repository.findAll();
        if (list == null)
            return new ResponseEntity<List<UserEntity>>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<List<UserEntity>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    ResponseEntity<UserEntity> getById(@PathVariable("id") String id) {
        UserEntity entity = new UserEntity();
        entity = repository.findOne(Long.valueOf(id));
        if (entity == null)
            return new ResponseEntity<UserEntity>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<UserEntity>(entity, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<UserEntity> insert(
            @RequestBody UserEntity app) {
        UserEntity afterSave = repository.save(app);
        ResponseEntity<UserEntity> respEntity;
        if (afterSave.getId() > -1)
            respEntity = new ResponseEntity<UserEntity>(afterSave, HttpStatus.CREATED);
        else
            respEntity = new ResponseEntity<UserEntity>(app, HttpStatus.CONFLICT);
        return respEntity;
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<UserEntity> update(@RequestBody UserEntity app) {
        UserEntity afterSave = repository.save(app);
        ResponseEntity<UserEntity> respEntity;
        if (afterSave.getId() > -1)
            respEntity = new ResponseEntity<UserEntity>(afterSave, HttpStatus.OK);
        else
            respEntity = new ResponseEntity<UserEntity>(app, HttpStatus.NOT_FOUND);
        return respEntity;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Void> delete(
            @PathVariable("id") String deleteId) {
        ResponseEntity<Void> respEntity = null;
        if (StringUtils.isBlank(deleteId) && !StringUtils.isNumeric(deleteId)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        repository.delete(Long.valueOf(deleteId));

        boolean result = repository.exists(Long.valueOf(deleteId));

        if (!result)
            respEntity = new ResponseEntity<>(HttpStatus.OK);
        else {
            respEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return respEntity;
    }


    @RequestMapping(value = "/check/{username}/{password}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<UserEntity> check(@PathVariable("username") String username, @PathVariable("password") String password) {
        ResponseEntity<UserEntity> respEntity = null;
        if (StringUtils.isBlank(username) && StringUtils.isBlank(password)) {
            return new ResponseEntity<UserEntity>(HttpStatus.NOT_FOUND);
        }

        //List<Person> findByLastnameAndFirstnameAllIgnoreCase (String lastname, String firstname);
        //  List<Person> findPeopleDistinctByLastnameOrFirstname(String lastname, String firstname);
        //  List<Person> findByEmailAddressAndLastname(EmailAddress emailAddress, String lastname);
        // Enabling static ORDER BY for a query
        //  List<Person> findByLastnameOrderByFirstnameAsc(String lastname);

        UserEntity resultUser = repository.findByUsernameAndPassword(username, password);

        if (resultUser != null)
            respEntity = new ResponseEntity<UserEntity>(resultUser, HttpStatus.OK);
        else {
            respEntity = new ResponseEntity<UserEntity>(HttpStatus.NOT_FOUND);
        }
        return respEntity;
    }
}