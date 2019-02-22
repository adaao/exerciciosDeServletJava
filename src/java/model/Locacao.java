/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author adaao
 */
//nao apagar o comentario abaixo
/*
LocalDate hoje = LocalDate.now();
System.out.println(hoje); //2014-04-08 (formato ISO-8601)

LocalDate emissaoRG = LocalDate.of(2000, 1, 15);

LocalDate homemNoEspaco = LocalDate.of(1961, Month.APRIL, 12);
LocalDate homemNaLua = LocalDate.of(1969, Month.MAY, 25);
 
Period periodo = Period.between(homemNoEspaco, homemNaLua);
 
System.out.printf("%s anos, %s mês e %s dias", 
  periodo.getYears() , periodo.getMonths(), periodo.getDays());
  //8 anos, 1 mês e 13 dias
 */
public class Locacao {

    protected Filme f;
    protected Cliente c;
    protected int cdLocacao;
    protected LocalDate dtLocacao;
    protected LocalDate dtEstimadaDeDevolucao;
    protected LocalDate dtEfetivadaDeDevolucao;
    private static int indice = 0;
    //private Calendar calendar = new GregorianCalendar();
    //private Date trialTime = new Date();
       
      

    public Locacao(Cliente c, Filme f) {
        //calendar.setTime(trialTime);
        //System.out.println(calendar.get(Calendar.DAY_OF_MONTH) );
        //int days;
        this.c = c;
        this.f = f;
        indice++;
        cdLocacao = indice;
        //dtLocacao = LocalDate.now();
        //days = dtLocacao.getDay();
        //dtEstimadaDeDevolucao = dtLocacao;
        //dtEstimadaDeDevolucao.setDays(days);
         
    }

    

    /*
    public void setDtLocacao(LocalDate dtLocacao) {
        this.dtLocacao = dtLocacao;
    }

    public LocalDate getDtEstimadaDeDevolucao() {
        return dtEstimadaDeDevolucao;
    }

    public void setDtEstimadaDeDevolucao(LocalDate dtEstimadaDeDevolucao) {
        this.dtEstimadaDeDevolucao = dtEstimadaDeDevolucao;
    }

    public LocalDate getDtEfetivadaDeDevolucao() {
        return dtEfetivadaDeDevolucao;
    }

    public void setDtEfetivadaDeDevolucao(LocalDate dtEfetivadaDeDevolucao) {
        this.dtEfetivadaDeDevolucao = dtEfetivadaDeDevolucao;
    }

    public static void main(String... args) {
        
    }
    */

    public Filme getF() {
        return f;
    }

    public void setF(Filme f) {
        this.f = f;
    }

    public Cliente getC() {
        return c;
    }

    public void setC(Cliente c) {
        this.c = c;
    }

    public int getCdLocacao() {
        return cdLocacao;
    }

    
}
