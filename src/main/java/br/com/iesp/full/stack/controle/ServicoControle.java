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

import br.com.iesp.full.stack.dto.ServicoDto;
import br.com.iesp.full.stack.servico.ServicoServico;

@Controller
@RequestMapping("/servicos")
public class ServicoControle implements IControler<ServicoDto, Serializable> {

	@Autowired
	private ServicoServico servicoServico;

	@Override
	@PostMapping("/savar")
	public ModelAndView salvar(@Valid ServicoDto object, BindingResult result, Model model,
			RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView("redirect:/servicos");
		if (result.hasErrors()) {
			return novo(object);
		}
		attributes.addAttribute("mensagem", "Servico salvo com sucesso");
		this.servicoServico.salvar(object);
		return mv;
	}

	@Override
	@GetMapping("/novo")
	public ModelAndView novo(ServicoDto novo) {
		ModelAndView mv = new ModelAndView("/pages/servicos/novo");
		mv.addObject("servico", novo);
		return mv;
	}

	@Override
	@GetMapping("/atualisar/{id}")
	public ModelAndView atualisar(@PathVariable("id") Long id) {
		ServicoDto servicoDto = this.servicoServico.buscar(id);
		return novo(servicoDto);
	}

	@Override
	@DeleteMapping("/remover/{id}")
	public ModelAndView remover(@PathVariable Long id, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView("redirect:/servicos");
		this.servicoServico.remover(id);
		attributes.addFlashAttribute("removido", "Servico removido com sucesso!");
		return mv;
	}

	@Override
	@GetMapping
	public ModelAndView listar(@ModelAttribute("filtro") ServicoDto filtro) {
		ModelAndView mv = new ModelAndView("/servicos/listar");
		if (!StringUtils.isEmpty(filtro)) {
			List<ServicoDto> servicos = this.servicoServico.listar(filtro);
			mv.addObject("servicos", servicos);
		} else {
			mv.addObject("servicos", servicoServico.listar());
		}
		return mv;
	}

}
