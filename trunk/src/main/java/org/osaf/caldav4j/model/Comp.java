/*
 * Copyright 2005 Open Source Applications Foundation
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.osaf.caldav4j.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.osaf.caldav4j.CalDAVConstants;
import org.osaf.caldav4j.xml.OutputsDOMBase;
import org.osaf.caldav4j.xml.SimpleDOMOutputtingObject;

/**
 * <!ELEMENT param-filter (is-defined | text-match) >
 *
 * <!ATTLIST param-filter name CDATA #REQUIRED>
 *  
 * @author bobbyrullo
 * 
 */
public class Comp extends OutputsDOMBase {
    
    public static final String ELEMENT_NAME = "param-filter";
    public static final String ELEM_IS_DEFINED = "is-defined";
    public static final String ATTR_NAME = "name";
    
    private String caldavNamespaceQualifier = null;

    private boolean isDefined = false;
    private TextMatch textMatch = null;
    private String name = null;
    
    public Comp(String caldavNamespaceQualifier) {
        this.caldavNamespaceQualifier = caldavNamespaceQualifier;
    }

    protected String getElementName() {
        return ELEMENT_NAME;
    }

    protected String getNamespaceQualifier() {
        return caldavNamespaceQualifier;
    }

    protected String getNamespaceURI() {
        return CalDAVConstants.NS_CALDAV;
    }

    protected Collection getChildren() {
        ArrayList children = new ArrayList();
        if (isDefined){
            children.add(new SimpleDOMOutputtingObject(
                    CalDAVConstants.NS_CALDAV, caldavNamespaceQualifier,
                    ELEM_IS_DEFINED));
        } else if (textMatch != null){
            children.add(textMatch);
        }
        
        return children;
    }
    
    protected String getTextContent() {
        return null;
    }
    
    protected Map getAttributes() {
        Map m = new HashMap();
        m.put(ATTR_NAME, name);
        return m;
    }


    public boolean isDefined() {
        return isDefined;
    }

    public void setDefined(boolean isDefined) {
        this.isDefined = isDefined;
    }
    
    public TextMatch getTextMatch() {
        return textMatch;
    }

    public void setTextMatch(TextMatch textMatch) {
        this.textMatch = textMatch;
    }
    
}
