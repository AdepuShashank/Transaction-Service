package com.Adepu.Transaction.Service.Controller;

import com.Adepu.Transaction.Service.Model.UserAccount;
import com.Adepu.Transaction.Service.Service.AccountService;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {
    AccountService accountService;
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


    @GetMapping("/balance/{id}")
    public UserAccount getAccountBalance(@PathVariable("id") Long id){
        try {
            UserAccount balance = accountService.getAccountBalance(id);
            return balance;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/deposit/{id}")
    public UserAccount deposit(@PathVariable("id") Long id, @RequestBody UserAccount account){
        try {
            UserAccount deposit;
            deposit =accountService.depositAmount(id,
                    account.getBalance());
            return deposit;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PutMapping("/transfer/{id}/to/{otherId}")
    public UserAccount transfer(@PathVariable Long id,@RequestBody UserAccount account, @PathVariable Long otherId) throws Exception{
        UserAccount balance = accountService.transferMoney(id, account.getBalance(), otherId);
        return balance;
    }

    @PutMapping("/withDraw/{id}")
    public UserAccount withDrawAmount(@PathVariable Long id, @RequestBody UserAccount account) throws Exception{
        UserAccount withDraw;
        withDraw = accountService.withdrawAmount(id , account.getBalance());
        return withDraw;
    }
}
