package interface_adapter.clear_users;

import use_case.clear_users.ClearOutputBoundary;

public class ClearPresenter implements ClearOutputBoundary {
    private final ClearViewModel clearViewModel;

    public ClearPresenter(ClearViewModel clearViewModel) {
        this.clearViewModel = clearViewModel;
    }

    @Override
    public void prepareSuccessView() {
        clearViewModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        ClearState clearState = clearViewModel.getState();
        clearState.setDeleteError(error);
        clearViewModel.firePropertyChanged();
    }
}
