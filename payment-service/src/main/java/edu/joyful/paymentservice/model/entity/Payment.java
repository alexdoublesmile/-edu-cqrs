package edu.joyful.paymentservice.model.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Payment {

    @Id
    private String paymentId;
    private String orderId;
    private String paymentStatus;
    private Date paymentTimestamp;
}
