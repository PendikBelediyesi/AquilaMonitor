package tr.bel.pendik.aquilamonitor.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tr.bel.pendik.aquilamonitor.data.*;
import tr.bel.pendik.aquilamonitor.repository.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainDataController {

    @Autowired
    ApplicationTypeRepository applicationTypeRepository;
    @Autowired
    IpAddressRepository ipAddressRepository;
    @Autowired
    ProgramRepository programRepository;
    @Autowired
    RelationTypeRepository relationTypeRepository;
    @Autowired
    ServerTypeRepository serverTypeRepository;

    @RequestMapping(value = "/api/applicationType", method = RequestMethod.GET, produces = {
            "application/xml", "application/json"})
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    List<ApplicationTypeEntity> listAllApplicationType() {
        List<ApplicationTypeEntity> applicationTypeList = new ArrayList<ApplicationTypeEntity>();
        applicationTypeList = applicationTypeRepository.findAll();
        return applicationTypeList;
    }

    @RequestMapping(value = "/api/ipAddress", method = RequestMethod.GET, produces = {
            "application/xml", "application/json"})
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    List<IpAddressEntity> listAllIpAddress() {
        List<IpAddressEntity> ipAddressList = new ArrayList<IpAddressEntity>();
        ipAddressList = ipAddressRepository.findAll();
        return ipAddressList;
    }

    @RequestMapping(value = "/api/program", method = RequestMethod.GET, produces = {
            "application/xml", "application/json"})
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    List<ProgramEntity> listAllProgram() {
        List<ProgramEntity> programList = new ArrayList<ProgramEntity>();
        programList = programRepository.findAll();
        return programList;
    }

    @RequestMapping(value = "/api/relationType", method = RequestMethod.GET, produces = {
            "application/xml", "application/json"})
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    List<RelationTypeEntity> listAllRelationType() {
        List<RelationTypeEntity> relationTypeList = new ArrayList<RelationTypeEntity>();
        relationTypeList = relationTypeRepository.findAll();
        return relationTypeList;
    }


    @RequestMapping(value = "/api/serverType", method = RequestMethod.GET, produces = {
            "application/xml", "application/json"})
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    List<ServerTypeEntity> listAllServerType() {
        List<ServerTypeEntity> serverTypeList = new ArrayList<ServerTypeEntity>();
        serverTypeList = serverTypeRepository.findAll();
        return serverTypeList;
    }


    @RequestMapping(value = "/save/applicationType", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ApplicationTypeEntity> saveApplicationType(
            @RequestBody ApplicationTypeEntity app) {
        ApplicationTypeEntity afterSave = applicationTypeRepository.save(app);
        ResponseEntity<ApplicationTypeEntity> responseEntity;
        if (afterSave.getId() > -1)
            responseEntity = new ResponseEntity<ApplicationTypeEntity>(afterSave, HttpStatus.CREATED);
        else
            responseEntity = new ResponseEntity<ApplicationTypeEntity>(afterSave, HttpStatus.EXPECTATION_FAILED);

        return responseEntity;
    }


    @RequestMapping(value = "/delete/applicationType/{id}", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<Void> deleteApplicationType(
            @PathVariable("id") String deleteId) {
        ResponseEntity<Void> responseEntity = null;
        if (StringUtils.isBlank(deleteId) && !StringUtils.isNumeric(deleteId)) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
        applicationTypeRepository.delete(Long.valueOf(deleteId));
        boolean result = applicationTypeRepository.exists(Long.valueOf(deleteId));
        if (!result)
            responseEntity = new ResponseEntity<>(HttpStatus.OK);
        else {
            responseEntity = new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
        return responseEntity;
    }


//    @RequestMapping(value = "/deleteSystemMonitor/{monitorId}", method = RequestMethod.POST)
//    @ResponseBody
//    public ResponseEntity<Void> deleteSystemMonitor(
//            @PathVariable("monitorId") String monitorId) {
//
//        ResponseEntity<Void> responseEntity = null;
//
//        if (StringUtils.isBlank(monitorId)) {
//            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
//        }
//
//        repository.delete(monitorId);
//        boolean result = repository.exists(monitorId);
//
//        if (!result)
//            responseEntity = new ResponseEntity<>(HttpStatus.OK);
//        else {
//            responseEntity = new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
//        }
//
//        return responseEntity;
//    }

//    @RequestMapping(value = "/testSystemMonitor", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public ResponseEntity<Void> testSystemMonitor(
//            @RequestBody SystemMonitorApp testMonitor) {
//        ResponseEntity<Void> responseEntity;
//
//        if (testMonitor == null)
//            responseEntity = new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
//
//        boolean result = false;
//
//        if (testMonitor.getType().equals("Server"))
//            result = monitorService.isHostReachable(testMonitor);
//        else if (testMonitor.getType().equals("WebSite")) {
//            result = monitorService.isWebAppStatusLive(testMonitor);
//        } else if (testMonitor.getType().equals("WebService")) {
//            result = monitorService.isWebServiceAppStatusLive(testMonitor);
//        }
//        if (result)
//            responseEntity = new ResponseEntity<>(HttpStatus.OK);
//        else {
//            responseEntity = new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
//        }
//        // repository.save(app);
//        return responseEntity;
//    }
}