package sample1;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;

import static org.fest.assertions.Assertions.assertThat;

public class WriteFileTest {
  @Rule
  public TemporaryFolder temporaryFolder = new TemporaryFolder();

  @Test
  public void should_write_file() throws IOException {
    File file = temporaryFolder.newFile("file.txt");

    new WriteFile().write(file, "Hello World");

    assertThat(Files.toString(file, Charsets.UTF_8)).isEqualTo("Hello World");
  }

  @Test
  public void should_write_file_with_java7() throws IOException {
    File file = temporaryFolder.newFile("file.txt");

    new WriteFile().writeWithJava7(file, "Hello World");

    assertThat(Files.toString(file, Charsets.UTF_8)).isEqualTo("Hello World");
  }

  @Test
  public void should_write_file_with_guava() throws IOException {
    File file = temporaryFolder.newFile("file.txt");

    new WriteFile().writeWithGuava(file, "Hello World");

    assertThat(Files.toString(file, Charsets.UTF_8)).isEqualTo("Hello World");
  }
}
