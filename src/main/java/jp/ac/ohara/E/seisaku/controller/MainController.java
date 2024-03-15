package jp.ac.ohara.E.seisaku.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import io.micrometer.common.lang.NonNull;
import jp.ac.ohara.E.seisaku.model.GakuseiHyou;
import jp.ac.ohara.E.seisaku.model.SeisekiHyou;
import jp.ac.ohara.E.seisaku.model.SyusekiHyou;
import jp.ac.ohara.E.seisaku.service.GakuseiService;
import jp.ac.ohara.E.seisaku.service.SeisekiService;
import jp.ac.ohara.E.seisaku.service.SyusekiService;
@Controller
public class MainController {
	@Autowired
	private GakuseiService gakuseiService;
	
	@Autowired
	private SeisekiService seisekiService;
	
	@Autowired
	private SyusekiService syusekiService;
	
  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute("message", "こんにちは");
    return "top";
  }
  
  // 学生・成績・出席登録ページ
  @GetMapping("/setstu/")
  public ModelAndView add(GakuseiHyou gakuseihyou, ModelAndView model) {
	  model.addObject("gakuseihyou", gakuseihyou);
	  model.setViewName("setstu");
	  return model;
  }
  
  @GetMapping("/setrecords/")
  public ModelAndView add(SeisekiHyou seisekihyou, ModelAndView model) {
	  model.addObject("seisekihyou", seisekihyou);
	  model.setViewName("setrecords");
	  return model;
  }
  
  @GetMapping("/setsyuseki/")
  public ModelAndView add(SyusekiHyou syusekihyou, ModelAndView model) {
	  model.addObject("syusekihyou", syusekihyou);
	  model.setViewName("setsyuseki");
	  return model;
  }
  
  @GetMapping("/login/")
  public ModelAndView add2(GakuseiHyou gakuseihyou, ModelAndView model) {
	  model.addObject("gakuseihyou", gakuseihyou);
	  model.setViewName("login");
	  return model;
  }
 
//学生・成績・出席リスト表示・出席詳細表示
  //
  @GetMapping("/studentlist/")
  public String add(Model model) {
    System.out.println(gakuseiService.getGakuseiList().toString());
      model.addAttribute("gakuseiList", gakuseiService.getGakuseiList());
      return "studentlist";
  }
  
  @GetMapping("/recordslist/")
  public ModelAndView add1(SeisekiHyou seisekihyou, ModelAndView model) {
	  model.addObject("seisekihyou", seisekihyou);
	  model.setViewName("recordslist");
	  return model;
  }
  
  @GetMapping("/syusekilist/")
  public ModelAndView add1(SyusekiHyou syusekihyou, ModelAndView model) {
	  model.addObject("syusekihyou", syusekihyou);
	  model.setViewName("syusekilist");
	  return model;
  }
  
  @GetMapping("/syusekidetail/")
  public ModelAndView add2(SyusekiHyou syusekihyou, ModelAndView model) {
	  model.addObject("syusekihyou", syusekihyou);
	  model.setViewName("syusekidetail");
	  return model;
  }
  
  //Form送信
  @PostMapping("/setstu/")
  public String gakuseihyou(@Validated @ModelAttribute @NonNull GakuseiHyou gakuseihyou, RedirectAttributes result, ModelAndView model,
          RedirectAttributes redirectAttributes) {
      try {
          this.gakuseiService.save(gakuseihyou);
          redirectAttributes.addFlashAttribute("exception", "");

      } catch (Exception e) {
          redirectAttributes.addFlashAttribute("exception", e.getMessage());
      }
      return "redirect:/";

    }
  
  @PostMapping("/setrecords/")
  public String seisekihyou(@Validated @ModelAttribute @NonNull SeisekiHyou seisekihyou, RedirectAttributes result, ModelAndView model,
          RedirectAttributes redirectAttributes) {
      try {
          this.seisekiService.save(seisekihyou);
          redirectAttributes.addFlashAttribute("exception", "");

      } catch (Exception e) {
          redirectAttributes.addFlashAttribute("exception", e.getMessage());
      }
      return "redirect:/";

    }
  
  @PostMapping("/setsyuseki/")
  public String syusekihyou(@Validated @ModelAttribute @NonNull SyusekiHyou syusekihyou, RedirectAttributes result, ModelAndView model,
          RedirectAttributes redirectAttributes) {
      try {
          this.syusekiService.save(syusekihyou);
          redirectAttributes.addFlashAttribute("exception", "");

      } catch (Exception e) {
          redirectAttributes.addFlashAttribute("exception", e.getMessage());
      }
      return "redirect:/";

  }



}