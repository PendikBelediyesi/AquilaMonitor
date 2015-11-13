package tr.bel.pendik.aquilamonitor.controller.monitor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tr.bel.pendik.aquilamonitor.data.MonitorLogEntity;
import tr.bel.pendik.aquilamonitor.repository.MonitorLogRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/monitorLog")
public class MonitorLogController {

    @Autowired
    MonitorLogRepository repository;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    ResponseEntity<List<MonitorLogEntity>> listAll() {
        List<MonitorLogEntity> list = new ArrayList<MonitorLogEntity>();
        list = repository.findAll();
        if (list == null)
            return new ResponseEntity<List<MonitorLogEntity>>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<List<MonitorLogEntity>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    ResponseEntity<MonitorLogEntity> getById(@PathVariable("id") String id) {
        MonitorLogEntity entity = new MonitorLogEntity();
        entity = repository.findOne(Long.valueOf(id));
        if (entity == null)
            return new ResponseEntity<MonitorLogEntity>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<MonitorLogEntity>(entity, HttpStatus.OK);
    }

}