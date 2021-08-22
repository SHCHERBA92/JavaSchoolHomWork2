package WorkWithFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class GetText {
    private String sourceFile;

    public GetText(String sourceFile) {
        this.sourceFile = sourceFile;
    }

    public String getSourceFile() {
        return sourceFile;
    }

    public void setSourceFile(String sourceFile) {
        this.sourceFile = sourceFile;
    }

    public StringBuilder getText()
    {
        if (!this.sourceFile.isEmpty())
        {
            String text = "";
            FileReader fileReader = null;
            StringBuilder stringBuilder = null;

            File file = new File(this.sourceFile);

            try(BufferedReader bufferedReader = new BufferedReader(fileReader = new FileReader(file))) {
                stringBuilder = new StringBuilder();

                do {
                    stringBuilder.append(text).append(" ").append("\n");
                    text = bufferedReader.readLine();

                }  while (text != null);

            } catch (IOException e) {
                e.printStackTrace();
                System.out.println(e.getLocalizedMessage());
                System.err.println("Херня случается !");
            }
            return stringBuilder;
        }
        else {
            System.err.println("Не указан файл");
            return null;
        }
    }
}
