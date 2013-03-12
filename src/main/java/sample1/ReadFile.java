package sample1;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
  public String read(File file) throws IOException {
    StringBuilder content = new StringBuilder();

    BufferedReader reader = null;
    try {
      reader = new BufferedReader(new FileReader(file));

      for (String line; (line = reader.readLine()) != null; ) {
        content.append(line);
        content.append("\n");
      }
    } finally {
      if (reader != null) {
        reader.close();
      }
    }

    return content.toString();
  }

  public String readJava7(File file) throws IOException {
    StringBuilder content = new StringBuilder();

    try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
      for (String line; (line = reader.readLine()) != null; ) {
        content.append(line);
        content.append("\n");
      }
    }

    return content.toString();
  }

  public String readWithGuava(File file) throws IOException {
    return Files.toString(file, Charsets.UTF_8);
  }
}
