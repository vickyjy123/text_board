package utills;

import infra.Request;

public class Utill {

    public static boolean hasParam(Request request, String Key){
        return request.hasParam(Key);
    }
}
