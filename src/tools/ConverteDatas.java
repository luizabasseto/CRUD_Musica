package tools;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Julia
 */
public class ConverteDatas {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public ConverteDatas() {
        simpleDateFormat.setLenient(false); //faz com que datas erradas sejam detectadas
    }

    public String converteDeDateParaString(Date data) {
        try {
            return simpleDateFormat.format(data); //converte a data para string
        } catch (Exception e) {
            return null; //se algo estiver errado na data, retorne null, tem que tratar o erro na classe que chamou
        }
    }

    public Date converteDeStringParaDate(String x) {
        try {
            return simpleDateFormat.parse(x); //converte
        } catch (Exception e) {
            return null; // se algo estiver errado, retorne null
        }
    }
}