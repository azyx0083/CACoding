package interface_adapter.logout;

import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;
import use_case.logout.LogoutOutputBoundary;

public class LogoutPresenter implements LogoutOutputBoundary {
    private final LoggedInViewModel loggedInViewModel;

    private final LoginViewModel loginViewModel;

    private ViewManagerModel viewManagerModel;

    public LogoutPresenter(LoggedInViewModel loggedInViewModel, LoginViewModel loginViewModel, ViewManagerModel viewManagerModel) {
        this.loggedInViewModel = loggedInViewModel;
        this.loginViewModel = loginViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareView() {
        LoginState loginState = new LoginState();
        loginState.setUsername(loggedInViewModel.getState().getUsername());
        this.loginViewModel.setState(loginState);
        this.loginViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(loginViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();

    }
}
