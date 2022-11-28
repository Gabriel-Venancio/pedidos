package br.edu.infnet.pedido.model.entidade;

public class Time {

    private Long codigo;
    private String nome;
    private Integer vitorias;
    private Integer derrotas;
    private Integer empates;

    public Time(){
    }

    public Time(String nome, Integer vitorias, Integer derrotas, Integer empates, Long codigo) {
        this.nome = nome;
        this.vitorias = vitorias;
        this.derrotas = derrotas;
        this.empates = empates;
    }

    public Long getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVitorias() {
        return vitorias;
    }

    public void setVitorias(Integer vitorias) {
        this.vitorias = vitorias;
    }

    public Integer getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(Integer derrotas) {
        this.derrotas = derrotas;
    }

    public Integer getEmpates() {
        return empates;
    }

    public void setEmpates(Integer empates) {
        this.empates = empates;
    }

    @Override
    public String toString() {
        return "Time{" +
                "id=" + codigo +
                ", nome='" + nome + '\'' +
                ", vitorias=" + vitorias +
                ", derrotas=" + derrotas +
                ", empates=" + empates +
                '}';
    }
}
