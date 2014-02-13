/**
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
package org.wso2.developerstudio.eclipse.esb.mediators.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ViewerNotification;


import org.wso2.developerstudio.eclipse.esb.ModelObjectState;
import org.wso2.developerstudio.eclipse.esb.mediators.ConditionalRouteBranch;
import org.wso2.developerstudio.eclipse.esb.mediators.MediatorsPackage;
import org.wso2.developerstudio.eclipse.esb.provider.EsbEditPlugin;
import org.wso2.developerstudio.eclipse.esb.provider.MediatorBranchItemProvider;

/**
 * This is the item provider adapter for a {@link org.wso2.developerstudio.eclipse.esb.mediators.ConditionalRouteBranch} object.
 * <!-- begin-user-doc --> <!-- end-user-doc -->
 * @generated
 */
public class ConditionalRouteBranchItemProvider extends
		MediatorBranchItemProvider implements IEditingDomainItemProvider,
		IStructuredItemContentProvider, ITreeItemContentProvider,
		IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public ConditionalRouteBranchItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addBreakAfterRoutePropertyDescriptor(object);
			addEvaluatorExpressionPropertyDescriptor(object);
			addTargetSequencePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Break After Route feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addBreakAfterRoutePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConditionalRouteBranch_breakAfterRoute_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConditionalRouteBranch_breakAfterRoute_feature", "_UI_ConditionalRouteBranch_type"),
				 MediatorsPackage.Literals.CONDITIONAL_ROUTE_BRANCH__BREAK_AFTER_ROUTE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Evaluator Expression feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEvaluatorExpressionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConditionalRouteBranch_evaluatorExpression_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConditionalRouteBranch_evaluatorExpression_feature", "_UI_ConditionalRouteBranch_type"),
				 MediatorsPackage.Literals.CONDITIONAL_ROUTE_BRANCH__EVALUATOR_EXPRESSION,
				 true,
				 true,
				 false,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Target Sequence feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTargetSequencePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ConditionalRouteBranch_targetSequence_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ConditionalRouteBranch_targetSequence_feature", "_UI_ConditionalRouteBranch_type"),
				 MediatorsPackage.Literals.CONDITIONAL_ROUTE_BRANCH__TARGET_SEQUENCE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This returns ConditionalRouteBranch.gif.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ConditionalRouteBranch"));
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * 
	 * 
	 */
	
	public String getText(Object object) {

		return getString("_UI_ConditionalRouteBranch_type");
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(ConditionalRouteBranch.class)) {
			case MediatorsPackage.CONDITIONAL_ROUTE_BRANCH__BREAK_AFTER_ROUTE:
			case MediatorsPackage.CONDITIONAL_ROUTE_BRANCH__EVALUATOR_EXPRESSION:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s
	 * describing the children that can be created under this object. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	
	@Override
	protected void collectNewChildDescriptors(
			Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

	/**
	 * Return the resource locator for this item provider's resources. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	
	@Override
	public ResourceLocator getResourceLocator() {
		return EsbEditPlugin.INSTANCE;
	}

}
