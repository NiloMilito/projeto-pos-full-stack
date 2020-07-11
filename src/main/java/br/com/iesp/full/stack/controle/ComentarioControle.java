package br.com.iesp.full.stack.controle;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.iesp.full.stack.dto.ComentarioDto;
import br.com.iesp.full.stack.servico.ComentarioServico;
@Controller
@RequestMapping("/comentarios")
public class ComentarioControle implements IControler<ComentarioDto, Serializable>{
	
	@Autowired
	private ComentarioServico comentarioServico;

	@Override
	@PostMapping("/savar")
	public ModelAndView salvar(@Valid ComentarioDto object, BindingResult result, Model model,
			RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView("redirect:/comentarios");
		if (result.hasErrors()) {
			return novo(object);
		}
		attributes.addAttribute("mensagem", "Comentario salvo com sucesso");
		this.comentarioServico.salvar(object);
		return mv;
	}

	@Override
	@GetMapping("/novo")
	public ModelAndView novo(ComentarioDto novo) {
		ModelAndView mv = new ModelAndView("/pages/comentarios/novo");
		mv.addObject("comentario", novo);
		return mv;
	}

	@Override
	@GetMapping("/atualisar/{id}")
	public ModelAndView atualisar(@PathVariable("id") Long id) {
		ComentarioDto comentarioDto = this.comentarioServico.buscar(id);
		return novo(comentarioDto);
	}

	@Override
	@DeleteMapping("/remover/{id}")
	public ModelAndView remover(@PathVariable Long id, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView("redirect:/comentarios");
		this.comentarioServico.remover(id);
		attributes.addFlashAttribute("removido", "Comentário removido com sucesso!");
		return mv;
	}

	@Override
	@GetMapping
	public ModelAndView listar(@ModelAttribute("filtro") ComentarioDto filtro) {
		ModelAndView mv = new ModelAndView("/comentarios/listar");
		if (!StringUtils.isEmpty(filtro)) {
			List<ComentarioDto> servicos = this.comentarioServico.listar(filtro);
			mv.addObject("comentarios", servicos);
		} else {
			mv.addObject("comentarios", comentarioServico.listar());
		}
		return mv;
	}

}
