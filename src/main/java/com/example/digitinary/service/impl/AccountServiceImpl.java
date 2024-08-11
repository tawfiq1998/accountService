package com.example.digitinary.service.impl;

import com.example.digitinary.dto.request.BalanceRequestDTO;
import com.example.digitinary.entity.Account;
import com.example.digitinary.entity.enums.AccountStatus;
import com.example.digitinary.exception.AccountNotFoundException;
import com.example.digitinary.repository.AccountRepository;
import com.example.digitinary.service.AccountService;
import com.example.digitinary.service.mapper.AccountMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
class AccountServiceImpl implements AccountService {
    private final AccountRepository accountRepository;


    @Override
    public void changeAccountStatus(Long id, AccountStatus accountStatus) {
        log.info("Change account status: {} for id: {}", accountStatus, id);
        validateAccountById(id);
        accountRepository.updateAccountStatusById(accountStatus, id);
        log.info("account status changed");
    }

    @Override
    public void addBalance(BalanceRequestDTO balanceRequestDTO) {
        log.info("add balance request: {}", balanceRequestDTO);
        Account account = getAccount(balanceRequestDTO.getAccountId());
        account.setBalance(account.getBalance().add(balanceRequestDTO.getAmount()));
        accountRepository.save(account);
        log.info("account balance added");
    }

    @Override
    public void removeBalance(BalanceRequestDTO balanceRequestDTO) {
        log.info("remove balance request: {}", balanceRequestDTO);

        Account account = getAccount(balanceRequestDTO.getAccountId());
        account.setBalance(account.getBalance().subtract(balanceRequestDTO.getAmount()));
        accountRepository.save(account);

        log.info("account balance removed");
    }

    private Account getAccount(Long id) {
        return accountRepository.findById(id).orElseThrow(() ->
                new AccountNotFoundException("Account with this id not found" + id));
    }

    private void validateAccountById(Long customerId) {
        if (!accountRepository.existsById(customerId)) {
            String errorMessage = String.format("Account with id %d does not exist", customerId);
            log.error(errorMessage);
            throw new AccountNotFoundException(errorMessage);
        }

    }
}