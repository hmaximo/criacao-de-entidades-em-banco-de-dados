package com.challenge.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Submission implements Serializable{
    
    @EmbeddedId
    private SubmissionId id;

    @NotNull
    private float score;

    @CreatedDate
    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date createdAt;

    @Embeddable
    public class SubmissionId implements Serializable{
        
        @ManyToOne
        @JoinColumn(name = "user_id")
        private User userId;
    
        @ManyToOne
        @JoinColumn(name = "challenge_id")
        private Challenge challengeId;
    }

    public Submission(){}
}