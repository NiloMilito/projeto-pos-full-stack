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

import br.com.iesp.full.stack.dto.PrestadorDto;
import br.com.iesp.full.stack.servico.PrestadorServico;

@Controller
@RequestMapping("/prestador")
public class PrestadorControle implements IControler<PrestadorDto, Serializable> {

	@Autowired
	private PrestadorServico prestadorServico;

	@Override
	@PostMapping("/salvar")
	public void salvar(@Valid PrestadorDto object, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			attributes.addAttribute("mensagem", "Erro de Validação");
		}
		attributes.addAttribute("mensagem", "Prestador de Serviço salvo com sucesso");
		this.prestadorServico.salvar(object);
	}

	@Override
	@GetMapping("/atualisar/{id}")
	public void atualisar(@Valid PrestadorDto object, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			attributes.addAttribute("mensagem", "Erro de Validação");
		}
		attributes.addAttribute("mensagem", "Prestador de Serviço alterado com sucesso");
		this.prestadorServico.salvar(object);
	}

	@Override
	@DeleteMapping("/remover/{id}")
	public void remover(@PathVariable Long id, RedirectAttributes attributes) {
		this.prestadorServico.remover(id);
		attributes.addFlashAttribute("removido", "Prestador de Serviço removido com sucesso!");
	}

	@Override
	@GetMapping
	public List<PrestadorDto> listar(@ModelAttribute("filtro") PrestadorDto filtro) {
		if (!StringUtils.isEmpty(filtro)) {
			return this.prestadorServico.listar(filtro);
		} else {
			return prestadorServico.listar();
		}
	}

	@Override
	@GetMapping("/buscar/{id}")
	public PrestadorDto buscar(Long id) {
		return this.prestadorServico.buscar(id);
	}

}
