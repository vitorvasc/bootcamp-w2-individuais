package aula4.dakar;

import aula4.dakar.socorristas.SocorristaCarro;
import aula4.dakar.socorristas.SocorristaMoto;
import aula4.dakar.veiculos.Carro;
import aula4.dakar.veiculos.Moto;
import aula4.dakar.veiculos.Veiculo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Corrida {

    private double distancia;
    private double premioEmDolares;
    private String nome;
    private int quantidadeVeiculosPermitidos;
    private List<Veiculo> listaVeiculos = new ArrayList<>();
    private SocorristaCarro socorristaCarro = new SocorristaCarro();
    private SocorristaMoto socorristaMoto = new SocorristaMoto();

    public Corrida() {
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getPremioEmDolares() {
        return premioEmDolares;
    }

    public void setPremioEmDolares(double premioEmDolares) {
        this.premioEmDolares = premioEmDolares;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeVeiculosPermitidos() {
        return quantidadeVeiculosPermitidos;
    }

    public void setQuantidadeVeiculosPermitidos(int quantidadeVeiculosPermitidos) {
        this.quantidadeVeiculosPermitidos = quantidadeVeiculosPermitidos;
    }

    public List<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public void setListaVeiculos(List<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

    public void socorrerCarro(String placa) {
        listaVeiculos
                .stream()
                .filter(c -> placa.equalsIgnoreCase(c.getPlaca()))
                .forEach(c -> socorristaCarro.socorrer(c));
    }

    public void socorrerMoto(String placa) {
        listaVeiculos
                .stream()
                .filter(m -> placa.equalsIgnoreCase(m.getPlaca()))
                .forEach(m -> socorristaMoto.socorrer(m));
    }

    public void registrarCarro(double velocidade, double aceleracao, double anguloDeGiro, String placa) {
        if (listaVeiculos.size() >= quantidadeVeiculosPermitidos)
            throw new RuntimeException("Esta corrida já está cheia!");

        Carro carro = new Carro(velocidade, aceleracao, anguloDeGiro, placa);
        listaVeiculos.add(carro);
    }

    public void registrarCarro(Carro carro) {
        if (listaVeiculos.size() >= quantidadeVeiculosPermitidos)
            throw new RuntimeException("Esta corrida já está cheia!");

        listaVeiculos.add(carro);
    }

    public void registrarMoto(double velocidade, double aceleracao, double anguloDeGiro, String placa) {
        if (listaVeiculos.size() >= quantidadeVeiculosPermitidos)
            throw new RuntimeException("Esta corrida já está cheia!");

        Moto moto = new Moto(velocidade, aceleracao, anguloDeGiro, placa);
        listaVeiculos.add(moto);
    }

    public void registrarMoto(Moto moto) {
        if (listaVeiculos.size() >= quantidadeVeiculosPermitidos)
            throw new RuntimeException("Esta corrida já está cheia!");

        listaVeiculos.add(moto);
    }

    public void removerVeiculo(Veiculo veiculo) {
        if (listaVeiculos.size() <= 0)
            throw new RuntimeException("A lista de veículos está vazia!");

        listaVeiculos.remove(veiculo);
    }

    public void removerVeiculoPorPlaca(String placa) {
        if (listaVeiculos.size() <= 0)
            throw new RuntimeException("A lista de veículos está vazia!");

        listaVeiculos.removeIf(v -> v.getPlaca().equalsIgnoreCase(placa));
    }

    public Veiculo definirVencedor() {
        if (listaVeiculos.size() <= 0)
            throw new RuntimeException("A lista de veículos está vazia!");

        return listaVeiculos.stream()
                .max(Comparator.comparing(Veiculo::calcularVencedor))
                .get();
    }
}
