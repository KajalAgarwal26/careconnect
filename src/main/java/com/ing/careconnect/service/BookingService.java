package com.ing.careconnect.service;

import com.ing.careconnect.dto.UserSlotRequestDto;
import com.ing.careconnect.dto.UserSlotResponseDto;

public interface BookingService {
	
	public UserSlotResponseDto userSlot(UserSlotRequestDto userSlotRequestDto);
	

}
