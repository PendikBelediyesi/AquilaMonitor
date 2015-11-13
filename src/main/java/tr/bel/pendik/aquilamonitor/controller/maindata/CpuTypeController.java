package tr.bel.pendik.aquilamonitor.controller.maindata;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tr.bel.pendik.aquilamonitor.data.CpuTypeEntity;
import tr.bel.pendik.aquilamonitor.repository.CpuTypeRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cpuType")
public class CpuTypeController {

    @Autowired
    CpuTypeRepository repository;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    ResponseEntity<List<CpuTypeEntity>> listAll() {
        List<CpuTypeEntity> list = new ArrayList<CpuTypeEntity>();
        list = repository.findAll();
        if (list == null)
            return new ResponseEntity<List<CpuTypeEntity>>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<List<CpuTypeEntity>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    ResponseEntity<CpuTypeEntity> getById(@PathVariable("id") String id) {
        CpuTypeEntity entity = new CpuTypeEntity();
        entity = repository.findOne(Long.valueOf(id));
        if (entity == null)
            return new ResponseEntity<CpuTypeEntity>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<CpuTypeEntity>(entity, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<CpuTypeEntity> insert(
            @RequestBody CpuTypeEntity app) {
        CpuTypeEntity afterSave = repository.save(app);
        ResponseEntity<CpuTypeEntity> respEntity;
        if (afterSave.getId() > -1)
            respEntity = new ResponseEntity<CpuTypeEntity>(afterSave, HttpStatus.CREATED);
        else
            respEntity = new ResponseEntity<CpuTypeEntity>(app, HttpStatus.CONFLICT);
        return respEntity;
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<CpuTypeEntity> update(@RequestBody CpuTypeEntity app) {
        CpuTypeEntity afterSave = repository.save(app);
        ResponseEntity<CpuTypeEntity> respEntity;
        if (afterSave.getId() > -1)
            respEntity = new ResponseEntity<CpuTypeEntity>(afterSave, HttpStatus.OK);
        else
            respEntity = new ResponseEntity<CpuTypeEntity>(app, HttpStatus.NOT_FOUND);
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