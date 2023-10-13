package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.logout.LogoutController;
import interface_adapter.logout.LogoutPresenter;
import use_case.logout.LogoutInputBoundary;
import use_case.logout.LogoutInteractor;
import use_case.logout.LogoutOutputBoundary;
import view.LoggedInView;


public class LogoutUseCaseFactory {
    private LogoutUseCaseFactory() {}

    public static LoggedInView create(LoggedInViewModel loggedInViewModel,
                                   LoginViewModel loginViewModel,
                                   ViewManagerModel viewManagerModel) {
        LogoutController logoutController = createLogoutUseCase(viewManagerModel, loggedInViewModel, loginViewModel);
        return new LoggedInView(loggedInViewModel, loginViewModel, logoutController, viewManagerModel);
    }

    private static LogoutController createLogoutUseCase(
            ViewManagerModel viewManagerModel,
            LoggedInViewModel loggedInViewModel,
            LoginViewModel loginViewModel
    ) {
        LogoutOutputBoundary logoutOutputBoundary = new LogoutPresenter(loggedInViewModel, loginViewModel, viewManagerModel);
        LogoutInputBoundary logoutInputBoundary = new LogoutInteractor(logoutOutputBoundary);
        return new LogoutController(logoutInputBoundary);
    }
}
