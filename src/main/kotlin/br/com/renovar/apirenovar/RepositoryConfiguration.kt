package br.com.renovar.apirenovar

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.transaction.annotation.EnableTransactionManagement

@Configuration
@EnableJpaRepositories(basePackages = ["br.com.renovar.apirenovar.app.dataprovider"])
@EntityScan(basePackages = ["br.com.renovar.apirenovar.app.dataprovider"])
@EnableTransactionManagement
class RepositoryConfiguration