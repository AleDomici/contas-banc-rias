package main;

public class ContaBancaria {
    protected double saldo;
    protected ServicoNotificacao servicoNotificacao;

    public ContaBancaria(ServicoNotificacao servicoNotificacao){
        this.servicoNotificacao = servicoNotificacao;
    }

    public abstract double calcularTaxa();

    public void depositar(double valor){
        saldo += valor;
        servicoNotificacao.enviarNotificacao("Depósito de " + valor + " realizado. Saldo atual: " + saldo);
    }

    public void sacar(double valor){
        if(saldo >= valor){
            saldo -= valor;
            servicoNotificacao.enviarNotificacao("Saque de " + valor + "realizado. Saldo atual: " + saldo);
        } else {
            servicoNotificacao.enviarNotificacao("Saldo insuficiente para saque de " + valor + "Seu saldo é de " + saldo);
        }
    }

    public double getSaldo(){
        return saldo;
    }
}
