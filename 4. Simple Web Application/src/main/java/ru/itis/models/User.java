package ru.itis.models;


import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * 02.10.2020
 * 4. Simple Web Application
 *
 * @author Sidikov Marsel (First Software Engineering Platform)
 * @version v1.0
 */
@Builder
@Getter
@EqualsAndHashCode
public class User {
    private Long id;
    private String name;
    private String lastName;
    private String login;
    private String password;

}
