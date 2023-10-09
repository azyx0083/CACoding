package interface_adapter.clear_users;

public class ClearState {
    private String deleteError = null;

    public ClearState() {
    }

    public void setDeleteError(String deleteError) {
        this.deleteError = deleteError;
    }

    public String getDeleteError() {
        return deleteError;
    }
}
