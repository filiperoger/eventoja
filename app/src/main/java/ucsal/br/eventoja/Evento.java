package ucsal.br.eventoja;

import java.io.Serializable;

public class Evento implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
    private String data;
    private String hora;
    private String local;
    private String endereco;
    private String latitude;
    private String longitude;
    private String preco;
    private String detalhes;
    private String imagem;

    public Evento() {
    }

    public Evento(Integer id, String nome, String data, String hora, String local, String endereco, String latitude, String longitude, String preco, String detalhes, String imagem) {
        this.id = id;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
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
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", data='" + data + '\'' +
                ", hora='" + hora + '\'' +
                ", local='" + local + '\'' +
                ", endereco='" + endereco + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", preco='" + preco + '\'' +
                ", detalhes='" + detalhes + '\'' +
                ", imagem='" + imagem + '\'' +
                '}';
    }
}