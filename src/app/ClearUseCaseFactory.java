package app;

import interface_adapter.clear_users.ClearController;
import interface_adapter.clear_users.ClearPresenter;
import interface_adapter.clear_users.ClearViewModel;
import interface_adapter.signup.SignupViewModel;
import use_case.clear_users.ClearInputBoundary;
import use_case.clear_users.ClearInteractor;
import use_case.clear_users.ClearOutputBoundary;
import use_case.clear_users.ClearUserDataAccessInterface;

import java.io.IOException;

public class ClearUseCaseFactory {
    private ClearUseCaseFactory() {}

    public static ClearController createUserClearUseCase(SignupViewModel signupViewModel,
                                                         ClearUserDataAccessInterface clearUserDataAccessInterface)
    throws IOException {
        ClearOutputBoundary clearOutputBoundary = new ClearPresenter(signupViewModel);

        ClearInputBoundary clearInputBoundary = new ClearInteractor(clearUserDataAccessInterface, clearOutputBoundary);

        return new ClearController(clearInputBoundary);
    }
}
