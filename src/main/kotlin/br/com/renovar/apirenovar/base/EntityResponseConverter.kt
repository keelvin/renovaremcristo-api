package br.com.renovar.apirenovar.base

interface EntityResponseConverter<IN: BaseEntity, OUT: Any> {
    fun convert(source: IN): OUT
}