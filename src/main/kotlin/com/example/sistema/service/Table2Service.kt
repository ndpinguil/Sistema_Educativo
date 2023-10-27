package com.example.sistema.service

import com.example.sistema.model.Table2Model
import com.example.sistema.model.TableModel
import com.example.sistema.repository.Table2Repository
import com.example.sistema.repository.TableRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class Table2Service {
    @Autowired
    lateinit var modeloRepository: Table2Repository

    fun list ():List<Table2Model>{
        return modeloRepository.findAll()
    }

    fun save(modelo: Table2Model): Table2Model{
        try{
            return modeloRepository.save(modelo)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun update(modelo: Table2Model): Table2Model{
        try {
            modeloRepository.findById(modelo.id)
                    ?: throw Exception("ID no existe")

            return modeloRepository.save(modelo)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun listById (id:Long?):Table2Model?{
        return modeloRepository.findById(id)
    }
    fun delete (id: Long?):Boolean?{
        try{
            val response = modeloRepository.findById(id)
                    ?: throw Exception("ID no disponible por hoy")
            modeloRepository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
}
