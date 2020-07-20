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

import br.com.iesp.full.stack.dto.PrestadorDto;
import br.com.iesp.full.stack.servico.PrestadorServico;

@Controller
@RequestMapping("/vendedor")
public class VendedorControle implements IControler<PrestadorDto, Serializable>{
	
	@Autowired
	private PrestadorServico vendedorServico;

	@Override
	@PostMapping("/savar")
	public ModelAndView salvar(@Valid PrestadorDto object, BindingResult result, Model model,
			RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView("redirect:/vendedores");
		if (result.hasErrors()) {
			return novo(object);
		}
		attributes.addAttribute("mensagem", "Vendedor salvo com sucesso");
		this.vendedorServico.salvar(object);
		return mv;
	}

	@Override
	@GetMapping("/novo")
	public ModelAndView novo(PrestadorDto novo) {
		ModelAndView mv = new ModelAndView("/pages/vendedores/novo");
		mv.addObject("vendedore", novo);
		return mv;
	}

	@Override
	@GetMapping("/atualisar/{id}")
	public ModelAndView atualisar(@PathVariable("id") Long id) {
		PrestadorDto vendedorDto = this.vendedorServico.buscar(id);
		return novo(vendedorDto);
	}

	@Override
	@DeleteMapping("/remover/{id}")
	public ModelAndView remover(@PathVariable Long id, RedirectAttributes attributes) {
		ModelAndView mv = new ModelAndView("redirect:/vendedores");
		this.vendedorServico.remover(id);
		attributes.addFlashAttribute("removido", "Vendedor removido com sucesso!");
		return mv;
	}

	@Override
	@GetMapping
	public ModelAndView listar(@ModelAttribute("filtro") PrestadorDto filtro) {
		ModelAndView mv = new ModelAndView("/vendedores/listar");
		if (!StringUtils.isEmpty(filtro)) {
			List<PrestadorDto> servicos = this.vendedorServico.listar(filtro);
			mv.addObject("vendedores", servicos);
		} else {
			mv.addObject("vendedores", vendedorServico.listar());
		}
		return mv;
	}

}
