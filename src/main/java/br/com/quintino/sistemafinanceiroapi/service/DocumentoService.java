package br.com.quintino.sistemafinanceiroapi.service;

import br.com.quintino.sistemafinanceiroapi.model.ArquivoDocumentoModel;
import br.com.quintino.sistemafinanceiroapi.model.ArquivoModel;
import br.com.quintino.sistemafinanceiroapi.model.DocumentoModel;
import br.com.quintino.sistemafinanceiroapi.repository.ArquivoDocumentoRepository;
import br.com.quintino.sistemafinanceiroapi.repository.DocumentoImplementationRepository;
import br.com.quintino.sistemafinanceiroapi.repository.DocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentoService {

    @Autowired
    private DocumentoRepository documentoRepository;

    private DocumentoImplementationRepository documentoImplementationRepository;


    @Autowired
    private ArquivoDocumentoRepository arquivoDocumentoRepository;

    public List<DocumentoModel> findAll() {
        return this.documentoRepository.findAll();
    }

    // TODO -- Verificar se o documento já esta cadastrada no sistema
    public DocumentoModel saveOne(DocumentoModel documentoModel) {
        // TODO -- Refatorar. Deve-se implementar persistencia via JPA
        for (ArquivoModel arquivoModel : documentoModel.getArquivoModelList()) {
            ArquivoDocumentoModel arquivoDocumentoModel = new ArquivoDocumentoModel();
                arquivoDocumentoModel.setDocumentoModel(documentoModel);
                arquivoDocumentoModel.setArquivoModel(arquivoModel);
                this.documentoRepository.saveAndFlush(documentoModel);
                this.arquivoDocumentoRepository.save(arquivoDocumentoModel);
        }
        return documentoModel;
    }

    public DocumentoModel updateOne(Long codigo, DocumentoModel documentoModel) {
        DocumentoModel objeto = this.documentoRepository.findById(codigo).get();
        return this.documentoRepository.saveAndFlush(objeto);
    }

    public void deleteOne(Long codigo) {
        this.documentoRepository.delete(this.documentoRepository.findById(codigo).get());
    }

    public List<DocumentoModel> recuperarDocumentoPessoa(Long codigoPessoa) {
        return this.documentoImplementationRepository.recuperarDocumentoPessoa(codigoPessoa);
    }

}
