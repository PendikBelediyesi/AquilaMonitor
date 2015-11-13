package tr.bel.pendik.aquilamonitor.controller.maindata;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tr.bel.pendik.aquilamonitor.data.ServerTypeEntity;
import tr.bel.pendik.aquilamonitor.repository.ServerTypeRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/serverType")
public class ServerTypeController {

    @Autowired
    ServerTypeRepository repository;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    ResponseEntity<List<ServerTypeEntity>> listAll() {
        List<ServerTypeEntity> list = new ArrayList<ServerTypeEntity>();
        list = repository.findAll();
        if (list == null)
            return new ResponseEntity<List<ServerTypeEntity>>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<List<ServerTypeEntity>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    ResponseEntity<ServerTypeEntity> getById(@PathVariable("id") String id) {
        ServerTypeEntity entity = new ServerTypeEntity();
        entity = repository.findOne(Long.valueOf(id));
        if (entity == null)
            return new ResponseEntity<ServerTypeEntity>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<ServerTypeEntity>(entity, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ServerTypeEntity> insert(
            @RequestBody ServerTypeEntity app) {
        ServerTypeEntity afterSave = repository.save(app);
        ResponseEntity<ServerTypeEntity> respEntity;
        if (afterSave.getId() > -1)
            respEntity = new ResponseEntity<ServerTypeEntity>(afterSave, HttpStatus.CREATED);
        else
            respEntity = new ResponseEntity<ServerTypeEntity>(app, HttpStatus.CONFLICT);
        return respEntity;
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ServerTypeEntity> update(@RequestBody ServerTypeEntity app) {
        ServerTypeEntity afterSave = repository.save(app);
        ResponseEntity<ServerTypeEntity> respEntity;
        if (afterSave.getId() > -1)
            respEntity = new ResponseEntity<ServerTypeEntity>(afterSave, HttpStatus.OK);
        else
            respEntity = new ResponseEntity<ServerTypeEntity>(app, HttpStatus.NOT_FOUND);
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