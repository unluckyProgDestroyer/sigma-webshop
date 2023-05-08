package hu.sigmalimited.sigmawebshop.feature.file;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileSystemStorageService implements StorageService {

	@Autowired
	private SigmaWebshopFileStorageProperties sigmaWebshopFileStorageProperties;
	FileSystemStorageService(){
	}
	private Path rootLocation = Paths.get(System.getProperty("java.io.tmpdir"));

	@Override
	public void save(MultipartFile file) {
		try {
			if (file.isEmpty()) {
				throw new FileSystemStorageException("Failed to store empty file.");
			}
			Path destinationFile = this.rootLocation.resolve(
					Paths.get(file.getOriginalFilename()))
					.normalize().toAbsolutePath();
			if (!destinationFile.getParent().equals(this.rootLocation.toAbsolutePath())) {
				throw new FileSystemStorageException(
						"Cannot store file outside current directory.");
			}
			try (InputStream inputStream = file.getInputStream()) {
				Files.copy(inputStream, destinationFile,
					StandardCopyOption.REPLACE_EXISTING);
			}
		}
		catch (IOException e) {
			throw new FileSystemStorageException("Failed to store file.", e);
		}
	}

	@Override
	public Stream<Path> loadAll() {
		try {
			return Files.walk(this.rootLocation, 1)
				.filter(path -> !path.equals(this.rootLocation))
				.map(this.rootLocation::relativize);
		}
		catch (IOException e) {
			throw new FileSystemStorageException("Failed to read stored files", e);
		}

	}

	@Override
	public Path load(String filename) {
		return rootLocation.resolve(filename);
	}

	@Override
	public Resource loadAsResource(String filename) {
		try {
			Path file = load(filename);
			Resource resource = new UrlResource(file.toUri());
			if (resource.exists() || resource.isReadable()) {
				return resource;
			}
			else {
				throw new FileSystemStorageFileNotFoundException(
						"Could not read file: " + filename);

			}
		}
		catch (MalformedURLException e) {
			throw new FileSystemStorageFileNotFoundException("Could not read file: " + filename, e);
		}
	}

	@Override
	public void deleteAll() {
		FileSystemUtils.deleteRecursively(rootLocation.toFile());
	}

	@Override
	public void init() {
		try {
			if (sigmaWebshopFileStorageProperties!=null && !sigmaWebshopFileStorageProperties.getPath().equals("")){
				rootLocation = Paths.get(sigmaWebshopFileStorageProperties.getPath());
			}
			System.out.println(sigmaWebshopFileStorageProperties.getPath());
			System.out.println(Paths.get(sigmaWebshopFileStorageProperties.getPath()));
			Files.createDirectories(rootLocation);
		}
		catch (IOException e) {
			throw new FileSystemStorageException("Could not initialize storage", e);
		}
	}
}