package com.example.TestCase3.services;

import com.example.TestCase3.dto.request.AddKaryawanRequest;
import com.example.TestCase3.dto.request.DeleteKaryawanRequest;
import com.example.TestCase3.dto.request.UpdateKaryawanRequest;
import com.example.TestCase3.dto.response.KaryawanResponse;
import com.example.TestCase3.models.KaryawanModel;

import java.util.List;

public interface IKaryawanService {
    List<KaryawanResponse> addKaryawan(List<AddKaryawanRequest> karyawanRequests);

    List<KaryawanResponse> updateKaryawan(List<UpdateKaryawanRequest> karyawanRequest);

    void deleteKaryawan(List<DeleteKaryawanRequest> deleteKaryawanRequests);

    List<KaryawanModel> getAllKaryawan();
}
