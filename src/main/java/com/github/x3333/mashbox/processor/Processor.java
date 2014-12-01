package com.github.x3333.mashbox.processor;

import static javax.lang.model.util.ElementFilter.typesIn;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;

import com.github.x3333.mashbox.annotation.MashGwtEvent;
import com.github.x3333.mashbox.generator.impl.MashGwtEventGenerator;

/**
 * Mashbox Annotation Processor.
 *
 * @author Tercio Gaudencio Filho (terciofilho [at] gmail.com)
 */
@SupportedAnnotationTypes({"com.github.x3333.mashbox.annotation.MashGwtEvent"})
@SupportedSourceVersion(SourceVersion.RELEASE_6)
public class Processor extends AbstractProcessor {

  @Override
  public boolean process(final Set<? extends TypeElement> annotations,
      final RoundEnvironment roundEnv) {

    // Process MashGwtEvent elements
    final MashGwtEventGenerator mashGwtEventGenerator = new MashGwtEventGenerator(processingEnv);

    for (final TypeElement element : typesIn(roundEnv.getElementsAnnotatedWith(MashGwtEvent.class))) {
      mashGwtEventGenerator.processElement(element);
    }

    return true;
  }

}
