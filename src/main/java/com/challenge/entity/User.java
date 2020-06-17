package com.challenge.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; 

    @NotNull
    @Size(max = 100)
    @Column(name = "full_name")
    private String fullName;

    @Email
    @NotNull
    @Size(max = 100)
    @Column(unique = true)
    private String email;

    @NotNull
    @Size(max = 50)
    @Column(name = "nickname")
    private String nickName;

    @NotNull
    @Size(max = 255)
    private String password;

    @CreatedDate
    @NotNull
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    
    @OneToMany //(mappedBy = "userId")
    private Set<Candidate> candidacies;

    @OneToMany //(mappedBy = "userId")
    private Set<Submission> userSubmissions;
    
    public User(){}
}