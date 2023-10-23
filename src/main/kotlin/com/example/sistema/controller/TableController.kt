package com.example.sistema.controller

import com.example.sistema.model.TableModel
import com.example.sistema.service.TableService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/TableModel")   //endpoint
class TableController {
    @Autowired
    lateinit var modeloService: TableService

    @GetMapping
    fun list ():List <TableModel>{
        return modeloService.list()
    }
    @PostMapping
    fun save (@RequestBody modelo:TableModel):ResponseEntity<TableModel>{
        return ResponseEntity(modeloService.save(modelo), HttpStatus.OK)
    }

    @PutMapping
    fun update (@RequestBody modelo:TableModel):ResponseEntity<TableModel>{
        return ResponseEntity(modeloService.update(modelo), HttpStatus.OK)
    }
}