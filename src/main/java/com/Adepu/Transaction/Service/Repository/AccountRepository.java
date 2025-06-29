package com.Adepu.Transaction.Service.Repository;

import com.Adepu.Transaction.Service.Model.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<UserAccount, Long> {
}
