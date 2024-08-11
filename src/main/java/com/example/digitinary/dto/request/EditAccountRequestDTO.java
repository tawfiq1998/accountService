package com.example.digitinary.dto.request;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
public class EditAccountRequestDTO extends AccountRequestDTO {
    private Long id;

    @Override
    public String toString() {
        return "EditAccountRequestDTO{" +
                "id=" + id +
                "} " + super.toString();
    }
}
