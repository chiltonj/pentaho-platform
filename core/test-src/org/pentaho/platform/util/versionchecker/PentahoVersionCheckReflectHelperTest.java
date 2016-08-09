/*!
* This program is free software; you can redistribute it and/or modify it under the
* terms of the GNU Lesser General Public License, version 2.1 as published by the Free Software
* Foundation.
*
* You should have received a copy of the GNU Lesser General Public License along with this
* program; if not, you can obtain a copy at http://www.gnu.org/licenses/old-licenses/lgpl-2.1.html
* or from the Free Software Foundation, Inc.,
* 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
*
* This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
* without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
* See the GNU Lesser General Public License for more details.
*
* Copyright (c) 2002-2016 Pentaho Corporation..  All rights reserved.
*/
package org.pentaho.platform.util.versionchecker;


import org.apache.commons.io.input.ReaderInputStream;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class PentahoVersionCheckReflectHelperTest {

  @Test
  public void performVersionCheckTest() {
    List results = PentahoVersionCheckReflectHelper.performVersionCheck( false, -1 );
    assertNotNull( results );
    assertTrue( results.size() > 0 );
    validateResult( results.get( 0 ).toString() );
  }

  private void validateResult( String result ) {

    try {
      DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
      StringReader stringReader = new StringReader( result  );
      documentBuilder.parse( new ReaderInputStream( stringReader ) );
    } catch ( ParserConfigurationException | SAXException | IOException e ) {
      assertTrue( "unexpected exception", false );
    }
  }
}
