package com.project.authentication.user_auth_app.model.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "users")
@Setter
@Getter
public class User {
    @Id
    private String id;  //MongoDB usually creates objectID and auto-increments, if you want to use Long type,
                        // then you have to manually keep a numeric counter and increment it for each request.
                        //that's why converted the type from Long to String

    @Field("name")
    private String name;

    @Indexed(unique = true)
    private String email;

    private String password;

}
