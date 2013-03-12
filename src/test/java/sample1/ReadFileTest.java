package sample1;

import com.google.common.io.Resources;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.fest.assertions.Assertions.assertThat;

public class ReadFileTest {
  ReadFile reader = new ReadFile();

  @Test
  public void should_read_file() throws IOException {
    String content = reader.read(file("file.txt"));

    assertThat(content).isEqualTo("Hello World\nHello World on second line\n");
  }

  @Test
  public void should_read_file_with_java7() throws IOException {
    String content = reader.readJava7(file("file.txt"));

    assertThat(content).isEqualTo("Hello World\nHello World on second line\n");
  }

  @Test
  public void should_read_file_with_guava() throws IOException {
    String content = reader.readWithGuava(file("file.txt"));

    assertThat(content).isEqualTo("Hello World\nHello World on second line\n");
  }

  static File file(String path) {
    return new File(Resources.getResource(path).getFile());
  }
}
