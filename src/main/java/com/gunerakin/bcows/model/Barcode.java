package com.gunerakin.bcows.model;

import javax.imageio.ImageIO;
import javax.persistence.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

@Entity
@Table(name = "BARCODE")
public class Barcode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BARCODE_ID")
    private Long barcodeId;

    @Column(name = "BARCODE_IMAGE", length = 500)
    private byte[] barcodeImageBytes;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_ID")
    private User user;

    public Long getBarcodeId() {
        return barcodeId;
    }

    public void setBarcodeId(Long barcodeId) {
        this.barcodeId = barcodeId;
    }

    public byte[] getBarcodeImageBytes() {
        return barcodeImageBytes;
    }

    public void setBarcodeImageBytes(byte[] barcodeImageBytes) {
        this.barcodeImageBytes = barcodeImageBytes;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BufferedImage generateBarcodeImage() throws IOException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(this.barcodeImageBytes);
        return ImageIO.read(inputStream);
    }
}
