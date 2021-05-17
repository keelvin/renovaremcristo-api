package br.com.renovar.apirenovar.app.commons

import org.springframework.data.jpa.repository.JpaRepository

interface BaseRepository<T: BaseModel, ID: Any> : JpaRepository<T, ID>