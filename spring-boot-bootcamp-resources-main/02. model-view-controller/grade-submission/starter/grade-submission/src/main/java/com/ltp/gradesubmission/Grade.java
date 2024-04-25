package com.ltp.gradesubmission;


import java.util.UUID;

import static java.util.UUID.*;

public class Grade
{
    private String name;
    private String subject;
    private String score;
    private String Id;

//    public Grade(final String name,
//                 final String subject,
//                 final String score) {
//        this.name = name;
//        this.subject = subject;
//        this.score = score;
//    }

    /**
     * overwritten constructor
     * @return
     */
    public Grade()
    {
       this.Id = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }
}
