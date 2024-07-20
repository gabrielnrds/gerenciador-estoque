package br.com.ufrpe.gerenciadorestoque.negocio.entidades;

public class Categoria {
    private String tipo;
    private String cor;
    private String material;
    private String estilo;

    public Categoria(String tipo, String cor, String material, String estilo){
        this.tipo = tipo;
        this.cor = cor;
        this.material = material;
        this.estilo = estilo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }
}
