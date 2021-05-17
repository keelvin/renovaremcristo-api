package br.com.renovar.apirenovar.base

import org.springframework.data.jpa.repository.JpaRepository

interface BaseRepository<T: BaseEntity, ID: Any> : JpaRepository<T, ID>