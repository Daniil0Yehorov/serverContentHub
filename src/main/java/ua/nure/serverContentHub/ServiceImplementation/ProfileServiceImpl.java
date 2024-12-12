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

        for (String tagName : tagNames) {
            tags tag = tagsrepo.findByName(tagName);

            profile_has_tags profileHasTag = new profile_has_tags();
            profileHasTag.setProfile(profile);
            profileHasTag.setTags(tag);
            PHSservicerepo.save(profileHasTag);
        }
    }

    @Override
    public profile update(profile updatedProfile) {
        //валідацію додати
        profile existingProfile = profileRepositoryS.findById(updatedProfile.getId());

        existingProfile.setDescription(updatedProfile.getDescription());
        existingProfile.setAvatarURL(updatedProfile.getAvatarURL());
        existingProfile.setTiktok(updatedProfile.getTiktok());
        existingProfile.setInstagram(updatedProfile.getInstagram());
        existingProfile.setTwitch(updatedProfile.getTwitch());
        existingProfile.setYoutube(updatedProfile.getYoutube());
        existingProfile.setSubscribersCount(updatedProfile.getSubscribersCount());
        existingProfile.setRating(updatedProfile.getRating());

        return profileRepositoryS.save(existingProfile);
    }

    @Override
    public void reportProfile(int profileid,int whoComplainedId,String reason) {
        //перевірки можливі додати
    profile reportedProfile=profileRepositoryS.findById(profileid);
    complaint newComplaint = new complaint();
    newComplaint.setProfile(reportedProfile);
    newComplaint.setUser(userRepo.findById(whoComplainedId));
    newComplaint.setReason(reason);
    newComplaint.setStatus(ComplaintStatus.pending);
    complaintRepo.save(newComplaint);
    }

    @Override
    public void subscribeCreator(profile profileToSubscribe,user subscriber) {
        //перевірки додати
        user userfindforprofile= userRepo.findById(profileToSubscribe.getUser().getId());
        user sub= userRepo.findById(subscriber.getId());

        subscription newSubscription = new subscription();
        newSubscription.setUser(sub);
        newSubscription.setCreator(userfindforprofile);
        LocalDateTime currentDate = LocalDateTime.now();
        newSubscription.setSubscriptionDate(currentDate);

        subcriptionRep.save(newSubscription);
    }

    @Override
    public void unsubscribeCreator(profile profileToUnsubscribe, user unsubscriber) {
        //перевірки додати

        user userfindforprofile = userRepo.findById(profileToUnsubscribe.getUser().getId());

        user sub = userRepo.findById(unsubscriber.getId());

        subscription existingSubscription = subcriptionRep.findByCreator_IdAndUser_Id(userfindforprofile.getId(), sub.getId());

        subcriptionRep.delete(existingSubscription);;
    }

    @Override
    public profile getProfileByID(int id) {
        return profileRepositoryS.findById(id);
    }

}
