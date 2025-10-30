package com.bkap.qlks.controller;

import com.bkap.qlks.service.NewsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import com.bkap.qlks.entity.Account;
import com.bkap.qlks.entity.News;
import com.bkap.qlks.repository.NewsRepository;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

@Controller
public class ContactController {
	@Autowired
	private NewsService newsService;
@Autowired 
private NewsRepository newsRepository;
	@GetMapping("/contact")
	public String lh() {
		return "lienhe";
	}

	@GetMapping("/blog")
	public String tt(Model model) {
		model.addAttribute("ne", newsService.findAll());
		return "tintuc";
	}

	@GetMapping("/createblogger")
	public String createblo(Model model) {
		News news = new News();
		model.addAttribute("news", news);
		return "addnews";
	}

	@PostMapping("/createblog")
	public String storeblog(@ModelAttribute("news") News news, @RequestParam("imageFile") MultipartFile imageFile) {

		// Kiểm tra đăng nhập
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String account = auth.getName();

		if (account == null || account.equals("anonymousUser")) {
			return "redirect:/login"; // nếu chưa đăng nhập
		}

		try {
			// Thư mục lưu ảnh
			String uploadDir = "src/main/resources/static/images/";
			String fileName = System.currentTimeMillis() + "_" + imageFile.getOriginalFilename();

			Path path = Paths.get(uploadDir + fileName);
			Files.createDirectories(path.getParent()); // nếu thư mục chưa tồn tại
			Files.copy(imageFile.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

	
			// Gán đường dẫn vào đối tượng News
			news.setImage(uploadDir + fileName);

		} catch (IOException e) {
			e.printStackTrace();
		}

		// Gắn người đăng vào bài viết
		Account acc = new Account();
		acc.setAccountId(account); // username chính là accountId
		news.setAccount(acc);
		news.setCreatedat(Date.valueOf(LocalDate.now()));

		// Lưu bài viết
		newsService.create(news);

		return "redirect:/blog";
	}
}
