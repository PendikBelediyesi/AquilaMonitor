package tr.bel.pendik.aquilamonitor.controller.settings;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tr.bel.pendik.aquilamonitor.data.ParameterEntity;
import tr.bel.pendik.aquilamonitor.repository.ParameterRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/parameter")
public class ParameterController {

    @Autowired
    ParameterRepository repository;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    ResponseEntity<List<ParameterEntity>> listAll() {
        List<ParameterEntity> list = new ArrayList<ParameterEntity>();
        list = repository.findAll();
        if (list == null)
            return new ResponseEntity<List<ParameterEntity>>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<List<ParameterEntity>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    ResponseEntity<ParameterEntity> getById(@PathVariable("id") String id) {
        ParameterEntity entity = new ParameterEntity();
        entity = repository.findOne(Long.valueOf(id));
        if (entity == null)
            return new ResponseEntity<ParameterEntity>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<ParameterEntity>(entity, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ParameterEntity> insert(
            @RequestBody ParameterEntity app) {
        ParameterEntity afterSave = repository.save(app);
        ResponseEntity<ParameterEntity> respEntity;
        if (afterSave.getId() > -1)
            respEntity = new ResponseEntity<ParameterEntity>(afterSave, HttpStatus.CREATED);
        else
            respEntity = new ResponseEntity<ParameterEntity>(app, HttpStatus.CONFLICT);
        return respEntity;
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ParameterEntity> update(@RequestBody ParameterEntity app) {
        ParameterEntity afterSave = repository.save(app);
        ResponseEntity<ParameterEntity> respEntity;
        if (afterSave.getId() > -1)
            respEntity = new ResponseEntity<ParameterEntity>(afterSave, HttpStatus.OK);
        else
            respEntity = new ResponseEntity<ParameterEntity>(app, HttpStatus.NOT_FOUND);
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