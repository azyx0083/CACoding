package interface_adapter.clear_users;

public class ClearState {
    private String clearMessage = null;

    public ClearState(ClearState copy) {
        clearMessage = copy.clearMessage;
    }

    public ClearState() {
    }

    public String getClearMessage() {
        return clearMessage;
    }

    public void setClearMessage(String clearMessage) {
        this.clearMessage = clearMessage;
    }
}
