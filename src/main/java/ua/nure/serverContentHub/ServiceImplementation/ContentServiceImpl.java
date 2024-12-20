package ua.nure.serverContentHub.ServiceImplementation;

import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.nure.serverContentHub.Entity.Profile;
import ua.nure.serverContentHub.Entity.Tags;
import ua.nure.serverContentHub.Repository.ProfileRepository;
import ua.nure.serverContentHub.Repository.TagsRepository;
import ua.nure.serverContentHub.ServiceInterface.ContentService;

import java.util.List;
import java.util.stream.Collectors;

@WebService(endpointInterface = "ua.nure.serverContentHub.ServiceInterface.ContentService")
@Service
public class ContentServiceImpl implements ContentService {
    @Autowired
    private  ProfileRepository profileRepository;
    @Autowired
    private TagsRepository tagsRepository;

    public List<Profile> searchCreatorsByTags(List<String> tagNames) {
        List<Tags> tags = tagsRepository.findByNameIn(tagNames);

        if (tags.isEmpty()) {
            return List.of();
        }
        return profileRepository.findAllByTags(tags)
                .stream()
                .distinct()
                .collect(Collectors.toList());
    }

    public Profile viewContent(int profileId) {
        return profileRepository.findById(profileId);
    }

    public List<Profile> getAllCreators() {
        return profileRepository.findAll();
    }


}
