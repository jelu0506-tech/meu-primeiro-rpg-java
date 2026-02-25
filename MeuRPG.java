import java.util.Random;
import java.util.Scanner;



public class MeuRPG {

    public static void iniciarCombate(Personagem heroi, Inimigo vilao, Scanner leitor, Random damage, int[] danoheroi) {
        System.out.println("\n--- INICIANDO COMBATE CONTRA " + vilao.nome + " ---");
        
        while (vilao.hp > 0 && heroi.HPpersonagem > 0) {
            System.out.println("\nHP " + heroi.nomepersonagem + ": " + heroi.HPpersonagem + " | HP " + vilao.nome + ": " + vilao.hp);
            System.out.println("Escolha (1)-Atacar (2)-Usar Poção");
            String escolha = leitor.nextLine();

            if (escolha.equals("1")) {
                System.out.println("Aperte 'Enter' para golpear!");
                leitor.nextLine();
                
                int danosorteado = damage.nextInt(3); 
                int danoReal = danoheroi[danosorteado];
                
                if (danoReal == 0) {
                    System.out.println("Putz! Você errou o golpe!");
                } else {
                    vilao.hp -= danoReal;
                    System.out.println("BOOM! Você causou " + danoReal + " de dano!");
                }
            } else if (escolha.equals("2")) {
                heroi.tomarpocaoHP();
            }

           
            if (vilao.hp > 0) {
                System.out.println(vilao.nome + " revida o ataque!");
                heroi.HPpersonagem -= vilao.dano; // Corrigido o -=
                System.out.println("Você recebeu " + vilao.dano + " de dano.");
            }
        }

        if (heroi.HPpersonagem > 0) {
            System.out.println("VITÓRIA! O " + vilao.nome + " virou história.");
        } else {
            System.out.println("FATALITY... " + heroi.nomepersonagem + " foi derrotado.");
        }
    }
    
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Random damage = new Random();
        int[] danoheroi = {100, 50, 0}; 
        
        Personagem heroi = new Personagem();
        
        System.out.println("Digite o nome do seu aventureiro: ");
        heroi.nomepersonagem = leitor.nextLine();
        
        Inimigo goblin = new Inimigo("Goblin da Floresta", 100, 30);
        System.out.println("\n" + heroi.nomepersonagem + " caminha pela floresta e um " + goblin.nome + " pula dos arbustos!");
        
        iniciarCombate(heroi, goblin, leitor, damage, danoheroi);

      
        if (heroi.HPpersonagem <= 0) {
            System.out.println("FIM DE JOGO.");
            return; 
        }

        heroi.ganharxp(100);

        // --- HISTÓRIA ---
        System.out.println("\nVocê encontra uma bolsa com 2 poções de vida! (Enter para pegar)");
        leitor.nextLine();
        heroi.inventario = new Bolsa();
        heroi.inventario.pocaoHP = 2;

        System.out.println("\nMais adiante, um Elfo Negro está assaltando um mercador!");
        System.out.println("O que fazer? (1)-Ajudar o Mercador (2)-Ignorar e seguir viagem");
        String escolha = leitor.nextLine();

        if (escolha.equals("1")) {
            // --- ENCONTRO 2: ELFO ---
            Inimigo elfo = new Inimigo("Elfo Negro", 400, 80); // Um pouco mais forte!
            iniciarCombate(heroi, elfo, leitor, damage, danoheroi);
            
            if (heroi.HPpersonagem > 0) {
                System.out.println("O mercador te agradece e te dá uma recompensa!");
                
            }
        } else {
            System.out.println("Você decidiu não se envolver. O mundo é um lugar cruel...");
        }

        System.out.println("\nFIM DA DEMO. Parabéns, " + heroi.nomepersonagem + "!");
    }
}