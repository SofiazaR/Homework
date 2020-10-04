package ru.itis;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 25.09.2020
 * 2. DB
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public class UsersRepositoryJdbcImpl implements UsersRepository {

    private Connection connection;
    
    private static final String SQL_SELECT_ALL_FROM_DRIVER = "select * from driver";
    private static final String SQL_SELECT_ALL_BY_AGE = "select * from driver where age = ";

    public UsersRepositoryJdbcImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<User> findAllByAge(Integer age) throws SQLException {
        //TODO: реализовать
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_BY_AGE + age);

        List<User> result = new ArrayList<>();

        while (resultSet.next()) {
            User user = new User(
                    resultSet.getLong("id"),
                    resultSet.getString("first_name"),
                    resultSet.getString("last_name"),
                    resultSet.getInt("age"));
            result.add(user);
        }

        return result;
    }

    @Override
    public List<User> findAll() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_FROM_DRIVER);

            List<User> result = new ArrayList<>();

            while (resultSet.next()) {
                User user = new User(
                        resultSet.getLong("id"),
                        resultSet.getString("first_name"),
                        resultSet.getString("last_name"),
                        resultSet.getInt("age"));
                result.add(user);
            }

            return result;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(User entity) {

    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void remove(User entity) {

    }

    @Override
    public void removeById(Long id) {

    }
}
