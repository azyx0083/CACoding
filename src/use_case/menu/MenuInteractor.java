package use_case.menu;

public class MenuInteractor implements MenuInputBoundary{

    private final MenuOutputBoundary menuPresenter;


    public MenuInteractor(MenuOutputBoundary menuPresenter) {
        this.menuPresenter = menuPresenter;
    }

    public void execute(String usecase) {
        if (usecase.equals("login")) {
            menuPresenter.prepareLoginView();
        } else {
            menuPresenter.prepareSignupView();
        }
    }
}
