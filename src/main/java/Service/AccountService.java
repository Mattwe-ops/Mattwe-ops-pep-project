package Service;

import Model.Account;
import DAO.AccountDAO;

import java.util.ArrayList;
import java.util.List;

public class AccountService {
    private AccountDAO accountDAO;

    public AccountService(){
        accountDAO = new AccountDAO();
    }

    public AccountService(AccountDAO accountDAO){
        this.accountDAO = accountDAO;
    }

    public Account registerAccount(Account account){
        if(account.getUsername().isEmpty()){
            return null;
        } else if(account.getPassword().length() < 4){
            return null;
        } else if(account == accountDAO.getAccountByUsername(account.getUsername())){
            return null;
        } else {
            /*accountDAO.insertAccount(account);
            Account tempAccount = accountDAO.getAccountByUsername(account.getUsername());
            return tempAccount;*/
            return account.insertAccount(account);
        }
    }

    public Account loginAccount(Account account){
        Account tempA = accountDAO.getAccountByUsername(account.getUsername());
        if( (account.getUsername() == tempA.getUsername()) && (account.getPassword() == tempA.getPassword()) ){
            return tempA;
        } else {
            return null;
        }
    }
}
