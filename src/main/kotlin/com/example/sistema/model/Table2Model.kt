package com.example.sistema.model

import jakarta.persistence.*


@Entity
@Table(name = "table2")
class Table2Model {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var docente: String? = null

}