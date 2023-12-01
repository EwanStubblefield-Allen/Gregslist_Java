package com.Gregslist_Java.Services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Gregslist_Java.Models.Account;
import com.Gregslist_Java.Repositories.AccountRepository;

@Service
public class AccountService {
  private final AccountRepository accountRepository;

  public AccountService(AccountRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  public Account getOrCreateProfile(Account userInfo) {
    Optional<Account> profileOptional = accountRepository.findById(userInfo.getId());
    if (profileOptional.isEmpty()) {
      return accountRepository.save(userInfo);
    }
    return profileOptional.get();
  }

  public Account getProfileByEmail(String userEmail) {
    return accountRepository.findByEmail(userEmail).get();
  }

  public Account update(Account userInfo) {
    System.out.println("hi" + userInfo.getEmail());
    Account original = getProfileByEmail(userInfo.getEmail());
    original.setName(userInfo.getName().length() > 0 ? userInfo.getName() : original.getName());
    original.setPicture(userInfo.getPicture().length() > 0 ? userInfo.getPicture() : original.getPicture());
    return original;
  }
}
