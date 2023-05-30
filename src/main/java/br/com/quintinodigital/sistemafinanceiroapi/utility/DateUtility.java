package br.com.quintinodigital.sistemafinanceiroapi.utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtility {

    public static final String FORMMAT_DDMMAAAAHHMMSS = "ddMMYYYYHHmmss";
    
    public static final String FORMMAT_DD_MM_AAAA_HH_MM_SS = "dd/MM/YYYY HH:mm:ss";

    public static String gerarNumeroDemanda() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMMAT_DDMMAAAAHHMMSS);
        return simpleDateFormat.format(new Date());
    }
    
    public static String gerarDataFormatada(String formato) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formato);
        return simpleDateFormat.format(new Date());
    }

}
