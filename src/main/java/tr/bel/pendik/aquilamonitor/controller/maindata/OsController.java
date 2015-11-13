package tr.bel.pendik.aquilamonitor.controller.maindata;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tr.bel.pendik.aquilamonitor.data.OsEntity;
import tr.bel.pendik.aquilamonitor.repository.OsRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/os")
public class OsController {

    @Autowired
    OsRepository repository;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    ResponseEntity<List<OsEntity>> listAll() {
        List<OsEntity> list = new ArrayList<OsEntity>();
        list = repository.findAll();
        if (list == null)
            return new ResponseEntity<List<OsEntity>>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<List<OsEntity>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    ResponseEntity<OsEntity> getById(@PathVariable("id") String id) {
        OsEntity entity = new OsEntity();
        entity = repository.findOne(Long.valueOf(id));
        if (entity == null)
            return new ResponseEntity<OsEntity>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<OsEntity>(entity, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<OsEntity> insert(
            @RequestBody OsEntity app) {
        OsEntity afterSave = repository.save(app);
        ResponseEntity<OsEntity> respEntity;
        if (afterSave.getId() > -1)
            respEntity = new ResponseEntity<OsEntity>(afterSave, HttpStatus.CREATED);
        else
            respEntity = new ResponseEntity<OsEntity>(app, HttpStatus.CONFLICT);
        return respEntity;
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<OsEntity> update(@RequestBody OsEntity app) {
        OsEntity afterSave = repository.save(app);
        ResponseEntity<OsEntity> respEntity;
        if (afterSave.getId() > -1)
            respEntity = new ResponseEntity<OsEntity>(afterSave, HttpStatus.OK);
        else
            respEntity = new ResponseEntity<OsEntity>(app, HttpStatus.NOT_FOUND);
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