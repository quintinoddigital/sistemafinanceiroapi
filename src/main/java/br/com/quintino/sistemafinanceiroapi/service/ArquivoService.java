package br.com.quintino.sistemafinanceiroapi.service;

import br.com.quintino.sistemafinanceiroapi.model.ArquivoModel;
import br.com.quintino.sistemafinanceiroapi.repository.ArquivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

@Service
public class ArquivoService {

    @Autowired
    private ArquivoRepository arquivoRepository;

    @Value("${diretorio}")
    private String DIRETORIO_STORAGE;

    public List<ArquivoModel> findAll() {
        return this.arquivoRepository.findAll();
    }

    public ArquivoModel saveOne(MultipartFile multipartFile) {
        this.gravarArquivoDisco(multipartFile);
        return this.arquivoRepository.saveAndFlush(this.configurarArquivo(multipartFile));
    }

    public ArquivoModel updateOne(Long codigo, ArquivoModel arquivoModel) {
        ArquivoModel objetoCadastrado = this.arquivoRepository.findById(codigo).get();
        return this.arquivoRepository.saveAndFlush(objetoCadastrado);
    }

    public void deleteOne(Long codigo) {
        this.arquivoRepository.delete(this.arquivoRepository.findById(codigo).get());
    }

    private ArquivoModel configurarArquivo(MultipartFile multipartFile) {
        ArquivoModel arquivoModel = new ArquivoModel();
            arquivoModel.setNome(multipartFile.getName());
            arquivoModel.setFormato(multipartFile.getContentType());
            arquivoModel.setTamanho(multipartFile.getSize());
            arquivoModel.setDataCadastro(new Date());
            arquivoModel.setDataAtualizacao(new Date());
            arquivoModel.setDescricao(multipartFile.getOriginalFilename());
        return arquivoModel;
    }

    private void gravarArquivoDisco(MultipartFile multipartFile) {
        try {
            if (!multipartFile.isEmpty()) {
                byte[] byteList = multipartFile.getBytes();
                Path path = Paths.get(DIRETORIO_STORAGE, multipartFile.getOriginalFilename());
                Files.write(path, byteList);
                this.criarDiretorio(multipartFile.getOriginalFilename());
            }
        } catch (Exception exception) {
            System.out.println("[API ERROR] "+ exception);
        }
    }

    // TODO -- Criar diretorio e salvar o arquivo com identificador (Dia, Mes, Ano)
    private boolean criarDiretorio(String nome) {
        File file = new File(DIRETORIO_STORAGE + "/" + "NEW FOLDER");
            if (file.mkdir()) {
                return true;
            }
        return false;
    }

}
