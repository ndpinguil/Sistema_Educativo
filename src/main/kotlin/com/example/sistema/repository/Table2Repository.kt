package com.example.sistema.repository

import com.example.sistema.model.Table2Model
import com.example.sistema.model.TableModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface Table2Repository : JpaRepository<Table2Model, Long?> {
    fun findById (id: Long?): Table2Model?

}