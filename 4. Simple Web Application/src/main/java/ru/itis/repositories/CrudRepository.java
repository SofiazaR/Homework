package ru.itis.repositories;

import java.util.List;

/**
 * 02.10.2020
 * 4. Simple Web Application
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
public interface CrudRepository<T> {
    List<T> findAll();
    void save(T entity);
}
