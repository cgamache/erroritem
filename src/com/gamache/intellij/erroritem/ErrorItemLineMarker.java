package com.gamache.intellij.erroritem;

import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo;
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerProvider;
import com.intellij.codeInsight.navigation.NavigationGutterIconBuilder;
import com.intellij.icons.AllIcons;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiErrorElement;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public class ErrorItemLineMarker extends RelatedItemLineMarkerProvider {

    @Override
    protected void collectNavigationMarkers(@NotNull PsiElement element, Collection<? super RelatedItemLineMarkerInfo> result) {

        if (element instanceof PsiErrorElement) {
            PsiErrorElement errorElement = (PsiErrorElement) element;
            String value = errorElement.getErrorDescription() instanceof String ? (String) errorElement.getErrorDescription() : null;
            if (value != null) {
                NavigationGutterIconBuilder<PsiElement> builder =
                        NavigationGutterIconBuilder.create(AllIcons.Nodes.ErrorIntroduction)
                                .setTargets()
                                .setTooltipText(value);
                result.add(builder.createLineMarkerInfo(element));
            }
        }
    }


}