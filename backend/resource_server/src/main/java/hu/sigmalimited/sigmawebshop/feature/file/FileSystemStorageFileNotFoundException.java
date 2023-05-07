package hu.sigmalimited.sigmawebshop.feature.file;

public class FileSystemStorageFileNotFoundException extends FileSystemStorageException {

	public FileSystemStorageFileNotFoundException(String message) {
		super(message);
	}

	public FileSystemStorageFileNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}