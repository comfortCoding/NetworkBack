package javapro.controller;

import javapro.api.response.FileStorageResponse;
import javapro.api.response.Response;
import javapro.config.exception.AuthenticationException;
import javapro.config.exception.BadRequestException;
import javapro.services.StorageService;
import javassist.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class StorageController {

    private final StorageService storageService;

    public StorageController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping(value = "/api/v1/storage")
    public ResponseEntity<Response<FileStorageResponse>> storage(MultipartFile file) throws BadRequestException, NotFoundException, AuthenticationException {
        return storageService.fileStore(file);
    }
}
