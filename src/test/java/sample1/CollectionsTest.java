package sample1;

import org.fest.assertions.*;
import org.junit.*;

public class CollectionsTest {
  Collections collections = new Collections();

  @Test
  public void should_find_bob_s_age() {
    int ageOfBob = collections.withJava6("Bob");

    Assertions.assertThat(ageOfBob).isEqualTo(34);
  }

  @Test
  public void should_find_bob_s_age_guava() {
    int ageOfBob = collections.withGuava("Bob");

    Assertions.assertThat(ageOfBob).isEqualTo(34);
  }

  @Test
  public void should_find_bob_s_age_java_8() {
    int ageOfBob = collections.withJava8("Bob");

    Assertions.assertThat(ageOfBob).isEqualTo(34);
  }
}
