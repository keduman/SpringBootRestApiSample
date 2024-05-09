package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class StudentRestController {

    @Autowired
    StudentDao dao;

    @RequestMapping("/")
    @ResponseBody
    public String welcome(){
        return "Welcome to Student rest service page";
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public List<Student> getStudents(){
        return dao.getAllStudents();
    }

    @RequestMapping(value = "/students/{regNumber}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public Student getStudent(@PathVariable("regNumber") String regNumber){
        return dao.getStudent(regNumber);
    }

    @RequestMapping(value = "/students", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Student addStudent(@RequestBody Student student) {
        return dao.addStudent(student);
    }

    @RequestMapping(value = "students/{regNumber}", //
            method = RequestMethod.DELETE, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public void deleteStudent(@PathVariable("regNumber") String regNumber) {

        dao.deleteStudent(regNumber);
    }

    @RequestMapping(value = "/cache", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    public Map<String, Student> getCache(){
        return dao.getCacheContent();
    }
}
