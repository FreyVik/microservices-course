package com.freyvik.agenda.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Contact {
    Long idContacto;
    String name;
    String email;
    Integer age;
}
