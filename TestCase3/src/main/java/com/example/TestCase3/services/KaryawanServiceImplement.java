package com.example.TestCase3.services;

import com.example.TestCase3.dto.request.AddKaryawanRequest;
import com.example.TestCase3.dto.request.DeleteKaryawanRequest;
import com.example.TestCase3.dto.request.UpdateKaryawanRequest;
import com.example.TestCase3.dto.response.KaryawanResponse;
import com.example.TestCase3.models.KaryawanModel;
import com.example.TestCase3.repositories.KaryawanRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class KaryawanServiceImplement implements IKaryawanService {

    @Autowired
    private KaryawanRepository karyawanRepository;

    @Override
    public List<KaryawanResponse> addKaryawan(List<AddKaryawanRequest> karyawanRequests) {
        
        List<KaryawanModel> karyawanList = new ArrayList<>();

        for (AddKaryawanRequest request : karyawanRequests) {
            KaryawanModel karyawan = new KaryawanModel();
           
            karyawan.setFirstName(request.getFirstName());
            karyawan.setLastName(request.getLastName());
            karyawan.setEmail(request.getEmail());
            karyawan.setAge(request.getAge());
            karyawan.setIsDeleted(false);
           
            karyawanList.add(karyawan);
        }
        List<KaryawanModel> savedKaryawanList = karyawanRepository.saveAll(karyawanList);

        List<KaryawanResponse> responses = new ArrayList<>();
        for (KaryawanModel karyawan : savedKaryawanList) {
            KaryawanResponse response = new KaryawanResponse();
            
            response.setId(karyawan.getId());
            response.setFirstName(karyawan.getFirstName());
            response.setLastName(karyawan.getLastName());
            response.setEmail(karyawan.getEmail());
            response.setAge(karyawan.getAge());
            
            responses.add(response);
        }
        return responses;
    }

    @Override
    @Transactional
    public List<KaryawanResponse> updateKaryawan(List<UpdateKaryawanRequest> karyawanRequests) {
        List<KaryawanResponse> updatedResponses = new ArrayList<>();
        List<String> failedMessages = new ArrayList<>();

        for (UpdateKaryawanRequest karyawanRequest : karyawanRequests) {
            try {
                
                Optional<KaryawanModel> optionalKaryawan = karyawanRepository.findById(karyawanRequest.getId());

               
                KaryawanModel existingKaryawan = optionalKaryawan.orElseThrow(() -> new IllegalArgumentException("Karyawan not found with id: " + karyawanRequest.getId()));

                if (existingKaryawan.getIsDeleted()) {
                    throw new IllegalArgumentException("Karyawan with id " + karyawanRequest.getId() + " has been deleted.");
                }

               
                existingKaryawan.setFirstName(karyawanRequest.getFirstName());
                existingKaryawan.setLastName(karyawanRequest.getLastName());
                existingKaryawan.setEmail(karyawanRequest.getEmail());
                existingKaryawan.setAge(karyawanRequest.getAge());

                KaryawanModel updatedKaryawan = karyawanRepository.save(existingKaryawan);
               
                KaryawanResponse updatedResponse = new KaryawanResponse();
                updatedResponse.setId(updatedKaryawan.getId());
                updatedResponse.setFirstName(updatedKaryawan.getFirstName());
                updatedResponse.setLastName(updatedKaryawan.getLastName());
                updatedResponse.setEmail(updatedKaryawan.getEmail());
                updatedResponse.setAge(updatedKaryawan.getAge());

                updatedResponses.add(updatedResponse);
            } catch (IllegalArgumentException ex) {
              
                failedMessages.add(ex.getMessage());
                
            }
        }

        if (!failedMessages.isEmpty()) {
            throw new IllegalArgumentException("Failed to update karyawan: " + String.join(", ", failedMessages));
        }
        return updatedResponses;
    }

    @Override
    @Transactional
    public void deleteKaryawan(List<DeleteKaryawanRequest> deleteKaryawanRequests) {
        List<String> successMessages = new ArrayList<>();
        List<String> failedMessages = new ArrayList<>();

        for (DeleteKaryawanRequest request : deleteKaryawanRequests) {
            try {
                Optional<KaryawanModel> optionalKaryawan = karyawanRepository.findById(request.getId());
                KaryawanModel karyawan = optionalKaryawan.orElseThrow(() -> new IllegalArgumentException("Karyawan not found with id: " + request.getId()));

                if (karyawan.getIsDeleted()) {
                    throw new IllegalArgumentException("Karyawan with id " + request.getId() + " has already been deleted.");
                }

                karyawan.setIsDeleted(true); 
                karyawanRepository.save(karyawan);

                successMessages.add("Karyawan with id " + karyawan.getId() + ", name " + karyawan.getFirstName() + " " + karyawan.getLastName() + " successfully deleted.");
            } catch (IllegalArgumentException ex) {
                failedMessages.add(ex.getMessage());
            }
        }

        if (!failedMessages.isEmpty()) {
            throw new IllegalArgumentException("Failed to delete karyawan: " + String.join(", ", failedMessages));
        }
    }

    @Override
    public List<KaryawanModel> getAllKaryawan() {
        return karyawanRepository.findByIsDeletedFalse();
    }
}
