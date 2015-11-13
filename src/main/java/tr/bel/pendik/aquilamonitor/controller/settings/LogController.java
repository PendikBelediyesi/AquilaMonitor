package tr.bel.pendik.aquilamonitor.controller.settings;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tr.bel.pendik.aquilamonitor.data.LogEntity;
import tr.bel.pendik.aquilamonitor.repository.LogRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/log")
public class LogController {

    @Autowired
    LogRepository repository;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    ResponseEntity<List<LogEntity>> listAll() {
        List<LogEntity> list = new ArrayList<LogEntity>();
        list = repository.findAll();
        if (list == null)
            return new ResponseEntity<List<LogEntity>>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<List<LogEntity>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    ResponseEntity<LogEntity> getById(@PathVariable("id") String id) {
        LogEntity entity = new LogEntity();
        entity = repository.findOne(Long.valueOf(id));
        if (entity == null)
            return new ResponseEntity<LogEntity>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<LogEntity>(entity, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<LogEntity> insert(
            @RequestBody LogEntity app) {
        LogEntity afterSave = repository.save(app);
        ResponseEntity<LogEntity> respEntity;
        if (afterSave.getId() > -1)
            respEntity = new ResponseEntity<LogEntity>(afterSave, HttpStatus.CREATED);
        else
            respEntity = new ResponseEntity<LogEntity>(app, HttpStatus.CONFLICT);
        return respEntity;
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<LogEntity> update(@RequestBody LogEntity app) {
        LogEntity afterSave = repository.save(app);
        ResponseEntity<LogEntity> respEntity;
        if (afterSave.getId() > -1)
            respEntity = new ResponseEntity<LogEntity>(afterSave, HttpStatus.OK);
        else
            respEntity = new ResponseEntity<LogEntity>(app, HttpStatus.NOT_FOUND);
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