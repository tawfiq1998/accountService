package com.example.digitinary.dto.request;

import lombok.*;


@Setter
@Getter
public class CreateAccountRequestDTO extends AccountRequestDTO {
    @Override
    public String toString() {
        return "CreateAccountRequestDTO{} " + super.toString();
    }
}
