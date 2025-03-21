package com.example.bank;

import org.springframework.data.jpa.repository.JpaRepository;

public interface repository extends JpaRepository<account,Long>{

    account findByAccountNo(String accountNo);
    
}
