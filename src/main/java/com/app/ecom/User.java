package com.app.ecom;

import jakarta.validation.constraints.Pattern;
import lombok.Generated;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;
import jakarta.validation.constraints.NotBlank;

@Data
@Document(collection = "users")
public class User {
    @Id

    private String id;
    private Long serialId;
    @NotBlank(message = "First name is required")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "First name must contain only letters")
    private String firstName;
    @NotBlank(message = "Last name is required")
    private String lastName;
}