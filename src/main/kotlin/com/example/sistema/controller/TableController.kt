package com.example.sistema.controller

import com.example.sistema.model.TableModel
import com.example.sistema.service.TableService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/TableModel")   //endpoint
class TableController {
    @Autowired
    lateinit var modeloService: TableService

    @GetMapping
    fun list(): List<TableModel> {
        return modeloService.list()
    }

    @PostMapping
    fun save(@RequestBody modelo: TableModel): ResponseEntity<TableModel> {
        return ResponseEntity(modeloService.save(modelo), HttpStatus.OK)
    }

    @PutMapping
    fun update(@RequestBody modelo: TableModel): ResponseEntity<TableModel> {
        return ResponseEntity(modeloService.update(modelo), HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun listById(@PathVariable("id") id: Long): ResponseEntity<*> {
        return ResponseEntity(modeloService.listById(id), HttpStatus.OK)
    }
    @DeleteMapping("/delete/{id}")
    fun delete(@PathVariable("id") id: Long): Boolean? {
        return modeloService.delete(id)
    }
    @PatchMapping
    fun updateName (@RequestBody modelo:TableModel):ResponseEntity<TableModel>{
        return ResponseEntity(modeloService.updateName(modelo), HttpStatus.OK)
    }
}