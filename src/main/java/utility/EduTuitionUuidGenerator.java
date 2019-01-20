package utility;

import java.util.UUID;

public class EduTuitionUuidGenerator {
    public static String uuidTuitionGenerator(){
        final String uuid = "" + UUID.randomUUID().toString() + "";
        System.out.println("uuid = " + uuid);
        return uuid;
    }
}
