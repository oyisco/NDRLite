package com.NDRLite.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Data;
import lombok.ToString;
import org.springframework.data.domain.Persistable;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@ToString(of = "name")
@Table(name = "facility")
public class Facility implements Serializable, Persistable<Long> {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Long id;
    @NotNull
    @Basic(optional = false)
    private String name;
    @JsonIgnore
    private String address;
    @JsonIgnore
    private Boolean active;
    @JsonIgnore
    private String datimId;
    @Override
    @JsonIgnore
    public boolean isNew() {
        return id == null;
    }
}
