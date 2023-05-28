package br.com.quintino.sistemafinanceiroapi.service;

import br.com.quintino.sistemafinanceiroapi.model.DocumentoModel;
import br.com.quintino.sistemafinanceiroapi.repository.DocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentoService {

    @Autowired
    private DocumentoRepository documentoRepository;

    public List<DocumentoModel> findAll() {
        return this.documentoRepository.findAll();
    }

    // TODO -- Verificar se o documento já esta cadastrada no sistema
    public DocumentoModel saveOne(DocumentoModel documentoModel) {
        return this.documentoRepository.saveAndFlush(documentoModel);
    }

    public DocumentoModel updateOne(Long codigo, DocumentoModel documentoModel) {
        DocumentoModel objeto = this.documentoRepository.findById(codigo).get();
        return this.documentoRepository.saveAndFlush(objeto);
    }

    public void deleteOne(Long codigo) {
        this.documentoRepository.delete(this.documentoRepository.findById(codigo).get());
    }

}
