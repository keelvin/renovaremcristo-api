package br.com.renovar.apirenovar.domain.pgreport.usecase

import br.com.renovar.apirenovar.domain.exceptions.SaveException
import br.com.renovar.apirenovar.domain.pgreport.entity.PgReport
import kotlin.jvm.Throws

interface SaveReportUseCase {
    @Throws(exceptionClasses = [SaveException::class])
    fun execute(obj: PgReport): PgReport
}