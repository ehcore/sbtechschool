package com.ehcore.javaschool.lesson6reflection;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Skip {

}
