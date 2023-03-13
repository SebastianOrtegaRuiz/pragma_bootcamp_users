package com.pragma.foodCourt.infraestructure.utility;

import com.pragma.foodCourt.application.dto.request.UsersRequestDto;
import com.pragma.foodCourt.domain.model.UsersModel;

public interface IUtilities {
    UsersRequestDto encryptPass(UsersRequestDto usersRequestDto);
    boolean verifyPass(String password, String encryptedPass);
    boolean isNumeric(String string);
    boolean validPhoneNumber(String string);
}
