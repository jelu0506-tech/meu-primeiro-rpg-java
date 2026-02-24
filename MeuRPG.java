//importando a Aleatoriedade e o Scanner para utilizar no codigo.
import java.util.Random;
import java.util.Scanner;

//criando a class principal do jogo
public class MeuRPG {
//criando o main onde vai rodar o codigo
    public static void main(String[] args) {
        // criando aleatoriedade pro dano do heroi
        //primeiro criei uma caixa onde contém 3 tipos de dano utilizando o int[]
        int[] danoheroi = {100, 50, 0};
       //aqui começa a aleatoriedade do dano, chamando o Random que importei no inicio do codigo
        Random damage = new Random();
        //chamando o Scanner que importei também para receber comandos de entrada do usuário
        Scanner leitor = new Scanner(System.in);
        // chamando o personagem da class Personagem
        Personagem heroi = new Personagem();
        //chamando o primeiro vilão, através da class Inimigo
        Inimigo vilao = new Inimigo("Globin da Floresta", 100, 30);
        //pedindo o nome do personagem através de um print
        System.out.println("Digite o nome do seu personagem: ");
        //recebendo atravéz do Scanner o nome do personagem, solicitado ao usuario
        heroi.nomepersonagem = leitor.nextLine();
        System.out.println("Iniciando a história...");

        System.out.println("Seu nome é " + heroi.nomepersonagem + " um aventureiro solitário, ao caminhar por uma floresta escura ele se depara com um Globin! " + heroi.nomepersonagem + 
        ": Ah não, um Globin! " + vilao.nome + ": Hahaha! iniciando combate...");
        
        //aqui começa o combate
        while (vilao.hp > 0 && heroi.HPpersonagem > 0) {

            System.out.println("Escolha (1)-Atacar (2)-UsarPocao");
            String escolhacombate = leitor.nextLine();
            
            if (escolhacombate.equals("2")) {
                System.out.println("Usando pocao");
                heroi.tomarpocaoHP();
            }
            
            if (escolhacombate.equals("1")) {
                System.out.println("Digite 'Enter' para atacar! ");
                leitor.nextLine();

                System.out.println(heroi.nomepersonagem + " ataca!");
                int danosorteadoheroi = damage.nextInt(3);
                int danoaplicadoheroi = danoheroi[danosorteadoheroi];

                if (danoaplicadoheroi == 0) {
                    System.out.println("voce errou..");
                } else if (danoaplicadoheroi == 100) {
                    System.out.println("Voce deu acerto critico 100 de dano!! ");
                    vilao.hp -= 100;
                } else if (danoaplicadoheroi == 50) {
                    System.out.println("Voce deu 50 de dano no globin! ");
                    vilao.hp -= 50;
                }
            }
 //enquanto o goblin e o heroi estiverem vivos o combate continua alternando entre ataques do globin e do heroi
            if (vilao.hp > 0) {
                System.out.println(vilao.nome + " Ataca!");
                heroi.HPpersonagem -= vilao.dano;
                System.out.println("Você recebeu " + vilao.dano + "de dano.");
            }
            
            if (vilao.hp > 0) {
                System.out.println("O " + vilao.nome + " tem HP " + vilao.hp + " de 100 restantes.");
            }
            
            if (heroi.HPpersonagem > 0) {
                System.out.println("O " + heroi.nomepersonagem + " tem HP " + heroi.HPpersonagem + " de 2000 restantes.");
            }

            if (vilao.hp <= 0) {
                System.out.println("O globin foi derrotado!");
            }
        } 

        if (heroi.HPpersonagem <= 0) {
            System.out.println("GAME OVER!");
            return;
        }
        heroi.ganharxp(100);
      //pós combate
        System.out.println("Ao continuar sua aventura pela floresta o herói encontra uma bolsa...");
        System.out.println("- Uma bolsa! disse o: " + heroi.nomepersonagem);
        System.out.println("Essa bolsa tem 2 poçao de HP");
        System.out.println("Aperte Enter para pegar...");
        leitor.nextLine();
        System.out.println("O " + heroi.nomepersonagem + "pegou a bolsa!");
        // aqui o personagem ganha uma bolsa no inventario, permitindo que ele carregue pocoes
        heroi.inventario = new Bolsa();
        heroi.inventario.pocaoHP = 2;
        
        System.out.println("Para utilizar uma pocao, aperte a tecla 'H'");
        String HP = leitor.nextLine();
        //IgnoreCase é para que o 'h' seja reconhecido em minúsculo ou maiúsculo
        if (HP.equalsIgnoreCase("H")) {
            heroi.tomarpocaoHP();
        }
    } 
} 
       
    