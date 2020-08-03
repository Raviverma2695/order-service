package com.ravi.orderservice.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * @author Ravi Verma at 01/08/20 10:53 PM
 */
@MappedSuperclass
@Getter
@Setter
public class BaseModel {

    @Column(name = "create_date")
    protected Date createDate;

    @Column(name = "update_date", insertable = false, updatable = false)
    protected Date updateDate;
}