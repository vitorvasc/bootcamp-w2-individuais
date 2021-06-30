package aula4.dakar.veiculos;

public abstract class Veiculo {

    protected double velocidade;
    protected double aceleracao;
    protected double anguloDeGiro;
    protected String placa;
    protected double peso;
    protected int rodas;

    public Veiculo() {
    }

    public Veiculo(double velocidade, double aceleracao, double anguloDeGiro, String placa) {
        this.velocidade = velocidade;
        this.aceleracao = aceleracao;
        this.anguloDeGiro = anguloDeGiro;
        this.placa = placa;
    }

    public double getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(double velocidade) {
        this.velocidade = velocidade;
    }

    public double getAceleracao() {
        return aceleracao;
    }

    public void setAceleracao(double aceleracao) {
        this.aceleracao = aceleracao;
    }

    public double getAnguloDeGiro() {
        return anguloDeGiro;
    }

    public void setAnguloDeGiro(double anguloDeGiro) {
        this.anguloDeGiro = anguloDeGiro;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getRodas() {
        return rodas;
    }

    public void setRodas(int rodas) {
        this.rodas = rodas;
    }

    public double calcularVencedor() {
        return this.velocidade * this.aceleracao / (this.anguloDeGiro * (this.peso - this.rodas * 100));
    }
}
