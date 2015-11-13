package tr.bel.pendik.aquilamonitor.controller.management;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tr.bel.pendik.aquilamonitor.data.ServerEntity;
import tr.bel.pendik.aquilamonitor.repository.ServerRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/server")
public class ServerController {

    @Autowired
    ServerRepository repository;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    ResponseEntity<List<ServerEntity>> listAll() {
        List<ServerEntity> list = new ArrayList<ServerEntity>();
        list = repository.findAll();
        if (list == null)
            return new ResponseEntity<List<ServerEntity>>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<List<ServerEntity>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    ResponseEntity<ServerEntity> getById(@PathVariable("id") String id) {
        ServerEntity entity = new ServerEntity();
        entity = repository.findOne(Long.valueOf(id));
        if (entity == null)
            return new ResponseEntity<ServerEntity>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<ServerEntity>(entity, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ServerEntity> insert(
            @RequestBody ServerEntity app) {
        ServerEntity afterSave = repository.save(app);
        ResponseEntity<ServerEntity> respEntity;
        if (afterSave.getId() > -1)
            respEntity = new ResponseEntity<ServerEntity>(afterSave, HttpStatus.CREATED);
        else
            respEntity = new ResponseEntity<ServerEntity>(app, HttpStatus.CONFLICT);
        return respEntity;
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ServerEntity> update(@RequestBody ServerEntity app) {
        ServerEntity afterSave = repository.save(app);
        ResponseEntity<ServerEntity> respEntity;
        if (afterSave.getId() > -1)
            respEntity = new ResponseEntity<ServerEntity>(afterSave, HttpStatus.OK);
        else
            respEntity = new ResponseEntity<ServerEntity>(app, HttpStatus.NOT_FOUND);
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