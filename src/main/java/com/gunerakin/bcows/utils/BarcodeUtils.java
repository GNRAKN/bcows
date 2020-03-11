package com.gunerakin.bcows.utils;

import com.gunerakin.bcows.repository.UserRepository;
import net.glxn.qrgen.javase.QRCode;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class BarcodeUtils {

    // @Named("generateQRCode")
    public static byte[] generateQRCode(String text) throws IOException {
        ByteArrayOutputStream stream = QRCode.from(text).withSize(250, 250).stream();
        return stream.toByteArray();
    }

    // @Named("generateQRImage")
    public static BufferedImage generateQRImage(byte[] barcodeImageBytes) throws IOException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(barcodeImageBytes);
        return ImageIO.read(inputStream);
    }

}
