package com.gunerakin.bcows.service;

import com.gunerakin.bcows.dto.BarcodeDTO;
import com.gunerakin.bcows.model.Barcode;

import java.util.List;
import java.util.Optional;

public interface BarcodeService {

    BarcodeDTO saveBarcode(BarcodeDTO barcodeDTO);

    List<Barcode> getBarcodes();

    boolean deleteBarcode(Barcode Barcode);

    Optional<Barcode> getBarcodeByID(Long BarcodeId);

    boolean updateBarcode(Barcode Barcode);
}
