package com.tech.learn.controller;

import ch.qos.logback.core.joran.conditional.ElseAction;
import com.tech.learn.model.Courses;
import com.tech.learn.model.UserCourse;
import com.tech.learn.repo.UserCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserCourseController
{
    @Autowired
    UserCourseRepository repository;

    @RequestMapping(value = "/getstudentcourses/{id}", method = RequestMethod.GET)
    public Iterable<Courses> getStudentCoursesById(@PathVariable long id)
    {
        return repository.getCoursesByStudentId(id);
    }

    @RequestMapping(value = "/addstudenttocourse", method = RequestMethod.POST)
    public ResponseEntity<?> addStudentToCourse(@RequestBody UserCourse userCourse)
    {
        //todo check if course exist
        //todo check if student exist
        if(repository.getUserCoursesByCourseidAndUserid(userCourse.getCourseid(),userCourse.getUserid()).isEmpty())
        {
            UserCourse newCourses = repository.save(userCourse);
            return new ResponseEntity<>(newCourses, HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(userCourse, HttpStatus.ALREADY_REPORTED);
        }
    }


    @Transactional
    @RequestMapping(value = "/removestudentfromcourse", method = RequestMethod.POST)
    public  ResponseEntity<?> removeStudentFromCourse(@RequestBody UserCourse userCourse)
    {
        if(repository.getUserCoursesByCourseidAndUserid(userCourse.getCourseid(),userCourse.getUserid()).isEmpty())
        {
            return new ResponseEntity<>(userCourse, HttpStatus.NO_CONTENT);
        } else
        {
            repository.deleteUserCourseByCourseidAndUserid(userCourse.getCourseid(), userCourse.getUserid());
            return new ResponseEntity<>(userCourse, HttpStatus.OK);

        }
    }

}
