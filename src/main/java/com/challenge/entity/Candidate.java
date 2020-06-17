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
public class Candidate implements Serializable{
    
    @EmbeddedId
    private CandidateId id;

    @NotNull
    private Integer status;

    @CreatedDate
    @NotNull
    @Column(name = "create_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Embeddable
    public class CandidateId implements Serializable{
        
        @ManyToOne
        @JoinColumn(name = "user_id")
        private User userId;

        @ManyToOne
        @JoinColumn(name = "acceleration_id")
        private Acceleration accelerationId;

        @ManyToOne
        @JoinColumn(name = "company_id")
        private Company companyId;
    }

    public Candidate(){}
}