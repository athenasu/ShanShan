package tw.idv.tibame.tfa104.shanshan.web.member.service;

import tw.idv.tibame.tfa104.shanshan.web.event.entity.Event;

public interface MemberEventService {
	
	// cancel event from event host end
		public Integer cancelEvent(Integer eventId);
		public Boolean deleteParticipation(Integer memberId, Integer eventId);
		public Integer confirmEvent(Event event);

}
