package com.example.digitinary.repository;

import com.example.digitinary.entity.Account;
import com.example.digitinary.entity.enums.AccountStatus;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface AccountRepository extends JpaRepository<Account, Long> {

    @Modifying
    @Query("update Account a set a.accountStatus= ?1 where a.id= ?2")
    void updateAccountStatusById(AccountStatus status,Long id);

    Long countAccountByCustomerUUID(String customerUUID);
}
