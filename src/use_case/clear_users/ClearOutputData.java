package use_case.clear_users;

public class ClearOutputData {
    private String message = "Following users been deleted: \n";

    public ClearOutputData(String[] usernames) {
        for (String username : usernames) {
            this.message = message.concat(username + "\n");
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
