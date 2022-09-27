package com.example.CRUDConValidacion.persona.domain;

import lombok.Data;
import org.springframework.data.domain.Sort;

@Data
public class PersonaPage {
    public int pageNumber = 0;
    public int pageSize = 2;
    public Sort.Direction sortDirection = Sort.Direction.ASC;
    public String sortBy = "name";

    public PersonaPage(int pageNumber, String sortBy) {
        this.pageNumber = pageNumber;
        if (sortBy != null)
            if (sortBy.equals("username"))
                this.sortBy = "username";
    }
}
