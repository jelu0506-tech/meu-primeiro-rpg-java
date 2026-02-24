
//classe do personagem principal
//aqui onde adicionarei as funções do personagem
public class Personagem {
    int HPpersonagem = 2000;
    String nomepersonagem;
    Bolsa inventario = null;
    int xp = 0;
    int level = 1;

    //funçao da poçao de cura do personagem
    public void tomarpocaoHP() {
        if (inventario != null && inventario.pocaoHP > 0) {
            System.out.println("Usando poçao...");
            inventario.pocaoHP--;
            HPpersonagem += 100;
            System.out.println("Status de HP: " + HPpersonagem);
        } else if (inventario == null) {
            System.out.println("Voce nao possui bolsa");
        } else {
            System.out.println("suas pocoes acabaram..");
        }
    }
    public void ganharxp(int pontos){
        this.xp += pontos;
        System.out.println("Você ganhou " + pontos + " de xp");
        if(this.xp >= 100){
            this.level ++;
            this.xp = 0;
            this.HPpersonagem += 500;
            System.out.println("LEVEL UP, você agora está no level " + level );
        }
    }
}
