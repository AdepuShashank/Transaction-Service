package com.Adepu.Transaction.Service.Service;

import com.Adepu.Transaction.Service.Model.UserAccount;
import com.Adepu.Transaction.Service.Repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class AccountService {
    AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }



    public UserAccount getAccountBalance(Long id) throws Exception{
        Optional<UserAccount> account = repository.findById(id);
        if(account.isEmpty()){
            throw new Exception("no account found");
        }
        else{
            UserAccount balance = account.get();
            balance.getBalance();
            return balance;
        }

    }

    public UserAccount depositAmount(Long id,int amount) throws Exception{

       UserAccount account = repository.findById(id)
               .orElseThrow(() -> new Exception("no account found"));


        int total =account.getBalance()+ amount ;
        account.setBalance(total);
        repository.save(account);
        return account;
    }

    public UserAccount withdrawAmount(Long id, int amount) throws Exception{
        UserAccount balance = getAccountBalance(id);

        if(balance.getBalance() < amount){
            throw new Exception("insufficient balance");
        }
        else{
            int total = balance.getBalance() - amount;
            balance.setBalance(total);
            repository.save(balance);
            return balance;
        }
    }

    public UserAccount transferMoney(Long id,int amount,Long otherId) throws Exception{
        UserAccount balance = getAccountBalance(id);
        UserAccount otherBalance = getAccountBalance(otherId);
        if(balance.getBalance() < amount){
            throw new Exception("insufficient balance");
        }
        else{
            int total = balance.getBalance() - amount;
            balance.setBalance(total);

            int otherTotal = otherBalance.getBalance() + amount;
            otherBalance.setBalance(otherTotal);
            repository.save(otherBalance);
            repository.save(balance);
            return balance;
        }
    }
}
