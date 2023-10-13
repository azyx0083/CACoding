package view;

import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInState;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.login.LoginController;
import interface_adapter.login.LoginViewModel;
import interface_adapter.logout.LogoutController;
import interface_adapter.logout.LogoutState;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class LoggedInView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName = "logged in";
    private final LoggedInViewModel loggedInViewModel;

    private final LoginViewModel loginViewModel;

    private final LogoutController logoutController;

    private ViewManagerModel viewManagerModel;

    JLabel username;

    final JButton logOut;

    /**
     * A window with a title and a JButton.
     */
    public LoggedInView(LoggedInViewModel loggedInViewModel,
                        LoginViewModel loginViewModel,
                        LogoutController logoutController,
                        ViewManagerModel viewManagerModel) {
        this.loggedInViewModel = loggedInViewModel;
        this.loginViewModel = loginViewModel;
        this.logoutController = logoutController;
        this.viewManagerModel = viewManagerModel;
        this.loggedInViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Logged In Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel usernameInfo = new JLabel("Currently logged in: ");
        username = new JLabel();

        JPanel buttons = new JPanel();
        logOut = new JButton(loggedInViewModel.LOGOUT_BUTTON_LABEL);
        buttons.add(logOut);

        logOut.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (e.getSource().equals(logOut)) {
                            logoutController.execute();
                        }
                    }
                }
        );

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(usernameInfo);
        this.add(username);
        this.add(buttons);
    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        LoggedInState state = (LoggedInState) evt.getNewValue();
        username.setText(state.getUsername());
    }
}