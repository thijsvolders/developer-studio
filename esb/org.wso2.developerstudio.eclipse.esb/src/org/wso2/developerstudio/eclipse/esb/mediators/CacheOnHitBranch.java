/*
 * Copyright 2009-2010 WSO2, Inc. (http://wso2.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.wso2.developerstudio.eclipse.esb.mediators;

import org.wso2.developerstudio.eclipse.esb.MediatorBranch;
import org.wso2.developerstudio.eclipse.esb.RegistryKeyProperty;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Cache On Hit Branch</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.CacheOnHitBranch#getSequenceType <em>Sequence Type</em>}</li>
 *   <li>{@link org.wso2.developerstudio.eclipse.esb.mediators.CacheOnHitBranch#getSequenceKey <em>Sequence Key</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getCacheOnHitBranch()
 * @model
 * @generated
 */
public interface CacheOnHitBranch extends MediatorBranch {
	/**
	 * Returns the value of the '<em><b>Sequence Type</b></em>' attribute.
	 * The default value is <code>"REGISTRY_REFERENCE"</code>.
	 * The literals are from the enumeration {@link org.wso2.developerstudio.eclipse.esb.mediators.CacheSequenceType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sequence Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sequence Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CacheSequenceType
	 * @see #setSequenceType(CacheSequenceType)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getCacheOnHitBranch_SequenceType()
	 * @model default="REGISTRY_REFERENCE"
	 * @generated
	 */
	CacheSequenceType getSequenceType();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.CacheOnHitBranch#getSequenceType <em>Sequence Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sequence Type</em>' attribute.
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.CacheSequenceType
	 * @see #getSequenceType()
	 * @generated
	 */
	void setSequenceType(CacheSequenceType value);

	/**
	 * Returns the value of the '<em><b>Sequence Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sequence Key</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sequence Key</em>' reference.
	 * @see #setSequenceKey(RegistryKeyProperty)
	 * @see org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage#getCacheOnHitBranch_SequenceKey()
	 * @model
	 * @generated
	 */
	RegistryKeyProperty getSequenceKey();

	/**
	 * Sets the value of the '{@link org.wso2.developerstudio.eclipse.esb.mediators.CacheOnHitBranch#getSequenceKey <em>Sequence Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sequence Key</em>' reference.
	 * @see #getSequenceKey()
	 * @generated
	 */
	void setSequenceKey(RegistryKeyProperty value);

} // CacheOnHitBranch
