package com.example.digitinary.dto.request;

import com.example.digitinary.entity.enums.AccountStatus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
class CreateAccountRequestDTOTest {

    private CreateAccountRequestDTO dto;

    @BeforeEach
    public void setUp() {
        dto = new CreateAccountRequestDTO();
        dto.setCreatedBy("admin");
        dto.setModifiedBy("admin");
        dto.setAccountStatus(AccountStatus.ACTIVE);
    }

    @Test
    public void testToString() {
        // When
        String result = dto.toString();

        // Then
        String expected = "CreateAccountRequestDTO{} AccountRequestDTO(customerUUID=null, customerId=null, accountType=null, balance=null, createdBy=admin, modifiedBy=admin, accountStatus=ACTIVE)";
        assertEquals(expected, result);
    }

}
