/*******************************************************************************
 * Copyright (c) 2009 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *     Zend Technologies
 *******************************************************************************/
package org.eclipse.php.internal.core.typeinference.evaluators;

import org.eclipse.dltk.ast.expressions.Expression;
import org.eclipse.dltk.ast.references.TypeReference;
import org.eclipse.dltk.evaluation.types.UnknownType;
import org.eclipse.dltk.ti.GoalState;
import org.eclipse.dltk.ti.goals.ExpressionTypeGoal;
import org.eclipse.dltk.ti.goals.GoalEvaluator;
import org.eclipse.dltk.ti.goals.IGoal;
import org.eclipse.dltk.ti.types.IEvaluatedType;
import org.eclipse.php.internal.core.compiler.ast.nodes.ClassInstanceCreation;
import org.eclipse.php.internal.core.typeinference.context.MethodContext;

public class InstanceCreationEvaluator extends GoalEvaluator {

	private IEvaluatedType result;

	public InstanceCreationEvaluator(IGoal goal) {
		super(goal);
	}

	public IGoal[] init() {
		ExpressionTypeGoal typedGoal = (ExpressionTypeGoal) goal;
		ClassInstanceCreation expression = (ClassInstanceCreation) typedGoal
				.getExpression();
		Expression className = expression.getClassName();
		if ((className instanceof TypeReference)) {
			if (((TypeReference) className).getName().equals("self") //$NON-NLS-1$
					&& (goal.getContext() instanceof MethodContext)) {
				MethodContext methodContext = (MethodContext) goal.getContext();
				result = methodContext.getInstanceType();
				return IGoal.NO_GOALS;
			} else {
				return new IGoal[] { new ExpressionTypeGoal(goal.getContext(),
						className) };
			}
		}
		result = UnknownType.INSTANCE;
		return IGoal.NO_GOALS;
	}

	public Object produceResult() {
		return result;
	}

	public IGoal[] subGoalDone(IGoal subgoal, Object result, GoalState state) {
		this.result = (IEvaluatedType) result;
		return IGoal.NO_GOALS;
	}

}
