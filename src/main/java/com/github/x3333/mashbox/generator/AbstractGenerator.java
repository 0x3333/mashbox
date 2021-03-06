package com.github.x3333.mashbox.generator;

import java.io.IOException;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;

/**
 * Generators base class.
 *
 * @author Tercio Gaudencio Filho (terciofilho [at] gmail.com)
 */
// TODO: Add Generic type.
// TODO: Add a abstract getPossibleAnnotations method
public abstract class AbstractGenerator {

  protected final ProcessingEnvironment processingEnv;

  public AbstractGenerator(final ProcessingEnvironment processingEnv) {
    this.processingEnv = processingEnv;
  }

  public abstract void processElement(TypeElement element) throws IOException;

  protected void warn(final String msg) {
    processingEnv.getMessager().printMessage(Diagnostic.Kind.WARNING, msg);
  }

  protected void error(final String msg) {
    processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR, msg);
  }

}
