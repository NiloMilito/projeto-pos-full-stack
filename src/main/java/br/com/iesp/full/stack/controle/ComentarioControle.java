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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.iesp.full.stack.dto.ComentarioDto;
import br.com.iesp.full.stack.servico.ComentarioServico;

@Controller
@RequestMapping("/comentarios")
public class ComentarioControle implements IControler<ComentarioDto, Serializable> {

	@Autowired
	private ComentarioServico comentarioServico;

	@Override
	@PostMapping("/salvar")
	public void salvar(@Valid ComentarioDto object, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			attributes.addAttribute("mensagem", "Erro de validação!");
		}
		attributes.addAttribute("mensagem", "Comentário salvo com sucesso");
		this.comentarioServico.salvar(object);
	}

	@Override
	@GetMapping("/atualisar/{id}")
	public void atualisar(@RequestBody @Valid ComentarioDto object, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			attributes.addAttribute("mensagem", "Erro de validação!");
		}
		attributes.addAttribute("mensagem", "Comentário atualisado com sucesso");
		this.comentarioServico.alterar(object);
	}

	@Override
	@DeleteMapping("/remover/{id}")
	public void remover(@PathVariable Long id, RedirectAttributes attributes) {
		this.comentarioServico.remover(id);
		attributes.addFlashAttribute("removido", "Comentário removido com sucesso!");
	}

	@Override
	@GetMapping
	public List<ComentarioDto> listar(@ModelAttribute("filtro") ComentarioDto filtro) {
		if (!StringUtils.isEmpty(filtro)) {
			return this.comentarioServico.listar(filtro);
		} else {
			return comentarioServico.listar();
		}
	}

	@Override
	@GetMapping("/buscar/{id}")
	public ComentarioDto buscar(Long id) {
		return this.comentarioServico.buscar(id);
	}

}
