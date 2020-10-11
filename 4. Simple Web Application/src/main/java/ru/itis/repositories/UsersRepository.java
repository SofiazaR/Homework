package ru.itis.repositories;

import ru.itis.models.User;

import java.sql.SQLException;
import java.util.List;

/**
 * 02.10.2020
 * 4. Simple Web Application
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface UsersRepository extends CrudRepository<User> {
    @Override
    List<User> findAll();
    @Override
    void save(User entity);
}

