package com.example.TestCase3.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.TestCase3.dto.request.AddKaryawanRequest;
import com.example.TestCase3.dto.request.DeleteKaryawanRequest;
import com.example.TestCase3.dto.request.UpdateKaryawanRequest;
import com.example.TestCase3.dto.response.KaryawanResponse;
import com.example.TestCase3.models.KaryawanModel;
import com.example.TestCase3.services.IKaryawanService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("")
public class KaryawanController {
     
    @Autowired
    private IKaryawanService karyawanService;

    @PostMapping("/karyawan")
    @ResponseStatus(HttpStatus.CREATED) 
    public List<KaryawanResponse> addMultipleKaryawan(@RequestBody List<AddKaryawanRequest> karyawanRequests) {
        return karyawanService.addKaryawan(karyawanRequests);
    }

    @PutMapping("/karyawan")
    public List<KaryawanResponse> updateMultipleKaryawan(@RequestBody List<UpdateKaryawanRequest> karyawanRequests) {
        return karyawanService.updateKaryawan(karyawanRequests);
    }

    @GetMapping("/karyawan")
    public List<KaryawanModel> getKaryawanModel() {
        return karyawanService.getAllKaryawan();
    }
    
    @DeleteMapping("/karyawan")
    public void deleteMultipleKaryawan(@RequestBody List<DeleteKaryawanRequest> deleteKaryawanRequests) {
        karyawanService.deleteKaryawan(deleteKaryawanRequests);
    }


    //Test Case
    //Add Karyawan

//   [
//   {
//     "firstName": "John",
//     "lastName": "Doe",
//     "email": "john.doe@example.com",
//     "age": 30
//   },
//   {
//     "firstName": "Jane",
//     "lastName": "Smith",
//     "email": "jane.smith@example.com",
//     "age": 28
//   },
//   {
//     "firstName": "Michael",
//     "lastName": "Johnson",
//     "email": "michael.johnson@example.com",
//     "age": 32
//   }
// ]


//Update Karyawan
// [
//   {
//     "id":1,
//     "firstName": "Update John ",
//     "lastName": "Doe",
//     "email": "john.doe@example.com",
//     "age": 30
//   },
//   {
//     "id":2,
//     "firstName": "Update Jane",
//     "lastName": "Smith",
//     "email": "jane.smith@example.com",
//     "age": 28
//   },
//   {
//     "id":3,
//     "firstName": "Update Michael",
//     "lastName": "Johnson",
//     "email": "michael.johnson@example.com",
//     "age": 32
//   }
// ]

// Update Karyawan Failed id not found
// [
//   {
//     "id":1,
//     "firstName": "Update Jo fail ",
//     "lastName": "Doe",
//     "email": "john.doe@example.com",
//     "age": 30
//   },
//   {
//     "id":2,
//     "firstName": "Update Jane fail",
//     "lastName": "Smith",
//     "email": "jane.smith@example.com",
//     "age": 28
//   },
//   {
//     "id":5,
//     "firstName": "Update Michael fail",
//     "lastName": "Johnson",
//     "email": "michael.johnson@example.com",
//     "age": 32
//   }
// ]


//Delete Karyawan
// [
//   {
//     "id":1
//   },
//   {
//     "id":2
//   },
//   {
//     "id":3
//   }
// ]


//Delete Karyawan Failed id not found
// [
//   {
//     "id":1
//   },
//   {
//     "id":2
//   },
//   {
//     "id":10
//   }
// ]
}
