package br.unipar.calendariofgts.util;

        import android.annotation.SuppressLint;

        import java.text.DecimalFormat;
        import java.text.ParseException;
        import java.text.SimpleDateFormat;
        import java.util.ArrayList;
        import java.util.Calendar;
        import java.util.Date;

public class Analise {


    public static ArrayList<String> retornaResulado(String dataNasc) throws ParseException {
        ArrayList<String> datas = new ArrayList<>();
        //ArrayList<Integer> nasc = new ArrayList<>();
        //ArrayList<Integer> dataAtual = new ArrayList<>(3);
        /*ArrayList<Integer> primeiraParcela = new ArrayList<>(3);
        ArrayList<Integer> segundaParcela = new ArrayList<>(3);
        ArrayList<Integer> terceiraParcela = new ArrayList<>(3);*/
        Date now = new Date();

        //nasc.add(0, Integer.valueOf(dataNasc.split("/")[0]));
        //nasc.add(1, Integer.valueOf(dataNasc.split("/")[1]));
        //nasc.add(2, Integer.valueOf(dataNasc.split("/")[2]));

        //dataAtual.add(0, now.getDate());
        //dataAtual.add(1, now.getMonth());
        //dataAtual.add(2, now.getYear() + 1900);

        /*if(nasc.get(0) > 0 && nasc.get(0) <= 10){
            primeiraParcela.add(0, 5);
            segundaParcela.add(0, 5);
            terceiraParcela.add(0, 5);
        } else if(nasc.get(0) > 11 && nasc.get(0) <= 20){
            primeiraParcela.add(0, 10);
            segundaParcela.add(0, 10);
            terceiraParcela.add(0, 10);
        } else if(nasc.get(0) > 21) {
            primeiraParcela.add(0, 15);
            segundaParcela.add(0, 15);
            terceiraParcela.add(0, 15);
        }

        primeiraParcela.add(1, dataAtual.get(1) + 1);
        segundaParcela.add(1, dataAtual.get(1) + 2);
        terceiraParcela.add(1, dataAtual.get(1) + 3);

        if(nasc.get(1) < dataAtual.get(1)) {
            primeiraParcela.add(2, dataAtual.get(2) + 1);
            segundaParcela.add(2, dataAtual.get(2) + 1);
            terceiraParcela.add(2, dataAtual.get(2) + 1);
        }*/

        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = sdf.parse(dataNasc);

        Calendar dtNasc = Calendar.getInstance();
        Calendar dtAtual = Calendar.getInstance();
        dtNasc.setTime(date);
        dtAtual.setTime(new Date());

        Date dataAtual = new Date(String.valueOf(dtAtual.getTime()));
        int anoAtual = dataAtual.getYear() + 1900;
        int mesAtual = dataAtual.getMonth();
        int diaAtual = dataAtual.getDate();

        int mesNasc = date.getMonth();

        if(mesNasc <= mesAtual){
            anoAtual += 1;
        }

        Calendar primeiraParcela = Calendar.getInstance();
        Calendar segundaParcela = Calendar.getInstance();
        Calendar terceiraParcela = Calendar.getInstance();

        if(dtNasc.get(Calendar.DATE) > 1 && dtNasc.get(Calendar.DATE) <= 10){
            dtAtual.set(Calendar.DATE, 5);
        } else if(dtNasc.get(Calendar.DATE) > 11 && dtNasc.get(Calendar.DATE) <= 20){
            dtAtual.set(Calendar.DATE, 10);
        } else if(dtNasc.get(Calendar.DATE) > 21){
            dtAtual.set(Calendar.DATE, 15);
        }

        dtAtual.set(Calendar.MONTH, dtNasc.get(Calendar.MONTH));
        primeiraParcela.set(Calendar.DATE, dtAtual.get(Calendar.DATE));
        segundaParcela.set(Calendar.DATE, dtAtual.get(Calendar.DATE));
        terceiraParcela.set(Calendar.DATE, dtAtual.get(Calendar.DATE));

        primeiraParcela.set(Calendar.MONTH, dtNasc.get(Calendar.MONTH) + 2);
        segundaParcela.set(Calendar.MONTH, dtNasc.get(Calendar.MONTH) + 3);
        terceiraParcela.set(Calendar.MONTH, dtNasc.get(Calendar.MONTH) + 4);

        primeiraParcela.set(Calendar.YEAR, anoAtual);
        segundaParcela.set(Calendar.YEAR, anoAtual);
        terceiraParcela.set(Calendar.YEAR, anoAtual);

        String dia = String.valueOf(primeiraParcela.get(Calendar.DATE)).length() > 1 ?
                     String.valueOf(primeiraParcela.get(Calendar.DATE)) :
                     "0"+String.valueOf(primeiraParcela.get(Calendar.DATE));
        String mes = String.valueOf(primeiraParcela.get(Calendar.MONTH)).length() > 1 ?
                     String.valueOf(primeiraParcela.get(Calendar.MONTH)) :
                     "0"+String.valueOf(primeiraParcela.get(Calendar.MONTH));
        datas.add(0, dia + "/" +  mes + "/" + primeiraParcela.get(Calendar.YEAR));

        dia = String.valueOf(segundaParcela.get(Calendar.DATE)).length() > 1 ?
              String.valueOf(segundaParcela.get(Calendar.DATE)) :
              "0"+String.valueOf(segundaParcela.get(Calendar.DATE));
        mes = String.valueOf(segundaParcela.get(Calendar.MONTH)).length() > 1 ?
              String.valueOf(segundaParcela.get(Calendar.MONTH)) :
              "0"+String.valueOf(segundaParcela.get(Calendar.MONTH));
        datas.add(1, dia + "/" +  mes + "/" + segundaParcela.get(Calendar.YEAR));

        dia = String.valueOf(terceiraParcela.get(Calendar.DATE)).length() > 1 ?
                String.valueOf(terceiraParcela.get(Calendar.DATE)) :
                "0"+String.valueOf(terceiraParcela.get(Calendar.DATE));
        mes = String.valueOf(terceiraParcela.get(Calendar.MONTH)).length() > 1 ?
                String.valueOf(terceiraParcela.get(Calendar.MONTH)) :
                "0"+String.valueOf(terceiraParcela.get(Calendar.MONTH));
        datas.add(2, dia + "/" +  mes + "/" + terceiraParcela.get(Calendar.YEAR));

        return datas;
    }

}
