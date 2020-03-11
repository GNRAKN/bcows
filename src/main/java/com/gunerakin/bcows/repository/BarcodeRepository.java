package com.gunerakin.bcows.repository;

import com.gunerakin.bcows.model.Barcode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarcodeRepository extends JpaRepository<Barcode, Long> {
}
