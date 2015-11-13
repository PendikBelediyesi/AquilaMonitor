package tr.bel.pendik.aquilamonitor.controller.maindata;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tr.bel.pendik.aquilamonitor.data.RelationTypeEntity;
import tr.bel.pendik.aquilamonitor.repository.RelationTypeRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/relationType")
public class RelationTypeController {

    @Autowired
    RelationTypeRepository repository;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    ResponseEntity<List<RelationTypeEntity>> listAll() {
        List<RelationTypeEntity> list = new ArrayList<RelationTypeEntity>();
        list = repository.findAll();
        if (list == null)
            return new ResponseEntity<List<RelationTypeEntity>>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<List<RelationTypeEntity>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    ResponseEntity<RelationTypeEntity> getById(@PathVariable("id") String id) {
        RelationTypeEntity entity = new RelationTypeEntity();
        entity = repository.findOne(Long.valueOf(id));
        if (entity == null)
            return new ResponseEntity<RelationTypeEntity>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<RelationTypeEntity>(entity, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<RelationTypeEntity> insert(
            @RequestBody RelationTypeEntity app) {
        RelationTypeEntity afterSave = repository.save(app);
        ResponseEntity<RelationTypeEntity> respEntity;
        if (afterSave.getId() > -1)
            respEntity = new ResponseEntity<RelationTypeEntity>(afterSave, HttpStatus.CREATED);
        else
            respEntity = new ResponseEntity<RelationTypeEntity>(app, HttpStatus.CONFLICT);
        return respEntity;
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<RelationTypeEntity> update(@RequestBody RelationTypeEntity app) {
        RelationTypeEntity afterSave = repository.save(app);
        ResponseEntity<RelationTypeEntity> respEntity;
        if (afterSave.getId() > -1)
            respEntity = new ResponseEntity<RelationTypeEntity>(afterSave, HttpStatus.OK);
        else
            respEntity = new ResponseEntity<RelationTypeEntity>(app, HttpStatus.NOT_FOUND);
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