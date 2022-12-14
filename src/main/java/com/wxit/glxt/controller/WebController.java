package com.wxit.glxt.controller;

import com.wxit.glxt.service.ContactService;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

@Controller
public class WebController {

    @Resource
    private ContactService contactServiceImpl;


    @GetMapping("/toupload")
    public String toupload() {
        return "upload";
    }

    @PostMapping("/uploadFile")
    public String uploadFile(MultipartFile[] fileUpload, Model m) {
        m.addAttribute("uploadStatus", "上传成功");
        for (MultipartFile file : fileUpload) {
            String fileName = file.getOriginalFilename();
            fileName = UUID.randomUUID() + "_" + fileName;
            String dirPath = "D:/file/";
            File filePath = new File(dirPath);
            if (!filePath.exists()) {
                filePath.mkdirs();
            }

            try {
                file.transferTo(new File(dirPath + fileName));
            } catch (IOException e) {
                e.printStackTrace();
                m.addAttribute("", "上传失败" + e.getMessage());
            }
        }

        return "upload";
    }

    @GetMapping("/todownload")
    public String todownload() {
        return "download";
    }

    @GetMapping("/download")
    public ResponseEntity<byte[]> fileDownload(HttpServletRequest request, String filename) throws Exception {
        // 指定要下载的文件根路径
        String dirPath = "D:/file/download/";
        // 创建该文件对象
        File file = new File(dirPath + File.separator + filename);
        // 设置响应头
        HttpHeaders headers = new HttpHeaders();
        // 通知浏览器以下载方式打开(下载前对文件名进行转码)
        filename = getFilename(request, filename);
        headers.setContentDispositionFormData("attachment", filename);

        // 定义以下流的形式下载返回文件数据
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        try {
            return new ResponseEntity<>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<byte[]>(e.getMessage().getBytes(), HttpStatus.EXPECTATION_FAILED);
        }


    }

    // 根据浏览器不同进行编码设置, 返回编码后的文件名
    private String getFilename(HttpServletRequest request, String filename) throws Exception {
        // IE不同版本User-Agent中出现的关键词
        String[] IEBrowserKeyWords = {"MSIE", "Trident", "Edge"};
        // 获取请求头代理信息
        String userAgent = request.getHeader("User-Agent");
        for (String keyWord : IEBrowserKeyWords) {
            if (userAgent.contains(keyWord)) {
                // IE内核浏览器，统一为UTF-8编码显示，并对转换的+进行更正
                return URLEncoder.encode(filename, "UTF-8").replace("+", " ");
            }
        }
        // 火狐等其他浏览器统一为ISO-8859-1编码显示
        return new String(filename.getBytes("UTF-8"), "ISO-8859-1");
    }

    @GetMapping("/all_page")
    public String all_page(Model m) {
        List UserList = contactServiceImpl.contTable();
        m.addAttribute("Result", UserList);
        return "mypage";
    }

    @GetMapping("/tochart")
    public String tochart() {
        return "contchart";
    }

    @RequestMapping("/gochart")
    @ResponseBody
    public List gochart(Model m) {
        List UserList = contactServiceImpl.contChart();
        m.addAttribute("Result", UserList);
        System.out.println(UserList);
        return UserList;
    }

    // 饼图
    @GetMapping("/topie")
    public String topie() {
        return "pie";
    }

    @RequestMapping("/gopie")
    @ResponseBody
    public List gopie(Model m) {
        List UserList = contactServiceImpl.contDuty();
        m.addAttribute("Result", UserList);
        System.out.println(UserList);
        return UserList;
    }

}
