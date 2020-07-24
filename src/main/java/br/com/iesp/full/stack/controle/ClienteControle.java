package br.com.iesp.full.stack.controle;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.iesp.full.stack.dto.ClienteDto;
import br.com.iesp.full.stack.servico.ClienteServico;

@RestController
@RequestMapping("/clientes")
public class ClienteControle implements IControler<ClienteDto, Serializable> {

	@Autowired
	private ClienteServico clienteServico;

	@Override
	@PostMapping("/salvar")
	public void salvar(@RequestBody @Valid ClienteDto object, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			attributes.addAttribute("mensagem", "Erro de Validação!");
		}
		attributes.addAttribute("mensagem", "Cliente salvo com sucesso");
		this.clienteServico.salvar(object);
	}

	@Override
	@GetMapping("/atualisar/{id}")
	public void atualisar(@RequestBody @Valid ClienteDto object, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			attributes.addAttribute("mensagem", "Erro de Validação!");
		}
		attributes.addAttribute("mensagem", "Cliente alterado com sucesso");
		this.clienteServico.alterar(object);
	}

	@Override
	@DeleteMapping("/remover/{id}")
	public void remover(@PathVariable Long id, RedirectAttributes attributes) {
		this.clienteServico.remover(id);
		attributes.addFlashAttribute("removido", "Cliente removido com sucesso!");
	}

	@Override
	@GetMapping
	public List<ClienteDto> listar(@ModelAttribute("filtro") ClienteDto filtro) {
		if (!StringUtils.isEmpty(filtro) && filtro.getId() != null) {
			return this.clienteServico.listar(filtro);
		} else {
			return clienteServico.listar();
		}
	}

	@Override
	@GetMapping("/buscar/{id}")
	public ClienteDto buscar(Long id) {
		return this.clienteServico.buscar(id);
	}

}
