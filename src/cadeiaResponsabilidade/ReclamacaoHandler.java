/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadeiaResponsabilidade;

public class ReclamacaoHandler extends AbstractEmailHandler{
    @Override
    protected String[] matchingWords(){
        return new String[]{"sujestão","reclamação","atrazo","faltando"};
    }

    @Override
    protected void handleHere(String email) {
        System.out.println("Email sendo cuidado pelo departamento de reclamações");
    }
}
