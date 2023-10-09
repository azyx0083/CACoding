package use_case.clear_users;


import entity.User;
import interface_adapter.clear_users.ClearState;

public class ClearInteractor implements ClearInputBoundary{
    final ClearUserDataAccessInterface userDataAccessObject;

    final ClearOutputBoundary userPresenter;

    public ClearInteractor(ClearUserDataAccessInterface clearDataAccessObject, ClearOutputBoundary clearOutputBoundary) {
        this.userDataAccessObject = clearDataAccessObject;
        this.userPresenter = clearOutputBoundary;
    }

    @Override
    public void execute() {
        if (userDataAccessObject.empty()) {
            userPresenter.prepareFailView("No user to be delete.");
        } else {
            userDataAccessObject.deleteAll();
            userPresenter.prepareSuccessView();
        }
    }
}
