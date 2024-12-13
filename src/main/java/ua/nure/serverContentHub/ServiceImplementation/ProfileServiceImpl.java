package ua.nure.serverContentHub.ServiceImplementation;

import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.nure.serverContentHub.Entity.*;
import ua.nure.serverContentHub.Entity.Enum.ComplaintStatus;
import ua.nure.serverContentHub.Repository.complaintRepository;
import ua.nure.serverContentHub.Repository.profile_has_tagsRepository;
import ua.nure.serverContentHub.ServiceInterface.ProfileService;
import ua.nure.serverContentHub.Repository.profileRepository;
import ua.nure.serverContentHub.Repository.tagsRepository;
import ua.nure.serverContentHub.Repository.UserRepository;
import ua.nure.serverContentHub.Repository.subscriptionRepository;

import java.time.LocalDateTime;

@WebService(endpointInterface = "ua.nure.serverContentHub.ServiceInterface.ProfileService")
@Service
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    private profileRepository profileRepositoryS;
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private profile_has_tagsRepository PHSservicerepo;
    @Autowired
    private tagsRepository tagsrepo;
    @Autowired
    private complaintRepository complaintRepo;
    @Autowired
    private subscriptionRepository subcriptionRep;

    @Override
    public void placeTagsForProfile(int profileId, String[] tagNames) {
        profile profile = profileRepositoryS.findById(profileId);
        if (profile == null) {
            throw new IllegalArgumentException("Профіль не знайден");
        }

        for (String tagName : tagNames) {
            tags tag = tagsrepo.findByName(tagName);
            if (tag == null) {
                throw new IllegalArgumentException("Тег не знайден: " + tagName);
            }

            profile_has_tags profileHasTag = new profile_has_tags();
            profileHasTag.setProfile(profile);
            profileHasTag.setTags(tag);
            PHSservicerepo.save(profileHasTag);
        }
    }

    @Override
    public profile update(profile updatedProfile) {
        profile existingProfile = profileRepositoryS.findById(updatedProfile.getId());
        if (existingProfile == null) {
            throw new IllegalArgumentException("Profile not found");
        }

        validateProfile(updatedProfile);

        existingProfile.setDescription(updatedProfile.getDescription());
        existingProfile.setAvatarURL(updatedProfile.getAvatarURL());
        existingProfile.setTiktok(updatedProfile.getTiktok());
        existingProfile.setInstagram(updatedProfile.getInstagram());
        existingProfile.setTwitch(updatedProfile.getTwitch());
        existingProfile.setYoutube(updatedProfile.getYoutube());
        //рейтинг буде додаватись при 5-10 ревью на креатора, а  поки його не буде
        //кількість підписників збільшується за допомогою трігера у бд
        return profileRepositoryS.save(existingProfile);
    }

    @Override
    public void reportProfile(int profileid,int whoComplainedId,String reason) {
        //перевірки можливі додати
        profile reportedProfile = profileRepositoryS.findById(profileid);
        if (reportedProfile == null) {
            throw new IllegalArgumentException("Профіль не знайден");
        }

        user complainingUser = userRepo.findById(whoComplainedId);
        if (complainingUser == null) {
            throw new IllegalArgumentException("Користувач не знайден");
        }

        if (reason == null || reason.trim().isEmpty()) {
            throw new IllegalArgumentException("Причина не може бути порожньою");
        }

        complaint newComplaint = new complaint();
        newComplaint.setProfile(reportedProfile);
        newComplaint.setUser(complainingUser);
        newComplaint.setReason(reason);
        newComplaint.setStatus(ComplaintStatus.pending);
        complaintRepo.save(newComplaint);
    }

    @Override
    public void subscribeCreator(profile profileToSubscribe,user subscriber) {
         if (profileToSubscribe == null || subscriber == null) {
            throw new IllegalArgumentException("Креатор або підписник не можуть бути порожніми");
        }

        user creator = userRepo.findById(profileToSubscribe.getUser().getId());
        if (creator == null) {
            throw new IllegalArgumentException("Креатор не знайден");
        }

        user subscribingUser = userRepo.findById(subscriber.getId());
        if (subscribingUser == null) {
            throw new IllegalArgumentException("Підписник не знайден");
        }

        if (subcriptionRep.findByCreator_IdAndUser_Id(creator.getId(), subscribingUser.getId()) != null) {
            throw new IllegalArgumentException("Вже підписан на креатора");
        }

        subscription newSubscription = new subscription();
        newSubscription.setUser(subscribingUser);
        newSubscription.setCreator(creator);
        newSubscription.setSubscriptionDate(LocalDateTime.now());

        subcriptionRep.save(newSubscription);

    }

    @Override
    public void unsubscribeCreator(profile profileToUnsubscribe, user unsubscriber) {
        if (profileToUnsubscribe == null || unsubscriber == null) {
            throw new IllegalArgumentException("Профіль або відписника не можуть бути нульовими");
        }

        user creator = userRepo.findById(profileToUnsubscribe.getUser().getId());
        if (creator == null) {
            throw new IllegalArgumentException("Креатор не знайден");
        }

        user unsubscribingUser = userRepo.findById(unsubscriber.getId());
        if (unsubscribingUser == null) {
            throw new IllegalArgumentException("відписник не знайден");
        }

        subscription existingSubscription = subcriptionRep.findByCreator_IdAndUser_Id(creator.getId(), unsubscribingUser.getId());
        if (existingSubscription == null) {
            throw new IllegalArgumentException("Немає підписки задля відписки");
        }

        subcriptionRep.delete(existingSubscription);
    }

    @Override
    public profile getProfileByID(int id) {
        profile profile = profileRepositoryS.findById(id);
        if (profile == null) {
            throw new IllegalArgumentException("Креатор не знайден");
        }
        return profile;

    }
    private void validateProfile(profile updatedProfile) {
        if (updatedProfile.getDescription() == null || updatedProfile.getDescription().trim().isEmpty()) {
            throw new IllegalArgumentException("Опис не може бути порожнім");
        }

        if (!isValidUrl(updatedProfile.getAvatarURL())) {
            throw new IllegalArgumentException("Avatar URL не валідний");
        }
        if (!isValidUrl(updatedProfile.getTiktok())) {
            throw new IllegalArgumentException("не валідний TikTok URL");
        }

        if (!isValidUrl(updatedProfile.getInstagram())) {
            throw new IllegalArgumentException("не валідний Instagram URL");
        }

        if (!isValidUrl(updatedProfile.getTwitch())) {
            throw new IllegalArgumentException("не валідний Twitch URL");
        }

        if (!isValidUrl(updatedProfile.getYoutube())) {
            throw new IllegalArgumentException("не валідний YouTube URL");
        }
    }

    private boolean isValidUrl(String url) {
        if (url == null || url.trim().isEmpty()) {
            return true;
        }
        return url.matches("^(http|https)://.*$");
    }

}
