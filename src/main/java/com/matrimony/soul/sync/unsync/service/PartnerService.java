package com.matrimony.soul.sync.unsync.service;

import com.matrimony.soul.sync.unsync.domain.Gender;
import com.matrimony.soul.sync.unsync.domain.Partner;
import com.matrimony.soul.sync.unsync.domain.SoulStatus;
import com.matrimony.soul.sync.unsync.domain.User;
import com.matrimony.soul.sync.unsync.repository.PartnerRepository;
import com.matrimony.soul.sync.unsync.repository.RequestRepository;
import com.matrimony.soul.sync.unsync.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class PartnerService {
    PartnerRepository partnerRepository;
    UserRepository userRepository;

    public PartnerService(PartnerRepository partnerRepository, UserRepository userRepository) {
        this.partnerRepository = partnerRepository;
        this.userRepository = userRepository;
    }

    public boolean addPartner(Partner partner){
        User myself = userRepository.get(partner.getUser1_id());
        User myPartner = userRepository.get(partner.getUser2_id());
        int myPartnersCount = partnerRepository.count(partner.getUser1_id());
        if(myself.getGender() == Gender.MALE){
            if(myPartnersCount<4){
                partnerRepository.addPartner(partner);
                myself.setSoulStatus(SoulStatus.SYNCED);
                if(partnerRepository.count(myself.getId()) == 4)
                    myself.setVisibility(false);
                myPartner.setSoulStatus(SoulStatus.SYNCED);
                if(partnerRepository.count(myPartner.getId()) == 1)
                    myPartner.setVisibility(false);
                userRepository.update(myself, myself.getId());
                userRepository.update(myPartner, myPartner.getId());
                return true;
            }
            else {
                System.out.println("You can't make more than 4 partners");
                return false;
            }
        }
        else if(myself.getGender() == Gender.FEMALE){
            if(myPartnersCount<1){
                partnerRepository.addPartner(partner);
                myself.setSoulStatus(SoulStatus.SYNCED);
                if(partnerRepository.count(myself.getId()) == 1)
                    myself.setVisibility(false);
                myPartner.setSoulStatus(SoulStatus.SYNCED);
                if(partnerRepository.count(myPartner.getId()) == 4)
                    myPartner.setVisibility(false);
                userRepository.update(myself, myself.getId());
                userRepository.update(myPartner, myPartner.getId());
                return true;
            }
            else {
                System.out.println("You can't make more than 1 partner");
                return false;
            }
        }
        return true;
    }
}
