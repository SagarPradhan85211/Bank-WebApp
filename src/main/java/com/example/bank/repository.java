package com.example.bank;

// import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface repository extends JpaRepository<account,Long>{

    // Optional<account> findByAccountNo(String accountno);
    // boolean existsByaccno(String accountno);

    account findByAccountNo(String accountNo);
    
}
