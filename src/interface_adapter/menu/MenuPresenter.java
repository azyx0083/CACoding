package interface_adapter.menu;

import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupState;
import interface_adapter.signup.SignupViewModel;
import use_case.menu.MenuOutputBoundary;

public class MenuPresenter implements MenuOutputBoundary {
    private final LoginViewModel loginViewModel;

    private final SignupViewModel signupViewModel;

    private ViewManagerModel viewManagerModel;


    public MenuPresenter(LoginViewModel loginViewModel, SignupViewModel signupViewModel, ViewManagerModel viewManagerModel) {
        this.loginViewModel = loginViewModel;
        this.signupViewModel = signupViewModel;
        this.viewManagerModel = viewManagerModel;
    }


    @Override
    public void prepareLoginView() {
        this.loginViewModel.setState(new LoginState());
        this.loginViewModel.firePropertyChanged();
        this.viewManagerModel.setActiveView(loginViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareSignupView() {
        signupViewModel.setState(new SignupState());
        signupViewModel.firePropertyChanged();
        viewManagerModel.setActiveView(signupViewModel.getViewName());
        viewManagerModel.firePropertyChanged();
    }
}
