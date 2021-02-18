package com.tech.learn.controller;

import com.tech.learn.model.Courses;
import com.tech.learn.repo.CoursesRepository;
import com.tech.learn.repo.UserCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class CoursesController
{
    @Autowired
    CoursesRepository repository;
    
     @Autowired
     UserCourseRepository UserCourseRepository;


    @RequestMapping(value = "/getallcourses", method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Courses> getCourses()
    {
        return repository.findAll();
    }


    @RequestMapping(value = "/getcoursebyid/{id}", method = RequestMethod.GET)
    public Courses getCourse(@PathVariable long id)
    {
        return (Courses) repository.findById(id);
    }

    @RequestMapping(value = "/getteachercourses/{ownerid}", method = RequestMethod.GET)
    public Iterable<Courses> getCoursesByOwnerId(@PathVariable long ownerid)
    {
        return repository.findAllByUserId(ownerid);
    }

    @RequestMapping(value = "/addcourse", method = RequestMethod.POST)
    public long addCourse(@RequestBody Courses courses)
    {
        Courses newCourses = repository.save(courses);
        return newCourses.getId();
    }

    @RequestMapping(value = "/editcourse", method = RequestMethod.PUT)
    public long updateCourse(@RequestBody Courses courses)
    {
        Courses newCases = repository.save(courses);
        return newCases.getId();
    }

}
