package com.example.TestCase3.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddKaryawanRequest {
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
}
