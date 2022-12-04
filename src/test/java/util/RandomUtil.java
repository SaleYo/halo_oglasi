package util;

import constants.Const;
import org.apache.commons.lang3.RandomStringUtils;


public class RandomUtil {

    public static String createRandomEmail(){
        String randomPart =  RandomStringUtils.randomAlphanumeric(5);
        String email = Const.EMAIL_LOCAL_PART + randomPart + Const.EMAIL_DOMAIN_PART;
        return email;
    }

    public static String createRandomUsername(){
        String randomPart =  RandomStringUtils.randomAlphanumeric(5);
        String username = Const.USERNAME + randomPart;
        return username;
    }

    public static String createRandomPassword(){
        String randomPass =  RandomStringUtils.randomAlphanumeric(10);
        return randomPass;
    }
}
