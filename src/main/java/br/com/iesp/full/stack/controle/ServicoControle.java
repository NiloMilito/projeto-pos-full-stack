package br.com.iesp.full.stack.controle;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.iesp.full.stack.dto.ServicoDto;
import br.com.iesp.full.stack.servico.ServicoServico;

@Controller
@RequestMapping("/servicos")
public class ServicoControle implements IControler<ServicoDto, Serializable> {

	@Autowired
	private ServicoServico servicoServico;

	@Override
	@PostMapping("/salvar")
	public void salvar(@Valid ServicoDto object, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			attributes.addAttribute("mensagem", "Erro de validação!");
		}
		attributes.addAttribute("mensagem", "Servico salvo com sucesso");
		this.servicoServico.salvar(object);
	}

	@Override
	@GetMapping("/atualisar/{id}")
	public void atualisar(@Valid ServicoDto object, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			attributes.addAttribute("mensagem", "Erro de validação!");
		}
		attributes.addAttribute("mensagem", "Servico alterado com sucesso");
		this.servicoServico.alterar(object);
	}

	@Override
	@DeleteMapping("/remover/{id}")
	public void remover(@PathVariable Long id, RedirectAttributes attributes) {
		this.servicoServico.remover(id);
		attributes.addFlashAttribute("removido", "Serviço removido com sucesso!");
	}

	@Override
	@GetMapping
	public List<ServicoDto> listar(@ModelAttribute("filtro") ServicoDto filtro) {		
		if (!StringUtils.isEmpty(filtro)) {
			return this.servicoServico.listar(filtro);			
		} else {
			return servicoServico.listar();
		}		
	}

	@Override
	@GetMapping("/buscar/{id}")
	public ServicoDto buscar(Long id) {
		return this.servicoServico.buscar(id);		
	}

}
