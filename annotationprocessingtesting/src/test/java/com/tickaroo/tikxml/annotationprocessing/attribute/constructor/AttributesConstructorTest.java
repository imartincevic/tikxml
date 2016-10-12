/*
 * Copyright (C) 2015 Hannes Dorfmann
 * Copyright (C) 2015 Tickaroo, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.tickaroo.tikxml.annotationprocessing.attribute.constructor;

import com.tickaroo.tikxml.TikXml;
import com.tickaroo.tikxml.annotationprocessing.DateConverter;
import com.tickaroo.tikxml.annotationprocessing.TestUtils;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import org.junit.*;

/**
 * @author Hannes Dorfmann
 */
public class AttributesConstructorTest {

  @Test
  public void fieldAccess() throws IOException, ParseException {
    TikXml xml = new TikXml.Builder().exceptionOnUnreadXml(true).build();

    ItemConstructor item = xml.read(TestUtils.sourceForFile("attributes.xml"), ItemConstructor.class);

    Date date = DateConverter.format.parse("1988-03-04");

    Assert.assertEquals("foo", item.getAString());
    Assert.assertEquals(123, item.getAnInt());
    Assert.assertEquals(true, item.isABoolean());
    Assert.assertEquals(23.42, item.getADouble(), 0);
    Assert.assertEquals(2147483648L, item.getALong());
    Assert.assertEquals(date, item.getADate());

    Assert.assertEquals(123, (int) item.getIntWrapper());
    Assert.assertEquals(true, item.getBooleanWrapper());
    Assert.assertEquals(23.42, item.getDoubleWrapper(), 0);
    Assert.assertEquals(2147483648L, (long) item.getLongWrapper());

  }
}