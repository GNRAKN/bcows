package com.gunerakin.bcows.service;

import com.gunerakin.bcows.dto.BarcodeDTO;
import com.gunerakin.bcows.mapper.BCOWSMapper;
import com.gunerakin.bcows.model.Barcode;
import com.gunerakin.bcows.model.User;
import com.gunerakin.bcows.repository.BarcodeRepository;
import com.gunerakin.bcows.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BarcodeServiceImpl implements BarcodeService {

    @Autowired
    BarcodeRepository barcodeRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCOWSMapper bcowsMapper;

    @Override
    public BarcodeDTO saveBarcode(BarcodeDTO barcodeDTO) {
        Optional<User> user = null;
        Barcode mappedBarcode = bcowsMapper.barcodeDtoToBarcode(barcodeDTO);
        if (mappedBarcode.getUser() != null && mappedBarcode.getUser().getUserId() != null) {
            user = userRepository.findById(mappedBarcode.getUser().getUserId());
            mappedBarcode.setUser(user.get());
        }
        Barcode savedBarcode = barcodeRepository.save(mappedBarcode);
        return bcowsMapper.barcodeToBarcodeDto(savedBarcode);
    }

    @Override
    public List<Barcode> getBarcodes() {
        return null;
    }

    @Override
    public boolean deleteBarcode(Barcode Barcode) {
        return false;
    }

    @Override
    public Optional<Barcode> getBarcodeByID(Long BarcodeId) {
        return Optional.empty();
    }

    @Override
    public boolean updateBarcode(Barcode Barcode) {
        return false;
    }


}
