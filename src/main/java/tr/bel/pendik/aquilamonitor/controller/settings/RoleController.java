package tr.bel.pendik.aquilamonitor.controller.settings;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tr.bel.pendik.aquilamonitor.data.RoleEntity;
import tr.bel.pendik.aquilamonitor.repository.RoleRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleRepository repository;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    ResponseEntity<List<RoleEntity>> listAll() {
        List<RoleEntity> list = new ArrayList<RoleEntity>();
        list = repository.findAll();
        if (list == null)
            return new ResponseEntity<List<RoleEntity>>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<List<RoleEntity>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    ResponseEntity<RoleEntity> getById(@PathVariable("id") String id) {
        RoleEntity entity = new RoleEntity();
        entity = repository.findOne(Long.valueOf(id));
        if (entity == null)
            return new ResponseEntity<RoleEntity>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<RoleEntity>(entity, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<RoleEntity> insert(
            @RequestBody RoleEntity app) {
        RoleEntity afterSave = repository.save(app);
        ResponseEntity<RoleEntity> respEntity;
        if (afterSave.getId() > -1)
            respEntity = new ResponseEntity<RoleEntity>(afterSave, HttpStatus.CREATED);
        else
            respEntity = new ResponseEntity<RoleEntity>(app, HttpStatus.CONFLICT);
        return respEntity;
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<RoleEntity> update(@RequestBody RoleEntity app) {
        RoleEntity afterSave = repository.save(app);
        ResponseEntity<RoleEntity> respEntity;
        if (afterSave.getId() > -1)
            respEntity = new ResponseEntity<RoleEntity>(afterSave, HttpStatus.OK);
        else
            respEntity = new ResponseEntity<RoleEntity>(app, HttpStatus.NOT_FOUND);
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