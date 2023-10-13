package view;

import interface_adapter.menu.MenuController;
import interface_adapter.menu.MenuViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MenuView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName = "menu";

    final JButton signup;

    final JButton login;

    private final MenuController menuController;

    private final MenuViewModel menuViewModel = new MenuViewModel();

    public MenuView(MenuController menuController) {
        this.menuController = menuController;

        JLabel title = new JLabel("Menu Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel button = new JPanel();
        login = new JButton(menuViewModel.LOGIN_BUTTON_LABEL);
        button.add(login);
        signup = new JButton(menuViewModel.SIGNUP_BUTTON_LABEL);
        button.add(signup);

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(login)) {
                    menuController.execute("login");
                }
            }
        });

        signup.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource().equals(signup)) {
                    menuController.execute("signup");
                }
            }

        });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(title);
        this.add(button);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Click " + e.getActionCommand());
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}
