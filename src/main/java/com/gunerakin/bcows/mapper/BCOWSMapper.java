package com.gunerakin.bcows.mapper;

import com.gunerakin.bcows.dto.BarcodeDTO;
import com.gunerakin.bcows.dto.UserDTO;
import com.gunerakin.bcows.model.Barcode;
import com.gunerakin.bcows.model.User;
import com.gunerakin.bcows.service.UserService;
import com.gunerakin.bcows.service.UserServiceImpl;
import net.glxn.qrgen.javase.QRCode;
import org.mapstruct.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Mapper(componentModel = "spring")
public interface BCOWSMapper {

    UserService userService = new UserServiceImpl();

    @Mappings({
            @Mapping(source = "barcodeDTO.barcodeText", target = "barcodeImageBytes", qualifiedByName = "generateQRCode"),
            @Mapping(source = "barcodeDTO.userDto", target = "user")})
    Barcode barcodeDtoToBarcode(BarcodeDTO barcodeDTO);

    @Mappings({
            @Mapping(source = "barcode.barcodeImageBytes", target = "barcodeImage", qualifiedByName = "generateQRImage"),
            @Mapping(source = "barcode.user", target = "userDto")})
    BarcodeDTO barcodeToBarcodeDto(Barcode barcode);

    @Mappings({
            @Mapping(source = "userDTO.userName", target = "userName"),
            @Mapping(source = "userDTO.password", target = "password")})
    User userDtoToUser(UserDTO userDTO);

    @Mappings({
            @Mapping(source = "user.userName", target = "userName"),
            @Mapping(source = "user.password", target = "password")})
    UserDTO userToUserDto(User user);

    @Named("generateQRCode")
    static byte[] generateQRCode(String text) throws IOException {
        ByteArrayOutputStream stream = QRCode.from(text).withSize(250, 250).stream();
        return stream.toByteArray();
    }

    @Named("generateQRImage")
    static BufferedImage generateQRImage(byte[] barcodeImageBytes) throws IOException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(barcodeImageBytes);
        return ImageIO.read(inputStream);
    }

}
