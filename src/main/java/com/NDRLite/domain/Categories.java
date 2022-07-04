package com.NDRLite.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "categories")
public class Categories extends NDRLiteTransactionEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "MODULE_ID")
    private Module module;
    @Column(name = "NAME")
    private String name;
    public boolean isNew() {
        return id == null;
    }
}
