package com.example.digitinary.service.mapper;

import com.example.digitinary.dto.request.AccountRequestDTO;
import com.example.digitinary.dto.request.CreateAccountRequestDTO;
import com.example.digitinary.dto.request.EditAccountRequestDTO;
import com.example.digitinary.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    Account createAccountDTOToCustomer(AccountRequestDTO accountRequestDTO);
}
