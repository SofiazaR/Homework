package ru.itis.repositories;

import ru.itis.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 02.10.2020
 * 4. Simple Web Application
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class UsersRepositoryJdbcImpl implements UsersRepository {
    private static final String SQL_SELECT_ALL_FROM_USERS = "select id,name,last_name from users ";

    private Connection connection;

    public UsersRepositoryJdbcImpl(Connection connection) {
        this.connection = connection;
    }

    public void save(User entity) {
        //language=sql
        String sqlInsertUser = "insert into users (name,last_name,login,password)values(?,?,?,?)";
        try {
            Statement steatement = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInsertUser);
            preparedStatement.setString(1,entity.getName());
            preparedStatement.setString(2,entity.getLastName());
            preparedStatement.setString(3, entity.getLogin());
            preparedStatement.setString(4, entity.getPassword());

            preparedStatement.executeUpdate();

        } catch (SQLException throwables) {
            throw new IllegalStateException(throwables);
        }

    }
    @Override
    public List<User> findAll() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_FROM_USERS);

            List<User> result = new ArrayList<>();

            while (resultSet.next()) {
                User user =  User.builder()
                        .id(resultSet.getLong("id"))
                        .name(resultSet.getString("name"))
                        .lastName(resultSet.getString("last_name"))
                        .build();
                result.add(user);
            }

            return result;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }


}
