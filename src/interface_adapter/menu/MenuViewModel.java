package interface_adapter.menu;

import interface_adapter.ViewModel;

import java.beans.PropertyChangeListener;

public class MenuViewModel extends ViewModel {
    public final String LOGIN_BUTTON_LABEL = "log in";

    public final String SIGNUP_BUTTON_LABEL = "sign up";

    public final String CANCEL_BUTTON_LABEL = "cancel";

    public MenuViewModel() {
        super("menu");
    }

    @Override
    public void firePropertyChanged() {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {

    }
}
