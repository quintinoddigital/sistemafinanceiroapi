package br.com.quintino.sistemafinanceiroapi.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataUtility {

    public static final String FORMMAT_DDMMAAAAHHMMSS = "ddMMYYYYHHmmss";

    public static String gerarNumeroDemanda() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMMAT_DDMMAAAAHHMMSS);
        return simpleDateFormat.format(new Date());
    }

}
