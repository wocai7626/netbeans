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
package org.netbeans.modules.j2ee.jpa.verification.fixes;

import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import org.netbeans.api.java.source.ElementHandle;
import org.netbeans.modules.j2ee.jpa.model.JPAAnnotations;
import org.openide.filesystems.FileObject;
import org.openide.util.NbBundle;

/**
 *
 * @author Tomasz.Slota@Sun.COM
 */
public class CreateUnidirManyToOneRelationship extends AbstractCreateAnnotationHint{

    public CreateUnidirManyToOneRelationship(FileObject fileObject,
            ElementHandle<TypeElement> classHandle,
            ElementHandle<Element> elemHandle) {
        super(fileObject, classHandle, elemHandle, JPAAnnotations.MANY_TO_ONE);
    }

    public String getText(){
        return NbBundle.getMessage(CreateUnidirManyToOneRelationship.class, "LBL_CreateUnidirManyToOneRelationship");
    }
}
