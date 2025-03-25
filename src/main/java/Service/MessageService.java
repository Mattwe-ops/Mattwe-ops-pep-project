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
        Account tempAccount = accountDAO.getAccountById(message.getPosted_by());
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

    public List<Message> getAllMessages(){
        List<Message> messages = new ArrayList<>();
        messages = messageDAO.getAllMessages();
        return messages;
    }

    public Message getMessageById(int message_id){
        return messageDAO.getMessageById(message_id);
    }

    public Message deleteMessage(int message_id, Message message){
        return messageDAO.deleteMessage(message_id, message);
    }

    public Message updateMessage(int message_id, Message message){
        if(messageDAO.getMessageById(message_id) == null){
            return null;
        } else if(message.getMessage_text().isEmpty()){
            return null;
        } else if(message.getMessage_text().length() >= 255){
            return null;
        } else {
            messageDAO.updateMessage(message_id, message);
            Message tempMessage = messageDAO.getMessageById(message_id);
            return tempMessage;
        }
    }

    public List<Message> getAllMessagesFromUser(int account_id){
        List<Message> messages = new ArrayList<>();
        messages = messageDAO.getAllMessagesFromUser(account_id);
        return messages;
    }
}
