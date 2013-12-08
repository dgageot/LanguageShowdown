package sample1;

import static org.fest.assertions.Assertions.*;

import java.io.*;

import org.junit.*;

import com.google.common.io.*;

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

  @Test
  public void should_read_file_with_puzzler() throws IOException {
    String content = reader.readWithPuzzler(file("file.txt"));

    assertThat(content).isEqualTo("Hello World\nHello World on second line");
  }

  static File file(String path) {
    return new File(Resources.getResource(path).getFile());
  }
}
