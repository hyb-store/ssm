package com.hyb.ssm.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtils {

    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public static String encodePassword(String password){
        return bCryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args) {
        String password = "cannot";
        String pwd = encodePassword(password);
        System.out.println(pwd);
        //第一次加密：$2a$10$sjNzRt8mbeGBL7B1VZvaaurGpJUnLzGffGQb/Bv5piv2AhPEPLnnK
        //第二次加密：$2a$10$dU4/pOEPdBV5jZzDm2dDouRta11V7u9NcL3QBgdiE/HcdDzVFsxH2
        //第三次加密：$2a$10$Hri4FqfBnMyRliPdA6nUgOOF.ztvKPlUjTaL/yWRHDPlU5bX75Aqq
    }
}
