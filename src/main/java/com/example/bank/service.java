
package com.example.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class service {

    @Autowired
    private repository repo;

    public String createaccount(String accountno, String name, String phone) {

        account account = repo.findByAccountNo(accountno);
        if (account != null) {
            return ("Account Number Already exists");
        }
        account acc = new account();
        acc.setAccountNo(accountno);
        acc.setName(name);
        acc.setPhone(phone);
        acc.setBalance(0.0);
        repo.save(acc);
        return "Account created successfully";
    }

    public String deposite(String accountno, double amount) {

        account acc = repo.findByAccountNo(accountno);
        if (ac == null) {
            return "Account not found";
        }
        if (amount <= 0) {
            return ("Please enter valid amount");
        } else {
            acc.setBalance(acc.getBalance() + amount);
            repo.save(acc);
            return "Deposite successfully";

        }
    }

    public String withdraw(String accountno, double amount) {

        account acc = repo.findByAccountNo(accountno);
        if (acc == null) {
            return "Account not found";
        }

        if (amount <= 0) {
            return "please enter valid amount";
        } else {
            if (acc.getBalance() < amount) {
                return "Insufficient Balance";
            } else {
                acc.setBalance(acc.getBalance() - amount);
            }

            repo.save(acc);
            return "withdraw Successfull";
        }
    }

    public String update(String accountno, String name, String phone) {
        account acc = repo.findByAccountNo(accountno);
        if (acc == null) {
            return "Account not found";
        }
        acc.setName(name);
        acc.setPhone(phone);
        repo.save(acc);
        return "Update Successfully";
    }

    public account getDetails(String accountno) {
        account acc = repo.findByAccountNo(accountno);
        if (acc == null) {
            return null;
        }
        return acc;
    }

    public String delete(String accountno) {
        account acc = repo.findByAccountNo(accountno);
        if (acc == null) {
            return "Account not found";
        }
        if(acc.getBalance()>0){
           return "Please Withraw all money first";
        }
        repo.delete(acc);
        return "Deleted Successfully";
    }
}
