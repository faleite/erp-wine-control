package graphic;

import database.ConnectionFactory;
import database.dao.UserDAO;
import database.model.UserModel;
import util.HashUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.SQLException;

public class LoginWindow extends JFrame {

    private JLabel lblTitle, lblUser, lblPassword;
    private JTextField txtUser;
    private JPasswordField txtPassword;
    private JButton btnEnter;

    public LoginWindow() {
        setTitle("Login Screen");
        setSize(300, 200);
        setLocationRelativeTo(null); // Centraliza a tela no monitor
        setDefaultCloseOperation(EXIT_ON_CLOSE); // Ao clicar em fechar o Sistema mata o processo na maquína
        setLayout(null); // defini que devera posicionar os componentes manualmente
        createComponents();
        setVisible(true);
    }

    private void createComponents(){
        lblTitle = new JLabel("Wine System");
        lblTitle.setBounds(65, 10, 280, 30);
        lblTitle.setFont(new Font(Font.MONOSPACED, Font.BOLD, 26));
        getContentPane().add(lblTitle);

        lblUser = new JLabel("User:");
        lblUser.setBounds(20, 50, 80, 30);
        getContentPane().add(lblUser);

        txtUser = new JTextField();
        txtUser.setBounds(90, 50, 190, 30);
        getContentPane().add(txtUser);

        lblPassword = new JLabel("Password:");
        lblPassword.setBounds(20, 90, 80, 30);
        getContentPane().add(lblPassword);

        txtPassword = new JPasswordField();
        txtPassword.setBounds(90, 90, 190, 30);
        getContentPane().add(txtPassword);

        btnEnter = new JButton(new AbstractAction("ENTER") {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = txtUser.getText();
                String password = new String(txtPassword.getPassword());

                if (user.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Field <User> mandatory!");
                    txtUser.requestFocus();
                    return;
                }
                if (password.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Field <Password> mandatory!");
                    txtPassword.requestFocus();
                    return;
                }

                //JOptionPane.showMessageDialog(null, "Successfully logged in");
                try {
                    Connection conection = ConnectionFactory.getConnection(
                            "localhost", 5432, "controlevinhos", "postgres", "admin");
                    if (conection != null) {

                        UserModel userModel = new UserModel();
                        userModel.setUsuario(user);
                        userModel.setSenha(HashUtils.MD5create(password));

                        UserDAO userDAO = new UserDAO(conection);
                        if (!userDAO.selectByUserAndPassword(userModel)){
                            JOptionPane.showMessageDialog(null, "Invalid user or password!");
                            return;
                        }
                        JOptionPane.showMessageDialog(null, "Successfully logged in!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Connection failure!");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null,
                            "Could not connect to database" + ex.getMessage());
                }
            }
        });
        btnEnter.setBounds(90, 130, 190, 30);
        getContentPane().add(btnEnter);
    }

    public static void main(String[] args) {
        new LoginWindow();
    }
}
