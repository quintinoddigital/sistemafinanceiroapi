package br.com.quintino.sistemafinanceiroapi.service;

import br.com.quintino.sistemafinanceiroapi.model.ArquivoModel;
import br.com.quintino.sistemafinanceiroapi.repository.ArquivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@Service
public class ArquivoService {

    @Autowired
    private ArquivoRepository arquivoRepository;

    public List<ArquivoModel> findAll() {
        return this.arquivoRepository.findAll();
    }

    public ArquivoModel saveOne(MultipartFile multipartFile) {
        ArquivoModel arquivoModel = new ArquivoModel();
            arquivoModel.setNome(multipartFile.getName());
            arquivoModel.setFormato(multipartFile.getContentType());
            arquivoModel.setTamanho(multipartFile.getSize());
            arquivoModel.setDataCadastro(new Date());
            arquivoModel.setDataAtualizacao(new Date());
            arquivoModel.setDescricao(multipartFile.getOriginalFilename());
        return this.arquivoRepository.saveAndFlush(arquivoModel);
    }

    public ArquivoModel updateOne(Long codigo, ArquivoModel arquivoModel) {
        ArquivoModel objetoCadastrado = this.arquivoRepository.findById(codigo).get();
        return this.arquivoRepository.saveAndFlush(objetoCadastrado);
    }

    public void deleteOne(Long codigo) {
        this.arquivoRepository.delete(this.arquivoRepository.findById(codigo).get());
    }



}
