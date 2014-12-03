package com.github.x3333.mashbox;

import static com.google.testing.compile.JavaSourceSubjectFactory.javaSource;
import static org.truth0.Truth.ASSERT;

import org.junit.Test;

import com.github.x3333.mashbox.processor.Processor;
import com.google.testing.compile.JavaFileObjects;

/**
 * Unit test for Mashbox.
 */
public class MashGwtEventTest {

  @Test
  public void shouldCompileWithoutError() {
    ASSERT//
        .about(javaSource())//
        .that(JavaFileObjects.forResource("mashbox/test/NoErrorEventDef.java"))//
        .processedWith(new Processor())//
        .compilesWithoutError();
  }

  @Test
  public void invalidNameEvent() {
    ASSERT//
        .about(javaSource())//
        .that(JavaFileObjects.forResource("mashbox/test/InvalidNameEvenDef.java"))//
        .processedWith(new Processor())//
        .failsToCompile()//
        .withErrorContaining(
            "Element 'mashbox.test.InvalidNameEvenDef', @MashGwtEvent class name must ends with 'EventDef'.");
  }

  @Test
  public void interfaceEvent() {
    ASSERT//
        .about(javaSource())//
        .that(JavaFileObjects.forResource("mashbox/test/ClassEventDef.java"))//
        .processedWith(new Processor())//
        .failsToCompile()//
        .withErrorContaining("@MashGwtEvent can only be applied to Class element.");
  }

}
