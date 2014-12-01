package com.github.x3333.mashbox.generator.impl;

import java.util.Map;
import java.util.TreeMap;

import javax.annotation.processing.ProcessingEnvironment;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.ElementFilter;

import com.github.x3333.mashbox.annotation.MashGwtEventParam;
import com.github.x3333.mashbox.generator.AbstractGenerator;

/**
 * AbstractGenerator for MashGwtEvent marker interface.
 *
 * @author Tercio Gaudencio Filho (terciofilho [at] gmail.com)
 */
public class MashGwtEventGenerator extends AbstractGenerator {

  public MashGwtEventGenerator(final ProcessingEnvironment processingEnv) {
    super(processingEnv);
  }

  @Override
  public void processElement(final TypeElement element) {
    if (element.getKind() != ElementKind.CLASS) {
      error("@MashGwtEvent can only be applied to Class element.");
      return;
    }

    // Find fields annotated with @MashGwtEventParam
    final Map<Integer, VariableElement> params = new TreeMap<Integer, VariableElement>();
    for (final VariableElement field : ElementFilter.fieldsIn(element.getEnclosedElements())) {
      final MashGwtEventParam param = field.getAnnotation(MashGwtEventParam.class);
      if (param != null) {
        if (params.containsKey(param.value())) {
          error(String.format("Field %s reused value '%d'.", field.getSimpleName(), param.value()));
          continue;
        }
        params.put(param.value(), field);
      }
    }

  }
}
