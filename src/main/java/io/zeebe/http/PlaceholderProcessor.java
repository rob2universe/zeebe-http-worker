package io.zeebe.http;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.MustacheFactory;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.Map;

public class PlaceholderProcessor {

  private final MustacheFactory mf = new DefaultMustacheFactory();

  public String process(String input, Map<String, Object> context) {
    final var output = new StringWriter();

    final var mustache = mf.compile(new StringReader(input), "");
    mustache.execute(output, context);

    return output.toString();
  }
}
