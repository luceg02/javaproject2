package cours2.filereader;

import java.io.FileInputStream;
import java.io.IOException;

public abstract class FileType implements InterfaceReader {
    protected FileInputStream myFile;

    @Override
    public void openFile(String filePath) throws IOException {
        myFile = new FileInputStream(filePath);
    }

    @Override
    public void closeFile() throws IOException {
        if (myFile != null) {
            myFile.close();
        }
    }

    public void printNormal() throws IOException {
        try {
            int i = myFile.read();
            while (i != -1) {
                System.out.print((char) i);
                i = myFile.read();
            }
        } catch (IOException e) {
            e.getStackTrace();
        } finally {
            closeFile();
        }
    }

    public void printReverse() throws IOException {
        String[] lines = new String[100];
        int lineCount = 0;
        StringBuilder line = new StringBuilder();

        try {
            int i;
            while ((i = myFile.read()) != -1) {
                if (i == '\n') {
                    lines[lineCount++] = line.toString();
                    line.setLength(0); // Réinitialiser pour la prochaine ligne
                } else {
                    line.append((char) i);
                }
            }
            if (!line.isEmpty()) lines[lineCount++] = line.toString();

            for (int l = lineCount - 1; l >= 0; l--)
                System.out.println(lines[l]);
        } finally {
            closeFile();
        }
    }

    public void printPalindrome() throws IOException {
        StringBuilder content = new StringBuilder();
        try {
            int i;
            // Lire le fichier et construire le contenu
            while ((i = myFile.read()) != -1) {
                content.append((char) i);
            }

            // Afficher le contenu palindromique
            System.out.println(content.reverse().toString());
        } catch (IOException e) {
            e.getStackTrace();
        } finally {
            closeFile();
        }
    }

    // Méthode pour obtenir l'extension d'un fichier
    private String getFileExtension(String filePath) {
        int lastIndexOfDot = filePath.lastIndexOf('.');
        if (lastIndexOfDot == -1 || lastIndexOfDot == filePath.length() - 1) {
            return ""; // Pas d'extension
        }
        return filePath.substring(lastIndexOfDot + 1); // Extraire l'extension
    }

    // Méthode pour comparer les extensions des fichiers
    public boolean hasSameExtension(String filePath1, String filePath2) {
        String extension1 = getFileExtension(filePath1);
        String extension2 = getFileExtension(filePath2);
        return extension1.equalsIgnoreCase(extension2);
    }

}
