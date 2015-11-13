package tr.bel.pendik.aquilamonitor.controller.management;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tr.bel.pendik.aquilamonitor.data.ServerProgramEntity;
import tr.bel.pendik.aquilamonitor.repository.ServerProgramRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/serverProgram")
public class ServerProgramController {

    @Autowired
    ServerProgramRepository repository;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    ResponseEntity<List<ServerProgramEntity>> listAll() {
        List<ServerProgramEntity> list = new ArrayList<ServerProgramEntity>();
        list = repository.findAll();
        if (list == null)
            return new ResponseEntity<List<ServerProgramEntity>>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<List<ServerProgramEntity>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    ResponseEntity<ServerProgramEntity> getById(@PathVariable("id") String id) {
        ServerProgramEntity entity = new ServerProgramEntity();
        entity = repository.findOne(Long.valueOf(id));
        if (entity == null)
            return new ResponseEntity<ServerProgramEntity>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<ServerProgramEntity>(entity, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ServerProgramEntity> insert(
            @RequestBody ServerProgramEntity app) {
        ServerProgramEntity afterSave = repository.save(app);
        ResponseEntity<ServerProgramEntity> respEntity;
        if (afterSave.getId() > -1)
            respEntity = new ResponseEntity<ServerProgramEntity>(afterSave, HttpStatus.CREATED);
        else
            respEntity = new ResponseEntity<ServerProgramEntity>(app, HttpStatus.CONFLICT);
        return respEntity;
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ServerProgramEntity> update(@RequestBody ServerProgramEntity app) {
        ServerProgramEntity afterSave = repository.save(app);
        ResponseEntity<ServerProgramEntity> respEntity;
        if (afterSave.getId() > -1)
            respEntity = new ResponseEntity<ServerProgramEntity>(afterSave, HttpStatus.OK);
        else
            respEntity = new ResponseEntity<ServerProgramEntity>(app, HttpStatus.NOT_FOUND);
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