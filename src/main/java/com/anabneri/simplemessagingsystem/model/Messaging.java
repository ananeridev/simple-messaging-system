package com.anabneri.simplemessagingsystem.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Messaging implements Serializable {

    private static final long serialVersionUID = 1L;

    private String namePerson;
    private String message;
    private boolean seen;


}
