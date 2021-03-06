 /*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.netbeans.modules.web.jsf.impl.facesmodel;

import org.netbeans.modules.web.jsf.api.facesmodel.DefaultLocale;
import org.netbeans.modules.web.jsf.api.facesmodel.JSFConfigVisitor;
import org.netbeans.modules.web.jsf.api.facesmodel.LocaleConfig;
import org.w3c.dom.Element;

/**
 *
 * @author Petr Pisl, ads
 */

public class DefaultLocaleImpl extends JSFConfigComponentImpl implements DefaultLocale {
    
    public DefaultLocaleImpl(JSFConfigModelImpl model, Element element) {
        super(model, element);
    }
    
    public DefaultLocaleImpl(JSFConfigModelImpl model) {
        super(model, createElementNS(model, JSFConfigQNames.DEFAULT_LOCALE));
    }
    
    public void accept(JSFConfigVisitor visitor) {
        visitor.visit( this );
    }

    public String getLocale() {
        return getText().trim();    
    }

    public void setLocale(String locale) {
        setText(LocaleConfig.DEFAULT_LOCALE, locale);
    }

    
}
