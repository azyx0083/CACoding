package interface_adapter.clear_users;

import interface_adapter.signup.SignupState;
import interface_adapter.signup.SignupViewModel;
import use_case.clear_users.ClearOutputBoundary;
import use_case.clear_users.ClearOutputData;

public class ClearPresenter implements ClearOutputBoundary {

    private final SignupViewModel signupViewModel;

    public ClearPresenter(SignupViewModel signupViewModel) {
        this.signupViewModel = signupViewModel;
    }

    @Override
    public void prepareSuccessView(ClearOutputData message) {
        SignupState signupState = signupViewModel.getState();
        signupState.setUsernameError(message.getMessage());
        signupViewModel.firePropertyChanged();
    }

    public void prepareFailView(String error) {
        SignupState signupState = signupViewModel.getState();
        signupState.setUsernameError(error);
        signupViewModel.firePropertyChanged();
    }
}
