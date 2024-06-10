package com.DAS.Tools;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

public class UpFileCloud {
	static Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap("cloud_name", "dqzsk2uls", "api_key", "451374263271413",
			"api_secret", "TCNze888wLpobby6lx9sYETJ5hw", "secure", true));

	// Up file ảnh lên cloud binary và trả về đường dẫn truy cập ảnh
	public static String upCloudBinaryByFile(File file) {
		String pathReturnCloud = null;
		try {
			Map uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
			pathReturnCloud = (uploadResult.get("secure_url").toString());
			System.out.println(uploadResult);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pathReturnCloud;
	}
	
	//remove ảnh từ cloudinary
	public static void removeCloudBinaryByUrl(String url) {
		String publicID = extractPublicId(url);
		System.out.println(publicID);
		try {
			Map result = cloudinary.uploader().destroy(publicID,
					  ObjectUtils.asMap("resource_type","image"));
			System.out.println(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/// lấy public_id từ url ảnh để remove ảnh
	  private static String extractPublicId(String imageUrl) {
	    try {
	      URI uri = new URI(imageUrl);
	      String path = uri.getPath();
	      String[] segments = path.split("/");
	      String publicIdWithExtension = segments[segments.length - 1];
	      int extensionIndex = publicIdWithExtension.lastIndexOf('.');
	      return publicIdWithExtension.substring(0, extensionIndex);
	    } catch (URISyntaxException e) {
	      e.printStackTrace();
	      return null;
	    }
	  }
	  
	  
	  public static String getFilePath(MultipartFile file) {
	        try {
	            String originalFilename = file.getOriginalFilename();
	            String currentDir = Paths.get("").toAbsolutePath().toString();
	            String filePath = currentDir + "/" + originalFilename;
	            return filePath;
	        } catch (Exception e) {
	            // Xử lý lỗi
	            return null;
	        }
	    }

}
