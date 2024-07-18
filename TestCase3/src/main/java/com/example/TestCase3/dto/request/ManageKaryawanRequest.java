package com.example.TestCase3.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ManageKaryawanRequest {
    private String action;
    private Object data;
}
