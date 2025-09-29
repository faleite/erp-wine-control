package database.dao;

import database.model.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    private Connection connection;

    private String selectByUserAndPassword = "SELECT * FROM usuarios WHERE usuario = ? AND senha = ?";
    private PreparedStatement pstSelectByUserAndPassword;

    public UserDAO(Connection connection) throws SQLException {
        this.connection = connection;
        pstSelectByUserAndPassword = this.connection.prepareStatement(selectByUserAndPassword);
    }

    public boolean selectByUserAndPassword(UserModel userModel) throws SQLException {

        pstSelectByUserAndPassword.setString(1, userModel.getUsuario()); // 1 = primeiro ?
        pstSelectByUserAndPassword.setString(2, userModel.getSenha()); // 2 = segundo ?
        ResultSet result = pstSelectByUserAndPassword.executeQuery();
        return result != null && result.next();
    }
}
