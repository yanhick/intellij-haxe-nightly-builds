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
import com.intellij.openapi.util.Pair;
import com.intellij.plugins.haxe.lang.lexer.HaxeTokenTypes;
import com.intellij.plugins.haxe.lang.psi.*;
import com.intellij.plugins.haxe.util.UsefulPsiTreeUtil;
import com.intellij.psi.*;
import com.intellij.psi.impl.InheritanceImplUtil;
import com.intellij.psi.impl.PsiClassImplUtil;
import com.intellij.psi.impl.PsiImplUtil;
import com.intellij.psi.impl.PsiSuperMethodImplUtil;
import com.intellij.psi.impl.java.stubs.JavaStubElementTypes;
import com.intellij.psi.impl.java.stubs.PsiTypeParameterListStub;
import com.intellij.psi.impl.java.stubs.PsiTypeParameterStub;
import com.intellij.psi.impl.meta.MetaRegistry;
import com.intellij.psi.javadoc.PsiDocComment;
import com.intellij.psi.meta.PsiMetaData;
import com.intellij.psi.scope.PsiScopeProcessor;
import com.intellij.psi.search.SearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import com.intellij.psi.util.PsiTypesUtil;
import com.intellij.psi.util.PsiUtil;
import com.intellij.util.IncorrectOperationException;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.util.Collection;
import java.util.List;

/**
 * Created by ebishton on 10/18/14.
 */
public class HaxeTypeParamPsiMixinImpl extends HaxePsiCompositeElementImpl implements HaxeTypeParamPsiMixin {

  public HaxeTypeParamPsiMixinImpl(ASTNode node) {
    super(node);
  }

  @Override
  public PsiTypeParameter[] getTypeParameters() {
    HaxeTypeList list = (HaxeTypeList) UsefulPsiTreeUtil.getChildOfType(this, HaxeTokenTypes.TYPE_LIST);
    HaxeTypeListPart[] parts = UsefulPsiTreeUtil.getChildrenOfType(list, HaxeTypeListPart.class, null);
    return null != parts ? parts : new PsiTypeParameter[0];
  }

  @Override
  public int getTypeParameterIndex(PsiTypeParameter typeParameter) {
    PsiTypeParameter[] params = getTypeParameters();
    int i = 0;
    for (; i < params.length; ++i) {
      if (typeParameter == params[i]) {
        break;
      }
    }
    return i < params.length ? i : -1;
  }


}
