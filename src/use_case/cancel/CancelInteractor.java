package use_case.cancel;

public class CancelInteractor implements CancelInputBoundary{
    private final CancelOutputBoundary cancelPresenter;

    public CancelInteractor(CancelOutputBoundary cancelPresenter) {
        this.cancelPresenter = cancelPresenter;
    }

    @Override
    public void execute() {
        cancelPresenter.prepareView();
    }
}
