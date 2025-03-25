package Service;

import DAO.AccountDAO;
import DAO.MessageDAO;
import Model.Account;
import Model.Message;

import java.util.List;
import java.util.ArrayList;

public class MessageService {
    private MessageDAO messageDAO;
    private AccountDAO accountDAO;

    public MessageService(){
        messageDAO = new MessageDAO();
        accountDAO = new AccountDAO();
    }

    public MessageService(MessageDAO messageDAO, AccountDAO accountDAO){
        this.messageDAO = messageDAO;
        this.accountDAO = accountDAO;
    }

    public Message addMessage(Message message){
        Account tempAccount = accountDAO.getAccountById(message.getMessage_id());
        if(message.getMessage_text().isEmpty()){
            return null;
        } else if(message.getMessage_text().length() >= 255){
            return null;
        } else if(message.getPosted_by() != tempAccount.getAccount_id()){
            return null;
        } else {
            /*messageDAO.insertMessage(message);
            Message tempMessage = messageDAO.()*/
            return messageDAO.insertMessage(message);
        }
    }
}
