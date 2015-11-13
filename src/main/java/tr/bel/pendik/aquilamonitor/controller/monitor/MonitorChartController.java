package tr.bel.pendik.aquilamonitor.controller.monitor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tr.bel.pendik.aquilamonitor.data.ApplicationEntity;
import tr.bel.pendik.aquilamonitor.repository.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/monitorChart")
public class MonitorChartController {

    @Autowired
    ApplicationRepository repository;

    @Autowired
    ProgramRepository programRepository;

    @Autowired
    ServerRepository serverRepository;

    @Autowired
    ResponsibleRepository responsibleRepository;

    @Autowired
    MonitorRepository monitorRepository;

    @Autowired
    MonitorLogRepository monitorLogRepository;

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    ResponseEntity<List<ApplicationEntity>> listAll() {
        List<ApplicationEntity> list = new ArrayList<ApplicationEntity>();
        list = repository.findAll();
        if (list == null)
            return new ResponseEntity<List<ApplicationEntity>>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<List<ApplicationEntity>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    ResponseEntity<ApplicationEntity> getById(@PathVariable("id") String id) {
        ApplicationEntity entity = new ApplicationEntity();
        entity = repository.findOne(Long.valueOf(id));
        if (entity == null)
            return new ResponseEntity<ApplicationEntity>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<ApplicationEntity>(entity, HttpStatus.OK);
    }

}