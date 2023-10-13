package app;

import data_access.FileUserDataAccessObject;
import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginViewModel;
import interface_adapter.menu.MenuController;
import interface_adapter.menu.MenuPresenter;
import interface_adapter.signup.SignupController;
import interface_adapter.signup.SignupViewModel;
import use_case.menu.MenuInputBoundary;
import use_case.menu.MenuInteractor;
import use_case.menu.MenuOutputBoundary;
import view.MenuView;

public class MenuUseCaseFactory {
    private MenuUseCaseFactory() {}

    public static MenuView create(LoginViewModel loginViewModel,
                           SignupViewModel signupViewModel,
                           ViewManagerModel viewManagerModel) {
        MenuController menuController = createMenuController(viewManagerModel, loginViewModel, signupViewModel);
        return new MenuView(menuController);
    }

    private static MenuController createMenuController(ViewManagerModel viewManagerModel, LoginViewModel loginViewModel, SignupViewModel signupViewModel) {
        MenuOutputBoundary menuOutputBoundary = new MenuPresenter(loginViewModel, signupViewModel, viewManagerModel);
        MenuInputBoundary menuInputBoundary = new MenuInteractor(menuOutputBoundary);
        return new MenuController(menuInputBoundary);
    }
}
