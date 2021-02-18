package com.tech.learn.model;

import javax.persistence.*;

@Entity
@Table(name = "courses")
public class Courses
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "ownerid")
    private long ownerid;

    @Column(name = "coursetype")
    private long coursetype;

    @Column(name = "coursename")
    private String coursename;

    @Column(name = "coursegrade")
    private String coursegrade;

    @Column(name = "coursesubject")
    private String coursesubject;

    @Column(name = "courseprice")
    private String courseprice;

    @Column(name = "coursedetails")
    private String coursedetails;

    public long getId()
    {
        return id;
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public long getOwnerid()
    {
        return ownerid;
    }

    public void setOwnerid(long ownerid)
    {
        this.ownerid = ownerid;
    }

    public long getCoursetype()
    {
        return coursetype;
    }

    public void setCoursetype(long coursetype)
    {
        this.coursetype = coursetype;
    }

    public String getCoursename()
    {
        return coursename;
    }

    public void setCoursename(String coursename)
    {
        this.coursename = coursename;
    }

    public String getCoursegrade()
    {
        return coursegrade;
    }

    public void setCoursegrade(String coursegrade)
    {
        this.coursegrade = coursegrade;
    }

    public String getCoursesubject()
    {
        return coursesubject;
    }

    public void setCoursesubject(String coursesubject)
    {
        this.coursesubject = coursesubject;
    }

    public String getCourseprice()
    {
        return courseprice;
    }

    public void setCourseprice(String courseprice)
    {
        this.courseprice = courseprice;
    }

    public String getCoursedetails()
    {
        return coursedetails;
    }

    public void setCoursedetails(String coursedetails)
    {
        this.coursedetails = coursedetails;
    }
}