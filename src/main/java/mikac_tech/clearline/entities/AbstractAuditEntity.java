package mikac_tech.clearline.entities;

import java.sql.Date;
import java.time.Instant;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.EntityListeners;


@EntityListeners(AuditingEntityListener.class)
public class AbstractAuditEntity {
    
    @CreatedDate 
    private Instant createdAt;

    @CreatedBy 
    private String createdBy;

    @LastModifiedBy
    private String modifiedBy;

    @LastModifiedDate
    private Instant modifiedAt;

}
