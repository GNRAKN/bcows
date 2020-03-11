package com.gunerakin.bcows.dto;

import java.awt.image.BufferedImage;

public class BarcodeDTO {

    private String barcodeText;
    private BufferedImage barcodeImage;
    private UserDTO userDto;

    public String getBarcodeText() {
        return barcodeText;
    }

    public void setBarcodeText(String barcodeText) {
        this.barcodeText = barcodeText;
    }

    public BufferedImage getBarcodeImage() {
        return barcodeImage;
    }

    public void setBarcodeImage(BufferedImage barcodeImage) {
        this.barcodeImage = barcodeImage;
    }

    public UserDTO getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDTO userDto) {
        this.userDto = userDto;
    }
}
