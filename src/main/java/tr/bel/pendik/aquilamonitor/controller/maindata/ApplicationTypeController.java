package tr.bel.pendik.aquilamonitor.controller.maindata;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tr.bel.pendik.aquilamonitor.data.ApplicationTypeEntity;
import tr.bel.pendik.aquilamonitor.repository.ApplicationTypeRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/applicationType")
public class ApplicationTypeController {

    @Autowired
    ApplicationTypeRepository repository;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    ResponseEntity<List<ApplicationTypeEntity>> listAll() {
        List<ApplicationTypeEntity> list = new ArrayList<ApplicationTypeEntity>();
        list = repository.findAll();
        if (list == null)
            return new ResponseEntity<List<ApplicationTypeEntity>>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<List<ApplicationTypeEntity>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    ResponseEntity<ApplicationTypeEntity> getById(@PathVariable("id") String id) {
        ApplicationTypeEntity entity = new ApplicationTypeEntity();
        entity = repository.findOne(Long.valueOf(id));
        if (entity == null)
            return new ResponseEntity<ApplicationTypeEntity>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<ApplicationTypeEntity>(entity, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ApplicationTypeEntity> insert(
            @RequestBody ApplicationTypeEntity app) {
        ApplicationTypeEntity afterSave = repository.save(app);
        ResponseEntity<ApplicationTypeEntity> respEntity;
        if (afterSave.getId() > -1)
            respEntity = new ResponseEntity<ApplicationTypeEntity>(afterSave, HttpStatus.CREATED);
        else
            respEntity = new ResponseEntity<ApplicationTypeEntity>(app, HttpStatus.CONFLICT);
        return respEntity;
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ApplicationTypeEntity> update(@RequestBody ApplicationTypeEntity app) {
        ApplicationTypeEntity afterSave = repository.save(app);
        ResponseEntity<ApplicationTypeEntity> respEntity;
        if (afterSave.getId() > -1)
            respEntity = new ResponseEntity<ApplicationTypeEntity>(afterSave, HttpStatus.OK);
        else
            respEntity = new ResponseEntity<ApplicationTypeEntity>(app, HttpStatus.NOT_FOUND);
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