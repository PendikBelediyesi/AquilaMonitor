package tr.bel.pendik.aquilamonitor.controller.monitor;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tr.bel.pendik.aquilamonitor.data.MonitorEntity;
import tr.bel.pendik.aquilamonitor.repository.MonitorRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/monitor")
public class MonitorController {

    @Autowired
    MonitorRepository repository;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    ResponseEntity<List<MonitorEntity>> listAll() {
        List<MonitorEntity> list = new ArrayList<MonitorEntity>();
        list = repository.findAll();
        if (list == null)
            return new ResponseEntity<List<MonitorEntity>>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<List<MonitorEntity>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    ResponseEntity<MonitorEntity> getById(@PathVariable("id") String id) {
        MonitorEntity entity = new MonitorEntity();
        entity = repository.findOne(Long.valueOf(id));
        if (entity == null)
            return new ResponseEntity<MonitorEntity>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<MonitorEntity>(entity, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<MonitorEntity> insert(
            @RequestBody MonitorEntity app) {
        MonitorEntity afterSave = repository.save(app);
        ResponseEntity<MonitorEntity> respEntity;
        if (afterSave.getId() > -1)
            respEntity = new ResponseEntity<MonitorEntity>(afterSave, HttpStatus.CREATED);
        else
            respEntity = new ResponseEntity<MonitorEntity>(app, HttpStatus.CONFLICT);
        return respEntity;
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<MonitorEntity> update(@RequestBody MonitorEntity app) {
        MonitorEntity afterSave = repository.save(app);
        ResponseEntity<MonitorEntity> respEntity;
        if (afterSave.getId() > -1)
            respEntity = new ResponseEntity<MonitorEntity>(afterSave, HttpStatus.OK);
        else
            respEntity = new ResponseEntity<MonitorEntity>(app, HttpStatus.NOT_FOUND);
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