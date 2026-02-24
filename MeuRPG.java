
import java.util.Random;
import java.util.Scanner;

class Bolsa {
    int pocaoHP = 1;
}

class Personagem {
    int HPpersonagem = 2000;
    String nomepersonagem;
    Bolsa inventario = null;

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
}

class Globin {
    int HPglobin = 100;
    String nomeglobin;
    int danoglobin = 30;
}

public class MeuRPG {

    public static void main(String[] args) {
        int[] danoheroi = {100, 50, 0};

        Random damage = new Random();
        Scanner leitor = new Scanner(System.in);
        Personagem heroi = new Personagem();
        Globin globin = new Globin();
        globin.nomeglobin = "globin da floresta";

        System.out.println("Digite o nome do seu personagem: ");
        heroi.nomepersonagem = leitor.nextLine();
        System.out.println("Iniciando a história...");

        System.out.println("Seu nome é " + heroi.nomepersonagem + " um aventureiro solitário, ao caminhar por uma floresta escura ele se depara com um Globin! " + heroi.nomepersonagem + ": Ah não, um Globin! " + globin.nomeglobin + ": Hahaha! iniciando combate...");
        
        while (globin.HPglobin > 0 && heroi.HPpersonagem > 0) {

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
                    globin.HPglobin -= 100;
                } else if (danoaplicadoheroi == 50) {
                    System.out.println("Voce deu 50 de dano no globin! ");
                    globin.HPglobin -= 50;
                }
            }

            if (globin.HPglobin > 0) {
                System.out.println(globin.nomeglobin + " Ataca!");
                heroi.HPpersonagem -= globin.danoglobin;
                System.out.println("Você recebeu " + globin.danoglobin + "de dano.");
            }
            
            if (globin.HPglobin > 0) {
                System.out.println("O " + globin.nomeglobin + " tem HP " + globin.HPglobin + " de 100 restantes.");
            }
            
            if (heroi.HPpersonagem > 0) {
                System.out.println("O " + heroi.nomepersonagem + " tem HP " + heroi.HPpersonagem + " de 2000 restantes.");
            }

            if (globin.HPglobin <= 0) {
                System.out.println("O globin foi derrotado!");
            }
        } 

        if (heroi.HPpersonagem <= 0) {
            System.out.println("GAME OVER!");
            return;
        }

        System.out.println("Ao continuar sua aventura pela floresta o herói encontra uma bolsa...");
        System.out.println("- Uma bolsa! disse o: " + heroi.nomepersonagem);
        System.out.println("Essa bolsa tem 2 poçao de HP");
        System.out.println("Aperte Enter para pegar...");
        leitor.nextLine();
        System.out.println("O " + heroi.nomepersonagem + "pegou a bolsa!");
        
        heroi.inventario = new Bolsa();
        heroi.inventario.pocaoHP = 2;
        
        System.out.println("Para utilizar uma pocao, aperte a tecla 'H'");
        String HP = leitor.nextLine();
        if (HP.equalsIgnoreCase("H")) {
            heroi.tomarpocaoHP();
        }
    } 
} 
       
    