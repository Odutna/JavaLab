package com.civiletti.stream.serializable;

import java.io.*;

public class IOOggettiClasseDemo {
    public static void main(String[]args) {

        String nomeFile = "specie.registrazioni";
        ObjectOutputStream outputStream = null;

        try {
            outputStream = new ObjectOutputStream(new FileOutputStream(nomeFile));
        } catch (IOException e) {
            System.err.println("Errore nell'apertura del file di output " + nomeFile + ".");
            System.exit(0);
        }

        Specie condorCalifornia = new
                Specie("Condor della California", 27, 0.02);
        Specie rinoceronteNero = new Specie("Rinoceronte Nero", 100, 1.0);

        Specie lince = new Specie("Lince Iberica", 150, 1.2);
        Specie pandaGigante = new Specie("Panda Gigante", 1864, 0.8);

        try {
            outputStream.writeObject(condorCalifornia);
            outputStream.writeObject(rinoceronteNero);
            outputStream.writeObject(lince);
            outputStream.writeObject(pandaGigante);
            outputStream.close();
        } // catch (IOException e) {
//            System.err.println("Errore nella scrittura del file " + nomeFile + ".");
//            System.exit(0);
//        }
        catch (FileNotFoundException e) {
            System.err.println("Impossibile creare o accedere al file " + nomeFile +
                    ". Verifica i permessi o il percorso.");
            e.printStackTrace();
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Errore nella scrittura del file " + nomeFile + ".");
            e.printStackTrace();
            System.exit(1);
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                System.err.println("Errore nella chiusura del file di output.");
                e.printStackTrace();
            }
        }

        System.out.println("Le registrazioni sono state scritte nel file " + nomeFile + ".");
        System.out.println("##########################################################################");
        System.out.println("Ora il file verrà riaperto e verranno mostrate " + "le registrazioni.");

        ObjectInputStream inputStream = null;

        try {
            inputStream = new ObjectInputStream(new FileInputStream(nomeFile));
        } catch (IOException e) {
            System.err.println("Errore nell'apertura del file di input " + nomeFile + ".");
            System.exit(0);
        }

        Specie lettaUno = null, lettaDue = null, lettaTre = null, lettaQuattro = null;

        try {
            // Si notino le conversioni (casting) di tipo esplicite.
            lettaUno = (Specie)inputStream.readObject();
            lettaDue = (Specie)inputStream.readObject();
            lettaTre = (Specie)inputStream.readObject();
            lettaQuattro = (Specie)inputStream.readObject();
            inputStream.close();

//        } catch (Exception e) {
//
//            /* Sarebbe meglio utilizzare un blocco catch separato per ogni tipo di eccezione.
//               Qui ne è stato utilizzato uno solo per ragioni di spazio.
//             */
//                    System.err.println("Error nella lettura del file " + nomeFile + ".");
//            System.exit(0);
//        }
    } catch (FileNotFoundException e) {
        System.err.println("File " + nomeFile + " non trovato.");
        e.printStackTrace();
        System.exit(1);
    } catch (ClassNotFoundException e) {
        System.err.println("Classe dell'oggetto non trovata durante la lettura.");
        e.printStackTrace();
        System.exit(1);
    } catch (InvalidClassException e) {
        System.err.println("La classe dell'oggetto non corrisponde alla definizione attuale.");
        e.printStackTrace();
        System.exit(1);
    } catch (EOFException e) {
        System.err.println("Fine del file raggiunta in modo inaspettato.");
        e.printStackTrace();
        System.exit(1);
    } catch (IOException e) {
        System.err.println("Errore nella lettura del file " + nomeFile + ".");
        e.printStackTrace();
        System.exit(1);
    } finally {
        try {
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (IOException e) {
            System.err.println("Errore nella chiusura del file di input.");
            e.printStackTrace();
        }
    }

        System.out.println("Sono stati letti dal file " + nomeFile + " i seguenti dati.");
        System.out.println(lettaUno);
        System.out.println();
        System.out.println(lettaDue);
        System.out.println();
        System.out.println(lettaTre);
        System.out.println();
        System.out.println(lettaQuattro);
        System.out.println();
        System.out.println("Fine del programma.");
    }
}
