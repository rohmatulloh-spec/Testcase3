package com.example.TestCase3.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TestCase3.models.KaryawanModel;

@Repository
public interface KaryawanRepository extends JpaRepository<KaryawanModel, Long> {
    List<KaryawanModel> findByIsDeletedFalse();
}
