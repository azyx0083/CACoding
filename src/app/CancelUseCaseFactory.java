package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.cancel.CancelController;
import interface_adapter.cancel.CancelPresenter;
import interface_adapter.menu.MenuViewModel;
import use_case.cancel.CancelInputBoundary;
import use_case.cancel.CancelInteractor;
import use_case.cancel.CancelOutputBoundary;

public class CancelUseCaseFactory {
    private CancelUseCaseFactory() {}

    public static CancelController createCancelController(ViewManagerModel viewManagerModel, MenuViewModel menuViewModel) {
        CancelOutputBoundary cancelOutputBoundary = new CancelPresenter(menuViewModel, viewManagerModel);
        CancelInputBoundary cancelInputBoundary = new CancelInteractor(cancelOutputBoundary);
        return new CancelController(cancelInputBoundary);
    }
}
