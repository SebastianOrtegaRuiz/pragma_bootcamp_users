package com.pragma.foodCourt.infraestructure.utility;

import com.pragma.foodCourt.application.dto.request.UsersRequestDto;
import org.springframework.security.crypto.bcrypt.BCrypt;

public class Utilities implements IUtilities{

    @Override
    public UsersRequestDto encryptPass(UsersRequestDto usersRequestDto) {
        String pass = usersRequestDto.getPassword();
        if(pass != null && !pass.isEmpty()) {
            String encryptedPass = BCrypt.hashpw(pass, BCrypt.gensalt());
            usersRequestDto.setPassword(encryptedPass);

            return usersRequestDto;
        }
        return usersRequestDto;
    }

    @Override
    public boolean verifyPass(String password, String encryptedPass) {
        if(BCrypt.checkpw(password, encryptedPass)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isNumeric(String string) {

        try {
            Long.parseLong(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    @Override
    public boolean validPhoneNumber(String string) {
        if(string.length() <= 13) {
            if (string.charAt(0) == '+') {
                return isNumeric(string.substring(1, string.length()));
            } else if (string.charAt(0) != '+') {
                return isNumeric(string);
            }
        }
        return false;
    }
}
