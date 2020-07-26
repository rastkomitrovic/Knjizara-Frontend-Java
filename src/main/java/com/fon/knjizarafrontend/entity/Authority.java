package com.fon.knjizarafrontend.entity;

import lombok.Data;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "authorities")
@Data
public class Authority {

    @EmbeddedId
    private AuthorityEmbedded authorityEmbedded;
}
