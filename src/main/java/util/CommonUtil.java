package util;

public class CommonUtil {

    public static void sleep(long ms){
        try{
            Thread.sleep(ms);
        }catch (InterruptedException ex){
            ex.printStackTrace();;
        }
    }
}
