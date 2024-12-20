package com.civiletti.veicolo.v3;

public class InfoVeicolo {

    public static void menu(){
        System.out.println("========================================");
        System.out.println("    \033[32m[H]elp [M]appa [Q]uadro [E]sci\033[0m");
        System.out.println("========================================");
    }

    public static void info(Veicolo mioVeicolo){
        System.out.println();
        System.out.println("==============================");
        System.out.println("= \033[32m      INFO VEICOLO        \033[0m =");
        System.out.println("==============================");
        System.out.println(mioVeicolo);
    }

    public static void quadro(Veicolo mioVeicolo){
        mioVeicolo.mostraQuadroStrumenti();
    }

    public static void help(){
        System.out.println("\n  \t     \033[31m[W]\033[0m Avanti \t\t\t\t "); //\033[93m[R]\033[0m Accendi veicolo"
        System.out.println("\033[31m[A]\033[0m Sinistra \033[31m[S]\033[0m Indietro \033[31m[D]\033[0m Destra");
//        System.out.println("[4] Retromarcia \t\t [7] Frena \t\t [11] 4 Frecce");
//        System.out.println("[8] Stop (semaforo/incrocio)");
//        System.out.println("[12] Spegni veicolo");
    }
}
