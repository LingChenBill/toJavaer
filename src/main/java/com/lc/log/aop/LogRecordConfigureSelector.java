package com.lc.log.aop;

import com.lc.log.config.LogRecordProxyAutoConfiguration;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author: lingchen
 * @date: 2022/5/21
 */
public class LogRecordConfigureSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        return new String[] {
                LogRecordProxyAutoConfiguration.class.getName()
        };
    }

    // @Override
    // public Predicate<String> getExclusionFilter() {
    //     return ImportSelector.super.getExclusionFilter();
    // }
}
