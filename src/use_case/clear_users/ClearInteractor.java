package use_case.clear_users;


public class ClearInteractor implements ClearInputBoundary{

    final ClearUserDataAccessInterface userDataAccessObject;

    final ClearOutputBoundary clearPresenter;

    public ClearInteractor(ClearUserDataAccessInterface userDataAccessObject,
                           ClearOutputBoundary clearPresenter) {
        this.userDataAccessObject = userDataAccessObject;
        this.clearPresenter = clearPresenter;
    }

    @Override
    public void execute() {
        if (userDataAccessObject.empty()) {
            clearPresenter.prepareFailView("No user exist.");
        } else {
            userDataAccessObject.clear();
            clearPresenter.prepareSuccessView("All users deleted.");
        }
    }
}
