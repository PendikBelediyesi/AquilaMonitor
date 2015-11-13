package tr.bel.pendik.aquilamonitor.controller.management;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tr.bel.pendik.aquilamonitor.data.ApplicationEntity;
import tr.bel.pendik.aquilamonitor.repository.ApplicationRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/application")
public class ApplicationController {

    @Autowired
    ApplicationRepository repository;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    ResponseEntity<List<ApplicationEntity>> listAll() {
        List<ApplicationEntity> list = new ArrayList<ApplicationEntity>();
        list = repository.findAll();
        if (list == null)
            return new ResponseEntity<List<ApplicationEntity>>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<List<ApplicationEntity>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    ResponseEntity<ApplicationEntity> getById(@PathVariable("id") String id) {
        ApplicationEntity entity = new ApplicationEntity();
        entity = repository.findOne(Long.valueOf(id));
        if (entity == null)
            return new ResponseEntity<ApplicationEntity>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<ApplicationEntity>(entity, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ApplicationEntity> insert(
            @RequestBody ApplicationEntity app) {
        ApplicationEntity afterSave = repository.save(app);
        ResponseEntity<ApplicationEntity> respEntity;
        if (afterSave.getId() > -1)
            respEntity = new ResponseEntity<ApplicationEntity>(afterSave, HttpStatus.CREATED);
        else
            respEntity = new ResponseEntity<ApplicationEntity>(app, HttpStatus.CONFLICT);
        return respEntity;
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ApplicationEntity> update(@RequestBody ApplicationEntity app) {
        ApplicationEntity afterSave = repository.save(app);
        ResponseEntity<ApplicationEntity> respEntity;
        if (afterSave.getId() > -1)
            respEntity = new ResponseEntity<ApplicationEntity>(afterSave, HttpStatus.OK);
        else
            respEntity = new ResponseEntity<ApplicationEntity>(app, HttpStatus.NOT_FOUND);
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
}