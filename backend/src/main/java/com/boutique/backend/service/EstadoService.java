package com.boutique.backend.service;

import com.boutique.backend.entity.Estado;
import com.boutique.backend.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public List<Estado> buscarTodos(){
        return estadoRepository.findAll();
    }

    public Estado inserir(Estado estado){
            estado.setDataCriacao(new Date());
            Estado estadoNovo = estadoRepository.saveAndFlush(estado);
            return estadoNovo;
    }

    public Estado alterar(Estado estado){
        estado.setDataAtualizacao(new Date());
        return estadoRepository.saveAndFlush(estado);
    }

    public void excluir(Long id){
        Estado estado = estadoRepository.findById(id).get();
        estadoRepository.delete(estado);
    }

}
