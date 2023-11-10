package com.example.sistema.controller

import com.example.sistema.model.Table2Model
import com.example.sistema.model.TableModel
import com.example.sistema.service.Table2Service
import com.example.sistema.service.TableService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/Table2Model")   //endpoint
class Table2Controller {
    @Autowired
    lateinit var modeloService: Table2Service

    @GetMapping
    fun list(): List<Table2Model> {
        return modeloService.list()
    }

    @PostMapping
    fun save(@RequestBody modelo: Table2Model): ResponseEntity<Table2Model> {
        return ResponseEntity(modeloService.save(modelo), HttpStatus.OK)
    }

    @PutMapping
    fun update(@RequestBody modelo: Table2Model): ResponseEntity<Table2Model> {
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
    fun updateName (@RequestBody modelo:Table2Model):ResponseEntity<Table2Model>{
        return ResponseEntity(modeloService.update(modelo), HttpStatus.OK)
    }
}