/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadeiaResponsabilidade;

public class SpamHandler extends AbstractEmailHandler{
    @Override
    protected String[] matchingWords(){
        return new String[]{"medicina","promoção","grátis","marketing","multinível"};
    }

    @Override
    protected void handleHere(String email) {
        System.out.println("Email sendo enviado para caixa de SPAM");
    }
}
