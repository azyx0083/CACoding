package interface_adapter.cancel;

import use_case.cancel.CancelInputBoundary;

public class CancelController {
    private final CancelInputBoundary cancelInteractor;

    public CancelController(CancelInputBoundary cancelInteractor) {
        this.cancelInteractor = cancelInteractor;
    }

    public void execute() {
        cancelInteractor.execute();
    }
}
