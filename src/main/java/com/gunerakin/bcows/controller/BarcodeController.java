package com.gunerakin.bcows.controller;

import com.gunerakin.bcows.dto.BarcodeDTO;
import com.gunerakin.bcows.mapper.BCOWSMapper;
import com.gunerakin.bcows.service.BarcodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.BufferedImage;

@RestController
@RequestMapping(value = "/barcode")
public class BarcodeController {

    @Autowired
    BCOWSMapper bcowsMapper;

    @Autowired
    BarcodeService barcodeService;

    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.IMAGE_PNG_VALUE)
    public BufferedImage saveBarcode(@RequestBody BarcodeDTO barcodeDTO) {
        return barcodeService.saveBarcode(barcodeDTO).getBarcodeImage();
    }
}
