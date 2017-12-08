package ucsal.br.eventoja;

import java.io.Serializable;

public class Evento implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer _id;
    private String nome;
    private String data;
    private String hora;
    private String local;
    private String endereco;
    private Double latitude;
    private Double longitude;
    private String preco;
    private String detalhes;
    private String imagem;

    public Evento() {
    }

    public Evento(Integer _id, String nome, String data, String hora, String local, String endereco, Double latitude, Double longitude, String preco, String detalhes, String imagem) {
        this._id = _id;
        this.nome = nome;
        this.data = data;
        this.hora = hora;
        this.local = local;
        this.endereco = endereco;
        this.latitude = latitude;
        this.longitude = longitude;
        this.preco = preco;
        this.detalhes = detalhes;
        this.imagem = imagem;
    }

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(String detalhes) {
        this.detalhes = detalhes;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "_id=" + _id +
                ", nome='" + nome + '\'' +
                ", data='" + data + '\'' +
                ", hora='" + hora + '\'' +
                ", local='" + local + '\'' +
                ", endereco='" + endereco + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", preco='" + preco + '\'' +
                ", detalhes='" + detalhes + '\'' +
                ", imagem='" + imagem + '\'' +
                '}';
    }
}