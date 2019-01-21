package utility;

import java.util.UUID;

public class EduTuitionUuidGenerator {

    /*
    THIS IS THE UUID Generator.
    its pretty standard really
    you just generate a random UUID with java.util.uuid
    and assign it to a final string that is returned to
    the method caller.
     */
    public static String uuidTuitionGenerator(){
        final String uuid = "" + UUID.randomUUID().toString() + "";
        System.out.println("uuid = " + uuid);
        return uuid;
    }
}
