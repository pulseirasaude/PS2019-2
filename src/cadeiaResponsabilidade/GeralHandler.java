/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadeiaResponsabilidade;

public class GeralHandler extends AbstractEmailHandler{
    @Override
    protected String[] matchingWords(){
        return new String[]{};
    }

    @Override
    protected void handleHere(String email) {
        System.out.println("Email sendo cuidado pelo call center");
    }
}
