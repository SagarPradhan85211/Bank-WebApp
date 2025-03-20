package com.example.bank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {

    @Autowired
    private service bank;

    @PostMapping("/create")
    public String createaccount(@RequestParam String accountno, @RequestParam String name, @RequestParam String phone) {

        return bank.createaccount(accountno, name, phone);
    }

    @GetMapping("/deposite")
    public String deposite(@RequestParam String accountno, @RequestParam double amount) {
        return bank.deposite(accountno, amount);
    }

    @GetMapping("/withdraw")
    public String withdraw(@RequestParam String accountno, @RequestParam double amount) {
        return bank.withdraw(accountno, amount);
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam String accountno) {
        return bank.delete(accountno);
    }
    @GetMapping("/details")
    public ResponseEntity<?> getDetails(@RequestParam String accountno) {
        account acc = bank.getDetails(accountno);
        if (acc == null) {
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Account not found");
        }
        return ResponseEntity.ok(acc);
    }

    @PostMapping("/update")
    public String update(@RequestParam String accountno ,@RequestParam String name, @RequestParam String phone) {
        return bank.update(accountno, name, phone);
    }

    

}
