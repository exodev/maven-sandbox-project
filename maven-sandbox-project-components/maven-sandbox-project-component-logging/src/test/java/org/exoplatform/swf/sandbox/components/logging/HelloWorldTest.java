package org.exoplatform.swf.sandbox.components.logging;

import static org.junit.Assert.*;

import org.junit.Test;


public class HelloWorldTest {


  @Test
  public void getMessage() throws Exception {

    HelloWorld hl = new HelloWorld();

    assertNotNull(hl.getMessage());
    assertEquals("Hello Dev Squad Team !", hl.getMessage());

  }

}
