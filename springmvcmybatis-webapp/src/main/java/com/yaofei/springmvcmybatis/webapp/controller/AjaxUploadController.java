package com.yaofei.springmvcmybatis.webapp.controller;

import org.springframework.stereotype.Controller;

/**
 * ajax文件上传/下载
 */
@Controller
public class AjaxUploadController {

    //protected final Logger logger = LoggerFactory.getLogger(getClass());
    //
    ////最大上传大小 字节为单位
    //private long maxSize = FileUploadUtils.DEFAULT_MAX_SIZE;
    ////允许的文件内容类型
    //private String[] allowedExtension = FileUploadUtils.DEFAULT_ALLOWED_EXTENSION;
    ////文件上传下载的父目录
    //private String baseDir = FileUploadUtils.getDefaultBaseDir();
    //
    //@Autowired
    //private MessageSource messageSource;
    //
    ///**
    // * @param request
    // * @param files
    // * @return
    // */
    //@RequestMapping(value = "/ajaxUpload", method = RequestMethod.POST)
    //@ResponseBody
    //public AjaxUploadResponse ajaxUpload(
    //        HttpServletRequest request, HttpServletResponse response,
    //        @RequestParam(value = "files[]", required = false) MultipartFile[] files) {
    //
    //    //The file upload plugins makes use of an Iframe Transport module for browsers like Microsoft Internet Explorer and Opera, which do not yet support XMLHTTPRequest file uploads.
    //    response.setContentType("text/plain");
    //
    //    AjaxUploadResponse ajaxUploadResponse = new AjaxUploadResponse();
    //
    //    if (ArrayUtils.isEmpty(files)) {
    //        return ajaxUploadResponse;
    //    }
    //
    //    for (MultipartFile file : files) {
    //        String filename = file.getOriginalFilename();
    //        long size = file.getSize();
    //
    //        try {
    //            String url = FileUploadUtils.upload(request, baseDir, file, allowedExtension, maxSize, true);
    //            String deleteURL = "/ajaxUpload/delete?filename=" + URLEncoder.encode(url, Charsets.UTF8_NAME);
    //            if (this.isImage(filename)) {
    //                ajaxUploadResponse.add(filename, size, url, url, deleteURL);
    //            } else {
    //                ajaxUploadResponse.add(filename, size, url, deleteURL);
    //            }
    //            continue;
    //        } catch (IOException e) {
    //            logger.error("file upload error", e);
    //            ajaxUploadResponse.add(filename, size, messageSource.getMessage("upload.server.error",null,null));
    //            continue;
    //        } catch (InvalidExtensionException e) {
    //            ajaxUploadResponse.add(filename, size, messageSource.getMessage("upload.not.allow.extension",null,null));
    //            continue;
    //        } catch (FileUploadBase.FileSizeLimitExceededException e) {
    //            ajaxUploadResponse.add(filename, size, messageSource.getMessage("upload.exceed.maxSize", null, null));
    //            continue;
    //        } catch (FileNameLengthLimitExceededException e) {
    //            ajaxUploadResponse.add(filename, size, messageSource.getMessage("upload.filename.exceed.length", null, null));
    //            continue;
    //        }
    //    }
    //    return ajaxUploadResponse;
    //}
    //
    //
    //@RequestMapping(value = "/ajaxUpload/delete", method = RequestMethod.POST)
    //@ResponseBody
    //public String ajaxUploadDelete(
    //        HttpServletRequest request,
    //        @RequestParam(value = "filename") String filename) throws Exception {
    //
    //    if (StringUtils.isEmpty(filename) || filename.contains("\\.\\.")) {
    //        return "";
    //    }
    //    filename = URLDecoder.decode(filename, Charsets.UTF8_NAME);
    //
    //    String filePath = FileUploadUtils.extractUploadDir(request) + "/" + filename;
    //
    //    File file = new File(filePath);
    //    file.deleteOnExit();
    //
    //    return "";
    //}
    //
    //private static final String[] IMAGES_SUFFIXES = {
    //        "bmp", "jpg", "jpeg", "gif", "png", "tiff"
    //};
    //
    ///**
    // * 是否是图片附件
    // *
    // * @param filename
    // * @return
    // */
    //public static boolean isImage(String filename) {
    //    if (filename == null || filename.trim().length() == 0) return false;
    //    return ArrayUtils.contains(IMAGES_SUFFIXES, FilenameUtils.getExtension(filename).toLowerCase());
    //}
}
