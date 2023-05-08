package hu.sigmalimited.sigmawebshop.feature.file;

public class FileSystemStorageException extends RuntimeException {

	public FileSystemStorageException(String message) {
		super(message);
	}

	public FileSystemStorageException(String message, Throwable cause) {
		super(message, cause);
	}
}