//criando uma classe para cada inimigo que o heroi enfrentar
public class Inimigo {
 
    String nome;
    int hp;
    int dano;
//com isso pode se criar qualquer inimigo
    public Inimigo(String nome, int hp, int dano) {
        this.nome = nome;
        this.hp = hp;
        this.dano = dano;
    }
}

