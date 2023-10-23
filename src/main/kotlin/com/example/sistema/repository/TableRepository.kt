package com.example.sistema.repository

import com.example.sistema.model.TableModel
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface TableRepository  : JpaRepository<TableModel, Long?> {

    fun findById (id: Long?): TableModel?

}
