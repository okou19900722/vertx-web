package io.vertx.ext.web.validation.dsl;

import io.vertx.ext.web.validation.ValueParser;
import io.vertx.ext.web.validation.impl.SplitterCharObjectFieldParser;

import java.util.Map;
import java.util.regex.Pattern;

@FunctionalInterface
public interface ObjectParserFactory {

  ValueParser<String> newArrayParser(Map<String, ValueParser<String>> propertiesParser, Map<Pattern, ValueParser<String>> patternPropertiesParser, ValueParser<String> additionalPropertiesParser);

  static ObjectParserFactory commaSeparatedObjectParser() {
    return (propertiesParser, patternPropertiesParser, additionalPropertiesParser) -> new SplitterCharObjectFieldParser(propertiesParser, patternPropertiesParser, additionalPropertiesParser, ",");
  }

}
