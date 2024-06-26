/*-
 * #%L
 * XTerm Console Addon
 * %%
 * Copyright (C) 2020 - 2023 Flowing Code
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package com.flowingcode.vaadin.addons.xterm.test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import com.flowingcode.vaadin.addons.xterm.XTerm;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.util.ListIterator;
import java.util.stream.IntStream;
import org.junit.Test;

public class SerializationTest {

  private <T> T shake(T obj) throws IOException, ClassNotFoundException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();

    try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
      oos.writeObject(obj);
    }

    try (ObjectInputStream in =
        new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()))) {
      obj.getClass().cast(in.readObject());
    }

    return obj;
  }

  @Test
  public void testSerialization() throws ClassNotFoundException, IOException {
    shake(new XTerm());
  }

}
