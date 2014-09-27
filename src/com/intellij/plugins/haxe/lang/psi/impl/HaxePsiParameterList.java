/*
 * Copyright 2000-2013 JetBrains s.r.o.
 * Copyright 2014-2014 AS3Boyan
 * Copyright 2014-2014 Elias Ku
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
package com.intellij.plugins.haxe.lang.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.plugins.haxe.lang.psi.HaxeParameter;
import com.intellij.plugins.haxe.lang.psi.HaxeParameterList;
import com.intellij.plugins.haxe.util.UsefulPsiTreeUtil;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiParameter;
import com.intellij.psi.PsiParameterList;
import com.intellij.psi.impl.PsiImplUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

import java.util.List;

/**
 * @author: Srikanth.Ganapavarapu
 */
public class HaxePsiParameterList extends HaxePsiCompositeElementImpl implements PsiParameterList {

  public HaxePsiParameterList(ASTNode node) {
    super(node);
  }

  @NotNull
  @Override
  public HaxePsiParameter[] getParameters() {
    HaxePsiParameter[] psiParameters = UsefulPsiTreeUtil.getChildrenOfType(this, HaxePsiParameter.class, null);
    if (psiParameters == null) {
      psiParameters = new HaxePsiParameter[0];
    }
    return psiParameters;
  }

  public List<HaxePsiParameter> getParametersAsList() {
    HaxePsiParameter[] parameters = UsefulPsiTreeUtil.getChildrenOfType(this, HaxePsiParameter.class, null);
    if (parameters == null) {
      parameters = new HaxePsiParameter[0];
    }
    return Arrays.asList(parameters);
  }

  @Override
  public int getParameterIndex(PsiParameter parameter) {
    return PsiImplUtil.getParameterIndex(parameter, this);
  }

  @Override
  public int getParametersCount() {
    HaxePsiParameter[] params = getParameters();
    return params == null ? 0 : getParameters().length;
  }
}
