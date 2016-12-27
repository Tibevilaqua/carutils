package com.caroffice.infrastructure.utils;

import com.caroffice.endpoint.oil.OilDTO;
import org.junit.Assert;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Created by root on 27/12/16.
 */
public class AnnotationCheckHelper {


    /**
     *
     * @return True if some annotation is assigned with the Field, false otherwise
     */
    public static boolean doesFieldContainsAnnotation(Class classToBeChecked, String fieldName, Class annotationToBeChecked){
        try {

            Field declaredField = classToBeChecked.getDeclaredField(fieldName);
            Annotation annotation = declaredField.getAnnotation(annotationToBeChecked);
            if(null == annotation){
               return false;
            }

        } catch (NoSuchFieldException e) {
            //If there's no field, then, false.
           return false;
        }

        return true;
    }

    /**
     * @return if Field has some annotation, false otherwise.
     * @throws NoSuchFieldException
     */
    public static boolean isThereAnyPresentAnnotation(Class classToBeChecked, String fieldName) throws NoSuchFieldException {

        Annotation[] declaredAnnotations = classToBeChecked.getDeclaredField(fieldName).getDeclaredAnnotations();
        return declaredAnnotations != null && declaredAnnotations.length > 0 ? true : false;

    }



}
