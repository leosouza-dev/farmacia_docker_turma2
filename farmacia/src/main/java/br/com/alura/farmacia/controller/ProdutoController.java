package br.com.alura.farmacia.controller;

import br.com.alura.farmacia.dto.AtualizaProdutoDTO;
import br.com.alura.farmacia.dto.DadosCadastroDTO;
import br.com.alura.farmacia.dto.DadosRetornoDTO;
import br.com.alura.farmacia.model.fabricante.Fabricante;
import br.com.alura.farmacia.model.produto.Produto;
import br.com.alura.farmacia.repository.FabricanteRepository;
import br.com.alura.farmacia.repository.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
//@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private FabricanteRepository fabricanteRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroDTO dadosCadastro, UriComponentsBuilder uriBuilder){
        Fabricante fabricante = fabricanteRepository.findByNome(dadosCadastro.nomeFabricante());
        if(fabricante == null){
            fabricante = new Fabricante(dadosCadastro);
        }
        fabricanteRepository.save(fabricante);

        var produto = new Produto(dadosCadastro, fabricante);
        produtoRepository.save(produto);


        var uri = uriBuilder.path("{id}").buildAndExpand(produto.getId()).toUri();

        //return ResponseEntity.ok(new DadosRetornoDTO(produto));

        return ResponseEntity.created(uri).body(new DadosRetornoDTO(produto));
    }

    @GetMapping("/{id}")
    public ResponseEntity detalahar(@PathVariable int id){
        var produto = produtoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DadosRetornoDTO(produto));
    }

    @GetMapping
    public ResponseEntity<Page<DadosRetornoDTO>> listar(@PageableDefault(size = 2, sort = {"nome"}) Pageable paginacao){
        var page = produtoRepository.findAll(paginacao).map(DadosRetornoDTO::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid AtualizaProdutoDTO produtoDTO){
        var produto = produtoRepository.getReferenceById(produtoDTO.id());
        System.out.println(produtoDTO);
        produto.atualizar(produtoDTO);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable int id){
        produtoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }




}
