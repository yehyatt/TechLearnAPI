package com.tech.learn.repo;


import com.tech.learn.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends CrudRepository<User, Long>
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


    @Query("SELECT t FROM User t"
            + " where t.id = :id "
    )
    User findUserById(@Param("id") long id);



}

