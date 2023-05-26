package br.com.quintino.sistemafinanceiroapi.service;

import br.com.quintino.sistemafinanceiroapi.model.ArquivoModel;
import br.com.quintino.sistemafinanceiroapi.model.PessoaModel;
import br.com.quintino.sistemafinanceiroapi.repository.ArquivoRepository;
import br.com.quintino.sistemafinanceiroapi.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ArquivoService {

    @Autowired
    private ArquivoRepository arquivoRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Value("${diretorio}")
    private String DIRETORIO_STORAGE;

    public List<ArquivoModel> findAll() {
        return this.arquivoRepository.findAll();
    }

    public List<ArquivoModel> saveOne(Long codigoPessoaResponsavel, List<MultipartFile> multipartFileList) {
        List<ArquivoModel> arquivoModelList = new ArrayList<>();
        PessoaModel pessoaModel = this.pessoaRepository.findById(codigoPessoaResponsavel).get();
        for (MultipartFile multipartFile : multipartFileList) {
            this.gravarArquivoDisco(pessoaModel.getNome(), multipartFile);
            arquivoModelList.add(this.arquivoRepository.saveAndFlush(this.configurarArquivo(multipartFile)));
        }
        return arquivoModelList;
    }

    public ArquivoModel updateOne(Long codigo, ArquivoModel arquivoModel) {
        ArquivoModel objetoCadastrado = this.arquivoRepository.findById(codigo).get();
        return this.arquivoRepository.saveAndFlush(objetoCadastrado);
    }

    public void deleteOne(Long codigo) {
        this.arquivoRepository.delete(this.arquivoRepository.findById(codigo).get());
    }

    // TODO -- Criar classe de service especificamente para o gerenciamento de arquivos
    // TODO -- Ao Remover uma pessoa do sistema deve-se excluir seus arquivos
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

    private void gravarArquivoDisco(String nomeDiretorio, MultipartFile multipartFile) {
        try {
            if (!multipartFile.isEmpty()) {
                String caminho = this.criarDiretorio(nomeDiretorio, multipartFile.getOriginalFilename());
                Path path = Paths.get(caminho, multipartFile.getOriginalFilename());
                Files.write(path, multipartFile.getBytes());
            }
        } catch (Exception exception) {
            System.out.println("[ERROR] "+ exception);
        }
    }

    private String criarDiretorio(String nomeDiretorio, String nomeArquivo) {
        File file = new File(DIRETORIO_STORAGE + "/" + nomeDiretorio);
            if (file.mkdir()) {
                System.out.println("[SISTEMAFINANCEIROAPI] Diretorio '" + nomeDiretorio + "' criado com Sucesso!");
            }
        return file.getAbsolutePath();
    }

}
