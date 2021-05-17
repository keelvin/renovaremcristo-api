package br.com.renovar.apirenovar.base

@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER,
    AnnotationTarget.FIELD
)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class Validation(
    val required: Boolean = false,
    val description: String = ""
)