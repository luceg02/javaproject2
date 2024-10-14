package cours2.filereader;

import java.io.IOException;

public class FileReader {
    public static void main(String[] args) {
        String txtFilePath = "C:\\Users\\luceg\\IdeaProjects\\Java\\src\\cours2\\filereader\\fichier.txt";
        String csvFilePath = "C:\\Users\\luceg\\IdeaProjects\\Java\\src\\cours2\\filereader\\fichier.csv";

        try {
            // Fichier txt
            FileType textFile = new TextFileReader();

            System.out.println("Contenu du fichier texte normal:");
            textFile.openFile(txtFilePath);
            textFile.printNormal();

            System.out.println("\nContenu du fichier texte à l'envers:");
            textFile.openFile(txtFilePath);
            textFile.printReverse();

            System.out.println("\nContenu du fichier texte en palindromique:");
            textFile.openFile(txtFilePath);
            textFile.printPalindrome();

            // Fichier CSV
            FileType csvFile = new CsvFileReader();

            System.out.println("\nContenu du fichier CSV normal:");
            csvFile.openFile(csvFilePath);
            csvFile.printNormal();

            System.out.println("\nContenu du fichier CSV à l'envers:");
            csvFile.openFile(csvFilePath);
            csvFile.printReverse();

            System.out.println("\nContenu du fichier CSV en palindromique:");
            csvFile.openFile(csvFilePath);
            csvFile.printPalindrome();


            boolean haveSameExtension = textFile.hasSameExtension(txtFilePath, csvFilePath);
            System.out.println("\nLes deux fichiers ont la même extension : " + haveSameExtension);


        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
