package sample1;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriteFile {
  public void write(File file, String content) throws IOException {
    Writer writer = null;
    try {
      writer = new FileWriter(file);
      writer.append(content);
    } finally {
      if (writer != null) {
        writer.close();
      }
    }
  }

  public void writeWithJava7(File file, String content) throws IOException {
    try (Writer writer = new FileWriter(file)) {
      writer.append(content);
    }
  }

  public void writeWithGuava(File file, String content) throws IOException {
    Files.write(content, file, Charsets.UTF_8);
  }
}
