/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadeiaResponsabilidade;

public abstract class AbstractEmailHandler implements EmailHandler{
    private EmailHandler nextHandler;
    
    @Override
    public void setNextHandler(EmailHandler handler){
        this.nextHandler = handler;
    }
    
    @Override
    public void processHandler(String email){
        boolean wordFound = false;
        
        for (String word : matchingWords()){
            if (email.indexOf(word) >= 0){
                wordFound = true;
                break;
            }
        }
        if (wordFound){
            handleHere(email);
        }
        else{
            nextHandler.processHandler(email);
        }
    }
    protected abstract String[] matchingWords();
    protected abstract void handleHere(String email);
    
    public static void handle (String email){
        EmailHandler spam = new SpamHandler();
        EmailHandler vendas = new VendasHandler();
        EmailHandler servico = new ServicoHandler();
        EmailHandler reclamacao = new ReclamacaoHandler();
        EmailHandler geral = new GeralHandler();
    
        spam.setNextHandler(vendas);
        vendas.setNextHandler(servico);
        servico.setNextHandler(reclamacao);
        reclamacao.setNextHandler(geral);
    
        spam.processHandler(email);
    }
}
