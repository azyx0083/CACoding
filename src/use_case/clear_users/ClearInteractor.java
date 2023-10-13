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
            String[] usernames = userDataAccessObject.clear();
            ClearOutputData clearOutputData = new ClearOutputData(usernames);
            clearPresenter.prepareSuccessView(clearOutputData);
        }
    }
}
