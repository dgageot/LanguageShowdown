package sample1;

import java.io.*;
import java.util.*;

import com.google.common.base.*;
import com.google.common.io.*;

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

  public String readWithPuzzler(File file) throws IOException {
    return new Scanner(file).useDelimiter("\\Z").next();
  }
}
