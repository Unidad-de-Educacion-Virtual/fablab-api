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

    public Optional<TipoDocumento> actualizarTipoDocumento(Long id, TipoDocumento tipoDocumentoActualizado) {
        return tipoDocumentoRepository.findById(id).map(tipoDocumento -> {
            tipoDocumento.setDescripcion(tipoDocumentoActualizado.getDescripcion());
            return tipoDocumentoRepository.save(tipoDocumento);
        });
    }

    public void eliminarTipoDocumento(Long id) {
        tipoDocumentoRepository.deleteById(id);
    }
}
