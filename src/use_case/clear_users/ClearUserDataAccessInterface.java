package use_case.clear_users;


import entity.User;

public interface ClearUserDataAccessInterface {
    boolean empty();

    void deleteAll();
}
