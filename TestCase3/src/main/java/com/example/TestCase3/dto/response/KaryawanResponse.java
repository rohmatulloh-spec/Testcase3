package com.example.TestCase3.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KaryawanResponse {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;
}
