package com.tech.learn.repo;


import com.tech.learn.model.Courses;
import com.tech.learn.model.User;
import com.tech.learn.model.UserCourse;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;


@Repository
public interface UserCourseRepository extends CrudRepository<UserCourse, Long>
{

    @Query("SELECT t FROM User t"
            + " where UPPER(t.email) = UPPER(:email) "
            + " and t.password = :password "
    )
    User findUserByEmail(@Param("email") String email, @Param("password") String password);

    @Query("SELECT t FROM User t"
            + " where UPPER(t.email) = UPPER(:email) "
    )
    User findUserByEmailOnly(@Param("email") String email);


    void deleteUserCourseByCourseidAndUserid(long courseid,long userid);



    @Query(nativeQuery = true, value = "SELECT t.id , t.ownerid, t.coursetype, t.coursename, t.coursegrade, t.coursesubject, t.coursedetails, t.courseprice FROM courses t"
            + " INNER JOIN usercourse u"
            + " ON t.id = u.courseid"
            + " where u.userid = :studentid ")
    List<Courses> getCoursesByStudentId(@Param("studentid") long studentid);


    List<UserCourse> getUserCoursesByCourseidAndUserid(long courseId,long userId);

}

