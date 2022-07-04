package com.NDRLite.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "subcategories")
public class Subcategories extends NDRLiteTransactionEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "CATEGORIES")
    private Categories categories;
    @Column(name = "NAME")
    private String name;
    public boolean isNew() {
        return id == null;
    }
}
