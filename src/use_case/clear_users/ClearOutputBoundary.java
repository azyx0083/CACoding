package use_case.clear_users;

public interface ClearOutputBoundary {
    void prepareFailView(String error);

    void prepareSuccessView(String message);
}
