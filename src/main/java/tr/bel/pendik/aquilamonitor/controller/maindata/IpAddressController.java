package tr.bel.pendik.aquilamonitor.controller.maindata;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tr.bel.pendik.aquilamonitor.data.IpAddressEntity;
import tr.bel.pendik.aquilamonitor.repository.IpAddressRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/ipAddress")
public class IpAddressController {

    @Autowired
    IpAddressRepository repository;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    ResponseEntity<List<IpAddressEntity>> listAll() {
        List<IpAddressEntity> list = new ArrayList<IpAddressEntity>();
        list = repository.findAll();
        if (list == null)
            return new ResponseEntity<List<IpAddressEntity>>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<List<IpAddressEntity>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    ResponseEntity<IpAddressEntity> getById(@PathVariable("id") String id) {
        IpAddressEntity entity = new IpAddressEntity();
        entity = repository.findOne(Long.valueOf(id));
        if (entity == null)
            return new ResponseEntity<IpAddressEntity>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<IpAddressEntity>(entity, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<IpAddressEntity> insert(
            @RequestBody IpAddressEntity app) {
        IpAddressEntity afterSave = repository.save(app);
        ResponseEntity<IpAddressEntity> respEntity;
        if (afterSave.getId() > -1)
            respEntity = new ResponseEntity<IpAddressEntity>(afterSave, HttpStatus.CREATED);
        else
            respEntity = new ResponseEntity<IpAddressEntity>(app, HttpStatus.CONFLICT);
        return respEntity;
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<IpAddressEntity> update(@RequestBody IpAddressEntity app) {
        IpAddressEntity afterSave = repository.save(app);
        ResponseEntity<IpAddressEntity> respEntity;
        if (afterSave.getId() > -1)
            respEntity = new ResponseEntity<IpAddressEntity>(afterSave, HttpStatus.OK);
        else
            respEntity = new ResponseEntity<IpAddressEntity>(app, HttpStatus.NOT_FOUND);
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