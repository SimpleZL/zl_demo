package com.zl.spring.data.jpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *
 * @author: liangzhang212928
 * @Date: 2019-07-10
 */
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "verify_cert_info")
public class VerityCertModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "cert_name")
    private String cert_name;
    @Column(name = "cert_number")
    private String cert_number;
    @Column(name = "create_time")
    private Date create_time;
    @Column(name = "modify_time")
    private Date modify_time;
}
