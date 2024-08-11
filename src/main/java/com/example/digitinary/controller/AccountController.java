package com.example.digitinary.controller;

import com.example.digitinary.dto.request.BalanceRequestDTO;
import com.example.digitinary.dto.request.CreateAccountRequestDTO;
import com.example.digitinary.dto.request.EditAccountRequestDTO;
import com.example.digitinary.entity.enums.AccountStatus;
import com.example.digitinary.service.AccountService;
import com.example.digitinary.util.ResponseMessage;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;


    @PostMapping("/changeStatus")
    public ResponseEntity<ResponseMessage> changeAccountStatus(@Param("id") Long accountId, @RequestBody AccountStatus status) {
        accountService.changeAccountStatus(accountId,status);
        return ResponseEntity.ok(new ResponseMessage("account status changed successfully"));
    }
    @PostMapping("/addBalance")
    public ResponseEntity<ResponseMessage> addToBalance(@Valid @RequestBody BalanceRequestDTO requestDTO) {
        accountService.addBalance(requestDTO);
        return ResponseEntity.ok(new ResponseMessage("account balance added successfully"));
    }
    @PostMapping("/removeBalance")
    public ResponseEntity<ResponseMessage> removeBalance(@Valid@RequestBody BalanceRequestDTO requestDTO) {
        accountService.removeBalance(requestDTO);
        return ResponseEntity.ok(new ResponseMessage("account balance removed successfully"));
    }
}
