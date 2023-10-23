package com.example.sistema.service

import com.example.sistema.model.TableModel
import com.example.sistema.repository.TableRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Service
class TableService {
    @Autowired
    lateinit var modeloRepository: TableRepository

    fun list ():List<TableModel>{
    return modeloRepository.findAll()
    }

    fun save(modelo: TableModel): TableModel{
        try{
            return modeloRepository.save(modelo)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }

    fun update(modelo: TableModel): TableModel{
        try {
            modeloRepository.findById(modelo.id)
                    ?: throw Exception("ID no existe")

            return modeloRepository.save(modelo)
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
    fun listById (id:Long?):TableModel?{
        return modeloRepository.findById(id)
    }
    fun delete (id: Long?):Boolean?{
        try{
            val response = modeloRepository.findById(id)
                    ?: throw Exception("ID no existe")
            modeloRepository.deleteById(id!!)
            return true
        }
        catch (ex:Exception){
            throw ResponseStatusException(HttpStatus.NOT_FOUND,ex.message)
        }
    }
}

























