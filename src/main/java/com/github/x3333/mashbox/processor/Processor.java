package com.github.x3333.mashbox.processor;

import static javax.lang.model.util.ElementFilter.typesIn;

import java.io.IOException;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;

import com.github.x3333.mashbox.annotation.MashGwtEvent;
import com.github.x3333.mashbox.generator.impl.MashGwtEventGenerator;

/**
 * Mashbox Annotation Processor.
 *
 * @author Tercio Gaudencio Filho (terciofilho [at] gmail.com)
 */
@SupportedAnnotationTypes({"com.github.x3333.mashbox.annotation.MashGwtEvent"})
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class Processor extends AbstractProcessor {

  @Override
  public boolean process(final Set<? extends TypeElement> annotations,
      final RoundEnvironment roundEnv) {

    // MashGwtEvent
    final MashGwtEventGenerator mashGwtEventGenerator = new MashGwtEventGenerator(processingEnv);

    // Process all Classes/Interfaces that are annotated with MashGwtEvent.
    for (final TypeElement element : typesIn(roundEnv.getElementsAnnotatedWith(MashGwtEvent.class))) {
      try {
        mashGwtEventGenerator.processElement(element);
      } catch (final IOException e) {
        processingEnv.getMessager().printMessage(Diagnostic.Kind.ERROR,
            "Could not process Element " + element.toString());
      }
    }

    return true;
  }

}
