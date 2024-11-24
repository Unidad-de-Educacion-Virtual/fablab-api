package com.example.demo.services;

import com.example.demo.entities.TipoDocumento;
import com.example.demo.repositories.TipoDocumentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoDocumentoService {

    private final TipoDocumentoRepository tipoDocumentoRepository;

    public TipoDocumentoService(TipoDocumentoRepository tipoDocumentoRepository) {
        this.tipoDocumentoRepository = tipoDocumentoRepository;
    }

    public TipoDocumento buscarTipoDocumento(long id) {
        return tipoDocumentoRepository.getReferenceById(id);
    }

    public List<TipoDocumento> listarTipoDocumento() {
        return tipoDocumentoRepository.findAll();
    }

    public TipoDocumento crearTipoDocumento(TipoDocumento tipoDocumento) {
        return tipoDocumentoRepository.save(tipoDocumento);
    }

    public Optional<TipoDocumento> actualizarTipoDocumento(Long id, String descripcion) {
        return tipoDocumentoRepository.findById(id).map(tipoDocumento -> {
            tipoDocumento.setDescripcion(descripcion);
            return tipoDocumentoRepository.save(tipoDocumento);
        });
    }


    public Optional<TipoDocumento> eliminarTipoDocumento(Long id) {
        return tipoDocumentoRepository.findById(id).map(tipoDocumento -> {
            tipoDocumentoRepository.delete(tipoDocumento);
            return tipoDocumento;
        });
    }

}
