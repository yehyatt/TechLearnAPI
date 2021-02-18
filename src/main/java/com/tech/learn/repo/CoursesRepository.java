package com.tech.learn.repo;

import com.tech.learn.model.Courses;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface CoursesRepository extends CrudRepository<Courses, Long>
{

    Courses findById(long id);

    void delete(Courses courses);

    @Query("SELECT t FROM Courses t"
            + " order by t.id desc"
    )
    List<Courses> findAll();


    @Query("SELECT t FROM Courses t"
            + " where t.ownerid = :UserId"
            + " order by t.id desc"
    )
    List<Courses> findAllByUserId(long UserId);





}

