package com.example.demo.services;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.exceptions.FilesException;

@Service
@PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_INSTRUCTOR')")
public class UploadFilesService {

	public String uploadFile(MultipartFile file) throws Exception {
		try {
			String fileName = UUID.randomUUID().toString();
			byte[] bytes = file.getBytes();
			String fileOriginalName = file.getOriginalFilename();

			long fileSize = file.getSize();
			long maxFileSize = 10 * 1024 * 1024;

			if (fileSize > maxFileSize) {
				throw new FilesException("El tamaño del archivo es de mas de 10 MB");
			}

			if (fileOriginalName.endsWith(".jpg") || fileOriginalName.endsWith(".png") || fileOriginalName.endsWith(".jpeg")
					|| fileOriginalName.endsWith(".bmp") || fileOriginalName.endsWith(".gif")
					|| fileOriginalName.endsWith(".tiff") || fileOriginalName.endsWith(".tif")
					|| fileOriginalName.endsWith(".webp") || fileOriginalName.endsWith(".ico")
					|| fileOriginalName.endsWith(".svg") || fileOriginalName.endsWith(".mp4")
					|| fileOriginalName.endsWith(".avi") || fileOriginalName.endsWith(".mov")
					|| fileOriginalName.endsWith(".mkv") || fileOriginalName.endsWith(".flv")
					|| fileOriginalName.endsWith(".wmv") || fileOriginalName.endsWith(".xls")
					|| fileOriginalName.endsWith(".xlsx") || fileOriginalName.endsWith(".csv")
					|| fileOriginalName.endsWith(".ods") || fileOriginalName.endsWith(".tsv")||fileOriginalName.endsWith(".zip")) {
					String fileExtension = fileOriginalName.substring(fileOriginalName.lastIndexOf("."));
					String newFile = fileName+fileExtension;
					File folder =  new File("src/main/resources/uploadFiles");
					
					if(!folder.exists()) {
						folder.mkdirs();
					}
					
					Path path = Paths.get("src/main/resources/uploadFiles/"+newFile);
					Files.write(path, bytes);
					return path.toString();
			}else {
				throw new FilesException("Ese Tipo de archivo no esta permitido, y este es el nombre:" + fileOriginalName+" y pesa: " +fileSize);
			}
		} catch (Exception e) {
			throw new FilesException(e.getMessage());
		}
	}

}
