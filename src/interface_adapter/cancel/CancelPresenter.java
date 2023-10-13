package interface_adapter.cancel;

import interface_adapter.ViewManagerModel;
import interface_adapter.menu.MenuViewModel;
import use_case.cancel.CancelOutputBoundary;

public class CancelPresenter implements CancelOutputBoundary {
    private final MenuViewModel menuViewModel;

    private final ViewManagerModel viewManagerModel;

    public CancelPresenter(MenuViewModel menuViewModel, ViewManagerModel viewManagerModel) {
        this.menuViewModel = menuViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareView() {
        viewManagerModel.setActiveView(menuViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}
