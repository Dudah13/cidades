/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import java.time.LocalDate;

/**
 *
 * @author Administrador
 */
public class cidade {
    
  private Integer codigo;
  private String nome;
  private String sigla;
  private Integer nr_habitantes;
  private LocalDate data_emacipacao;  
  private Double area_total;
  private Integer distancia_capital;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Integer getNr_habitantes() {
        return nr_habitantes;
    }

    public void setNr_habitantes(Integer nr_habitantes) {
        this.nr_habitantes = nr_habitantes;
    }

    public LocalDate getData_emacipacao() {
        return data_emacipacao;
    }

    public void setData_emacipacao(LocalDate data_emacipacao) {
        this.data_emacipacao = data_emacipacao;
    }

    public Double getArea_total() {
        return area_total;
    }

    public void setArea_total(Double area_total) {
        this.area_total = area_total;
    }

    public Integer getDistancia_capital() {
        return distancia_capital;
    }

    public void setDistancia_capital(Integer distancia_capital) {
        this.distancia_capital = distancia_capital;
    }

    @Override
    public String toString() {
        return "cidade{" + "nome=" + nome + '}';
    }

    

    

    
}
