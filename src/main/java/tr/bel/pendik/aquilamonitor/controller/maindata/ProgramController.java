package tr.bel.pendik.aquilamonitor.controller.maindata;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tr.bel.pendik.aquilamonitor.data.ProgramEntity;
import tr.bel.pendik.aquilamonitor.repository.ProgramRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/program")
public class ProgramController {

    @Autowired
    ProgramRepository repository;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    ResponseEntity<List<ProgramEntity>> listAll() {
        List<ProgramEntity> list = new ArrayList<ProgramEntity>();
        list = repository.findAll();
        if (list == null)
            return new ResponseEntity<List<ProgramEntity>>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<List<ProgramEntity>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    ResponseEntity<ProgramEntity> getById(@PathVariable("id") String id) {
        ProgramEntity entity = new ProgramEntity();
        entity = repository.findOne(Long.valueOf(id));
        if (entity == null)
            return new ResponseEntity<ProgramEntity>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<ProgramEntity>(entity, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ProgramEntity> insert(
            @RequestBody ProgramEntity app) {
        ProgramEntity afterSave = repository.save(app);
        ResponseEntity<ProgramEntity> respEntity;
        if (afterSave.getId() > -1)
            respEntity = new ResponseEntity<ProgramEntity>(afterSave, HttpStatus.CREATED);
        else
            respEntity = new ResponseEntity<ProgramEntity>(app, HttpStatus.CONFLICT);
        return respEntity;
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ProgramEntity> update(@RequestBody ProgramEntity app) {
        ProgramEntity afterSave = repository.save(app);
        ResponseEntity<ProgramEntity> respEntity;
        if (afterSave.getId() > -1)
            respEntity = new ResponseEntity<ProgramEntity>(afterSave, HttpStatus.OK);
        else
            respEntity = new ResponseEntity<ProgramEntity>(app, HttpStatus.NOT_FOUND);
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