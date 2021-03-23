package util;

import java.io.File;

public class Util {

    public static String retornaPathChromeDriver(){
        return new File("src\\test\\resources\\chromedriver.exe").getAbsolutePath();
    }



}
