package com.vsc.facebook.fbcopy.service.implementation;

import com.dropbox.core.DbxException;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.sharing.SharedLinkMetadata;
import com.vsc.facebook.fbcopy.dto.ImageUploadDTO;
import com.vsc.facebook.fbcopy.entity.Profile;
import com.vsc.facebook.fbcopy.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
public class ImageUploadService {

    private static final String ACCESS_TOKEN = "ckQic8_y_2AAAAAAAAAAFOACZL4iUrYYmEObYmnR2SP1qncWSRZi5lMAEtLqc56v" ;
    private DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/Facebook1914").build();
    private DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);
    private final ProfileRepository profileRepository;

    @Autowired
    public ImageUploadService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;

    }

    public void uploadImage(MultipartFile image) throws IOException {
        Path filepath = Paths.get("", image.getOriginalFilename());
        image.transferTo(filepath);
    }

    public String uploadToDropbox(ImageUploadDTO imageUploadDTO) throws DbxException, IOException {

        InputStream in = imageUploadDTO.getImage().getInputStream();
        String image = "/" + getCurrentLoggedUsername() + "/" + UUID.randomUUID().toString().concat(".jpg");
        client.files().uploadBuilder(image).uploadAndFinish(in);

        return getDirectLink(image);
    }

    public String getCurrentLoggedUsername() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "";

        if (principal instanceof UserDetails) {

            username = ((UserDetails) principal).getUsername();

        } else {

            username = principal.toString();

        }

        return username;
    }

    public String getDirectLink(String image) {
        String url = "";

        try {
            SharedLinkMetadata sharedLinkMetadata = client.sharing().createSharedLinkWithSettings(image);
            url = sharedLinkMetadata.getUrl();
        } catch (DbxException ex) {
            System.out.println(ex);
        }

        String directUrl = url.replace("www", "dl").replace("dropbox", "dropboxusercontent");
        return directUrl;
    }


}
